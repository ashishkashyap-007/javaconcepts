# Java Streams Practice

A structured, hands-on guide to Java Streams and key functional programming prerequisites. This README catalogs the practice examples you already have and proposes additional exercises to deepen your understanding, from core operations and collectors to primitives and advanced features.

## How to Use This Practice
- Start with prerequisites (functional interfaces, lambdas, Optional) to build the foundation.
- Work through intermediate operations, then terminal operations and collectors.
- Run each example, modify it, and try edge cases noted below.
- Use the "Suggested Additions" sections to expand coverage and reinforce concepts.

---

## Prerequisites
Essential concepts to be comfortable with before diving deep into streams:
- Functional interfaces: `Predicate`, `Function`, `Consumer`, `Supplier`, `UnaryOperator`, `BinaryOperator`, `Comparator`, `BiFunction`, `BiConsumer`
- Lambdas and method references (static, instance, constructor ref)
- `Optional` basics (`of`, `ofNullable`, `empty`, `map`, `flatMap`, `orElse`, `orElseGet`)
- Primitive streams: `IntStream`, `LongStream`, `DoubleStream` and boxing/unboxing
- Creating streams: `Stream.of`, `Arrays.stream`, `Collection.stream`, `Files.lines`, `Stream.generate`, `Stream.iterate`, `Stream.ofNullable`
- Parallel streams: when to use and common pitfalls (ordering, side-effects)

Suggested exercises to add:
- Create a small `Predicate`/`Function`/`Consumer` playground showing composition (`and`, `or`, `negate`), and method references.
- Optional transformations and defaulting (e.g., `map`, `flatMap`, `orElseGet`).

---

## Intermediate Operations (existing)
- `FilterExample.java` — Predicate-based filtering
- `MapExample.java` — Transforming elements with `map`
- `FlatMapExample.java` — Flattening nested structures
- `DistinctExample.java` — Removing duplicates
- `PeekExample.java` — Debugging/intermediate inspection
- `SortedExample.java` — Sorting with natural order or custom comparator
- `LimitExample.java` — Truncating stream
- `SkipExample.java` — Skipping leading elements

Suggested additions:
- `takeWhile` and `dropWhile` (Java 9) — early termination based on condition
- `mapMulti` (Java 16) — efficient multi-mapping alternative to `flatMap`
- `concat` — merging two streams
- `ofNullable` — safe single-element stream from possibly-null value
- Primitives: `boxed` to convert primitive streams to object streams

Learning goals:
- Understand laziness, stateless vs stateful ops, and ordering semantics.
- Recognize when `flatMap` vs `mapMulti` matters for performance and clarity.

---

## Terminal Operations (existing)
- `ReduceExample.java` — Aggregating values with `reduce`
- `terminaloperations/CollectExample.java` — Collectors basics to lists/sets/maps
- `terminaloperations/GroupingByExample.java` — Grouping elements by classifier
- `terminaloperations/PartitioningByExample.java` — Boolean-based partitioning

Suggested additions:
- Matching and finding: `anyMatch`, `allMatch`, `noneMatch`, `findFirst`, `findAny`
- Numeric stats: `count`, `min`, `max`, primitives `sum`, `average`, `summaryStatistics`
- Arrays and ordered traversal: `toArray`, `forEach`, `forEachOrdered`
- Joining strings: `Collectors.joining`
- Java 16+: `toList()` terminal collector on `Stream`

Learning goals:
- Choose the right terminal op for aggregation, short-circuiting, and collection.

---

## Collectors (existing)
- `GroupingByExample.java` — Single-level grouping; try downstream collectors (e.g., `counting`, `mapping`).
- `PartitioningByExample.java` — Splits into `true`/`false` buckets.

Suggested additions:
- `mapping` and `flatMapping` — transform values within grouping/partitioning
- `collectingAndThen` — post-process collected result (e.g., make unmodifiable)
- Numeric summarizers: `summarizingInt/Long/Double`
- `joining` — concatenate strings with delimiter/prefix/suffix
- `toMap` with merge function and custom map supplier
- `teeing` (Java 12) — combine two downstream collectors into one result

Learning goals:
- Compose collectors to shape results exactly, avoid manual loops.

---

## Partitioning with Custom Keys
Example goal: partition a list of integers into even and odd, but present keys as custom strings (`"even"`, `"odd"`).

Approach 1: Post-process default boolean keys
```
Map<String, List<Integer>> partition = nums.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0)) // Map<Boolean, List<Integer>>
    .entrySet().stream()
    .collect(Collectors.toMap(
        e -> e.getKey() ? "even" : "odd",
        Map.Entry::getValue
    ));
```

Approach 2: Use `groupingBy` directly
```
Map<String, List<Integer>> partition = nums.stream()
    .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
```

Notes:
- `partitioningBy` is specifically for boolean classifiers; returns two buckets and guarantees both keys (true/false) exist.
- `groupingBy` is more general and supports arbitrary key types but creates only observed keys.

---

## Primitive Streams (suggested)
- `IntStream`, `LongStream`, `DoubleStream` pipelines with `summaryStatistics`, `sum`, `average`
- Conversion examples: `.mapToInt(...).boxed()` and vice versa
- Performance considerations: avoid boxing when doing numeric aggregation

---

## Advanced Features (suggested)
- `takeWhile`/`dropWhile` behavior on ordered streams
- `mapMulti` vs `flatMap` for multi-emission mapping
- Parallel streams: cost vs benefit, thread-safety, `forEachOrdered` for deterministic output

---

## Practice Paths
1. Warm-up: filter/map/distinct/sorted with small lists; add `peek` logs to see execution order.
2. Aggregation: try multiple `reduce` forms (identity, accumulator, combiner), then collector equivalents.
3. Collectors mastery: build nested `groupingBy` + `mapping`, add `collectingAndThen`.
4. Primitives: run `IntStream` stats, convert to boxed list, and back.
5. Advanced ops: implement `takeWhile`/`dropWhile` and compare results on different inputs.
6. Parallel experiments: run with `parallel()` and observe ordering and performance.

---

## Edge Cases to Try
- Empty streams: ensure terminal ops don’t throw (e.g., `min/max` return `Optional`).
- Null handling: prefer `ofNullable` and filter out `null` values early.
- Unordered vs ordered sources: impact on `distinct`, `sorted`, and short-circuiting.
- Duplicate keys in `toMap`: supply merge function to avoid `IllegalStateException`.
- Side effects: avoid mutating external state inside stream operations.

---

## What’s Already in This Directory
- `DistinctExample.java`
- `FilterExample.java`
- `FlatMapExample.java`
- `LimitExample.java`
- `MapExample.java`
- `PeekExample.java`
- `ReduceExample.java`
- `SkipExample.java`
- `SortedExample.java`
- `terminaloperations/CollectExample.java`
- `terminaloperations/GroupingByExample.java`
- `terminaloperations/PartitioningByExample.java`

---

## Suggested Files to Add
- `advanced/TakeDropWhileExample.java` — Demonstrates `takeWhile`/`dropWhile`
- `advanced/MapMultiExample.java` — Compares `mapMulti` and `flatMap`
- `collectors/TeeingCollectorExample.java` — Uses `Collectors.teeing` to combine results
- `collectors/SummarizingJoiningExample.java` — Shows `summarizingInt` and `joining`
- `primitive/PrimitiveStreamsExample.java` — Stats on `IntStream` and boxing
- `creation/StreamCreationExamples.java` — `of`, `generate`, `iterate`, `concat`, `ofNullable`
- `prerequisites/FunctionalInterfacesPlayground.java` — Compose predicates/functions/consumers
- `optional/OptionalPlayground.java` — Safe transformations and defaults

Each suggested file should include:
- Short description of the goal
- Key API calls
- 2-3 edge cases to try
- Console prints for quick verification

---

## Running Examples
This is a Maven project. Compile and run from your IDE, or with the terminal:
```
mvn -q -DskipTests compile
mvn -q exec:java -Dexec.mainClass=com.ashish.java.concepts.streams.practice.FilterExample
```
Replace the `-Dexec.mainClass` value with the class you want to run.

---

## References
- Java API docs: `java.util.stream.Stream`, `java.util.stream.Collectors`, `java.util.stream.IntStream`
- Effective Java (Joshua Bloch) — items on streams and lambdas
- Java Language Specification — lambdas and type inference

Use this README as a living guide—check off what you’ve practiced and expand with the suggested files over time.
