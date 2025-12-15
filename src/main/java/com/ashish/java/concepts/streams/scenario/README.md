# E-commerce Order Analytics & Anomaly Detection — Stream API Scenario

A single, end-to-end scenario designed to practice advanced Java Stream API usage on realistic data. Build an analytics pipeline that ingests multiple sources, performs joins and reductions, computes KPIs, detects anomalies, and produces deterministic, interview-grade outputs.

## Context
You operate a retail platform with customers purchasing products via orders. Each order has items, payments, and shipments. Separately, clickstream events capture customer behavior (views, cart adds, checkouts, purchases). The goal is to implement robust, efficient, and correct stream-based analytics.

## Data Sources (files under `src/main/resources/ecommerce`)
- `customers.csv` — `id,name,region`
- `products.csv` — `id,name,category,price`
- `orders.csv` — `id,customerId,createdAt(ISO-8601),status`
- `order_items.csv` — `orderId,productId,quantity,unitPrice`
- `payments.csv` — `orderId,amount,method,status(OK|REFUND)`
- `shipments.csv` — `orderId,warehouse,shippedAt(ISO-8601),deliveredAt(ISO-8601)`
- `logs/events.log` (NDJSON) — `ts(ISO-8601),customerId,type(VIEW|ADD_TO_CART|CHECKOUT|PURCHASE),productId`

Notes
- Treat all files as untrusted: rows may be malformed, missing fields, or contain invalid values.
- Use lazy file streaming (e.g., `Files.lines`) and avoid loading entire files into memory.

## Scope
Implement an analytics module that:
- Parses inputs safely and reports invalid rows.
- Joins orders with related entities into aggregates.
- Computes business KPIs (revenue, top products, fulfillment latency, retention, funnels).
- Benchmarks sequential vs parallel performance where safe.
- Enforces determinism and correctness with clear tie-breakers and invariants.

## Functional Requirements
1) Robust parsing and validation
- Stream CSV/NDJSON lines; map to domain objects; filter or capture malformed rows.
- Produce a small error report (counts per file; optionally sample offending lines).

2) Order enrichment join
- Build `OrderAggregate` for each order: join items, products, payments, shipments.
- Resolve duplicates deterministically. Missing associations are allowed but must not crash the pipeline.

3) Net revenue by region and day
- Net revenue = Σ(items.quantity × unitPrice) − Σ(refunds).
- Output: `Map<LocalDate, Map<String /*region*/, Double>>` with stable iteration order by date.

4) Top-5 products by net revenue per region (deterministic ties)
- Comparator: revenue desc, then product name asc, then product id asc.
- Output per region as an ordered map preserving the computed order.

5) Fulfillment lead time analytics
- For delivered orders, compute delivery lead time in hours `(deliveredAt − shippedAt)`.
- For each warehouse: median and p90 lead time; identify outliers via z-score > 2.0.

6) Customer retention
- Per region: fraction of customers with a second order within 30 days of first purchase.
- Churned customers: no orders in the last 90 days relative to the max order date in data.

7) Funnel from events.log
- For each region, counts and conversion rates across VIEW → ADD_TO_CART → CHECKOUT → PURCHASE.
- Purchase counts must not exceed checkout counts, etc.

8) Parallel streams where safe
- For large inputs, compare sequential vs parallel for revenue and top-5 calculations.
- Use concurrent collectors where ordering is not required; document trade-offs.

9) Custom Top-K collector (stable)
- Implement a collector that returns top K elements by comparator without materializing all elements.
- Must be combiner-safe and return a stable, deterministic order.

10) Determinism and correctness
- All outputs must be reproducible across runs; define and apply tie-breakers.
- Pipelines must be free of external side effects.

## Acceptance Criteria
- Parsing: invalid rows are excluded and reported; counts of parsed vs invalid match file contents.
- Revenue: totals equal Σ(order item subtotals) minus Σ(refunds); zero when only refunds exist for an order.
- Top-5 per region: sorted by revenue desc, name asc, id asc; iteration order deterministic.
- Lead time: median and p90 computed per warehouse; outliers flagged via z-score > 2.0; empty groups handled safely.
- Retention: repeat purchase rate = fraction with a second order within 30 days; churn excludes customers with any order in last 90 days.
- Funnel: PURCHASE ≤ CHECKOUT ≤ ADD_TO_CART ≤ VIEW per region; conversion rates in [0,1].
- Parallel equivalence: aggregates equal between sequential and parallel (ignoring order where concurrency is used).
- Custom Top-K: matches baseline sort+limit results; finisher returns a stable list.

## Non-Functional Requirements
- Efficiency: avoid unnecessary materialization; prefer primitive streams for numeric reductions.
- Resource safety: close files via try-with-resources or stream-managed auto-close.
- Scalability: demonstrate performance on ≥1M synthetic records; document thresholds where parallel outperforms sequential.
- Determinism: never rely on incidental ordering; always use explicit comparators and `LinkedHashMap` when order matters.

## Implementation Notes
- Build lookup structures up front (e.g., `productsById`, `customersById`, `itemsByOrderId`, `paymentsByOrderId`).
- Use `Collectors.teeing(summarizingDouble, counting, combiner)` to produce combined summaries efficiently.
- For windowed comparisons (e.g., retention timelines), zip indices with `IntStream.range` and compare neighbors.
- Median: for small groups, sort and select; for larger streams, use a two-heap helper.
- Prefer `mapToInt/Long/Double` for numeric ops; avoid boxing when aggregating.
- Use `toMap` with a merge function and `LinkedHashMap::new` when preserving encounter order is required.
- Keep functions pure; use `peek` only for transient debugging.

## Suggested Package Layout
`src/main/java/com/ashish/java/concepts/streams/scenario/ecommerce`
- `domain/` — `Customer`, `Product`, `Order`, `OrderItem`, `Payment`, `Shipment`, `Event`
- `aggregate/` — `OrderAggregate`, `RevenueSummary`, `TopProduct`, `LeadTimeStats`
- `io/` — CSV/NDJSON loaders using `Files.lines`
- `analytics/` — pure functions implementing requirements 3–10
- `EcommerceAnalyticsScenario` — minimal runner for manual checks

## Deliverables
- Domain and aggregate classes; loader utilities; analytics functions; scenario runner.
- A small error report for parsing (counts + optional samples).
- Unit tests covering happy paths, edge cases (empty/malformed/duplicates), and determinism.
- Optional property-based tests for invariants (e.g., `min ≤ avg ≤ max`, frequency sums, Top-K equivalence).

## Stretch Goals
- Category seasonality: apply `takeWhile`/`dropWhile` on date-sorted metrics.
- Use `mapMulti` to emit zero/one/many derived records from events/items efficiently.
- Deterministic top-100 words from clickstream payloads with bounded memory and `Files.lines`.
- Cohort LTV by signup month with stable grouping and bounded-memory Top-K.
