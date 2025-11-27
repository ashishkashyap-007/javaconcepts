# Stream API Practice Scenarios

A professional, interview-focused learning path for mastering the Java Stream API. The scenarios progress from fundamentals to advanced, reflecting real-world data processing tasks and common interview questions.

## Objectives
- Build fluency with stream creation, intermediate operations, and terminal operations.
- Apply collectors for reduction, grouping, partitioning, and mapping.
- Design correct, efficient, and side-effect-free pipelines.
- Handle files, large datasets, and performance considerations.
- Recognize and avoid common pitfalls that impact correctness and scalability.

## Getting Started
- Java 17 or later recommended.
- Create package `com.ashish.java.concepts.streams` for domain models and exercises.
- Place scenarios and solutions under `streams` and `streams.scenario`.
- Run exercises via a main class or unit tests.

## Dataset and Domain
Use a simple `Employee` domain model for most exercises:
- Fields: `id:int`, `name:String`, `department:String`, `salary:double`.
- Departments: Engineering, Sales, HR.
- Provide a static `sample()` list for reproducible results, plus utilities to generate larger lists.

Optionally, prepare input files under `src/main/resources`, e.g., `employees.csv`, `events.log`, and `transactions.json`.

## Learning Path and Exercises

### 1. Fundamentals
Covers creation, mapping, filtering, sorting, and reduction.
1. Given a list of integers, return squares of even numbers, sorted descending. Compute sum and average.
2. Tokenize a sentence into words; produce a frequency map of lowercase words. Sort by frequency, then alphabetically.
3. Normalize names (trim, title-case) and deduplicate while preserving original insertion order.
4. Compute sum, min, max, average, and count using `mapToInt`/`mapToDouble` and `summaryStatistics`.
5. Validate inputs: filter out nulls and blanks safely using `Objects::nonNull` and `String#isBlank`.

### 2. Collectors and Reductions
Focuses on `Collectors` composition and downstream collectors.
1. Group employees by department and compute average salary per department.
2. Partition employees into high earners vs others using a cutoff. Return counts per partition.
3. Produce `Map<Department, List<String>>` of top 3 employee names by salary.
4. Build `Map<String, Double>` of total salary spend per department using `summingDouble`.
5. Create a `LinkedHashMap<String, Long>` of word frequencies sorted by descending count, then key, using `toMap` with custom merge and map supplier.

### 3. Transformations and Joins
Real-world collection joins and enrichments.
1. Join employees with a list of projects on employee id; produce an assignment summary per department.
2. Transform CSV rows to domain objects; filter invalid records; enrich with derived fields (e.g., seniority tier by salary).
3. Build a report of departments with the number of distinct contributors per project.
4. Create a lookup of `(department|name)` → `Employee` keeping the highest salary when duplicates occur (composite key deduplication).

### 4. Custom Collectors and Advanced Reduction
Deeper control over reduction and collector behavior.
1. Implement a custom collector to produce salary stats: min, max, sum, average, count.
2. Implement a collector that builds an immutable index `Map<String, Employee>` with defensive copies.
3. Create a multi-bucket collector that groups salaries into ranges (e.g., `<100k`, `100–130k`, `>130k`) and counts occurrences.

### 5. Files, I/O, and Streaming Large Data
Lazy processing and resource safety.
1. Stream `events.log` line-by-line; count lines containing "error" without loading the file into memory.
2. Parse `employees.csv` with `Files.lines` and `split`, handling malformed rows. Produce a department salary summary.
3. Extract the top 100 most frequent words from a large text corpus; output to `word_freq.csv`.
4. Process NDJSON lines (one JSON object per line): filter, map to domain, aggregate metrics.

### 6. Parallel Streams and Performance
Measure and reason about parallelism.
1. Compare sequential vs parallel processing when calculating aggregated salary stats for a large synthetic dataset (≥ 1,000,000 records). Capture timings.
2. Identify sources of contention (e.g., synchronized collections) and refactor to avoid shared mutable state.
3. Use `Collectors.groupingByConcurrent` where applicable; discuss trade-offs and correctness implications.

### 7. Correctness, Order, and Stability
Make pipelines deterministic and safe.
1. Contrast stateful vs stateless lambdas. Demonstrate why mutating external lists in `map`/`forEach` is incorrect.
2. Ensure stable ordering for top-N queries by sorting with secondary keys and preserving encounter order with `toList()`.
3. Use `distinct()` correctly for domain objects by defining `equals`/`hashCode` or deduplicating via keys.
4. Handle `Optional` properly: chain `findFirst()`, `map()`, and `orElseThrow()` with clear failure messages.

### 8. Statistics and Anomaly Detection
Data insights beyond simple aggregations.
1. Compute z-scores of salaries per department and flag employees above mean by more than two standard deviations.
2. Compute median salary per department using two-pass strategy or balanced heaps.
3. Identify departments where salary variance exceeds a threshold; sort by variance descending.

### 9. Testing and Validation
Establish reliability with unit tests.
1. Write JUnit tests for each exercise: happy path, edge cases (empty input, nulls, malformed lines).
2. Property-based tests for frequency maps (sum of counts equals token count; invariant under whitespace changes).
3. Deterministic ordering tests for top-N queries using fixed samples.

## Success Criteria
- Correctness: pipelines produce expected outputs for happy paths and edge cases.
- Determinism: results are stable and reproducible given the same inputs.
- Efficiency: no unnecessary materialization; appropriate use of primitive streams and short-circuiting.
- Safety: no shared mutable state; resources closed via try-with-resources or stream-managed closing.

## Implementation Notes
- Prefer stateless lambdas and pure functions.
- Choose `mapToInt`/`mapToDouble` for numeric reductions to avoid boxing overhead.
- Use `collectingAndThen` for post-processing when needed.
- For sorting maps by values, build entries stream and collect back to a `LinkedHashMap`.
- Avoid side effects inside `map`/`filter`; use `peek` only for debugging.
- Validate input lines in file scenarios; log or collect invalid rows for reporting.

## Sample Outputs
- Average salary by department: `{Engineering=140500.0, Sales=104333.3, HR=87666.7}`.
- Top 3 names per department: `{Engineering=[Eve, Alice, Ivan], Sales=[Heidi, Frank, Cathy], HR=[Grace, Judy, Dan]}`.
- Word frequencies: sorted list with counts and cumulative totals.

## Extension Ideas
- Introduce `Project`, `Assignment`, and `Team` domain models; practice multi-way joins.
- Add caching/memoization for expensive derived fields; discuss placement outside streams.
- Explore `Stream.iterate` and `Stream.generate` for synthetic data and performance experiments.

## How to Run
- Implement scenarios in classes under `streams` and invoke them from a `main` method.
- For file-based scenarios, add input files to `src/main/resources` and pass relative paths.
- Use IDE run configurations or a build tool to execute and observe results.

## Deliverables
- Domain models and utilities for sample data.
- Scenario implementations and unit tests.
- Optional scripts to generate large synthetic datasets for performance testing.

