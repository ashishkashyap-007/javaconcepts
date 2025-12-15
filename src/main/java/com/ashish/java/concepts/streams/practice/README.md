# Java Streams Practice

Comprehensive practice material for Java Streams and key functional programming prerequisites. This guide documents implemented examples, organizes them into clear categories, and highlights additions to reach interview‑level mastery.

## Scope and Learning Goals
- Prerequisites: functional interfaces, lambdas and method references, Optional patterns, immutability and side effects
- Stream creation: common sources and generators
- Intermediate operations: transformation, filtering, ordering, and pipeline debugging
- Terminal operations: aggregation, collection, matching/finding, statistics
- Primitive streams: performance-conscious numeric pipelines
- Parallel streams: ordering guarantees, pitfalls, and safe usage

## Package Layout
`com.ashish.java.concepts.streams.practice`
- `prerequisites/` — Functional interfaces composition; method references; Optional usage
- `creation/` — Stream sources: `Stream.of`, `Arrays.stream`, `Collection.stream`, `Files.lines`, `generate`, `iterate`, `ofNullable`, `concat`
- `primitive/` — `IntStream`, `LongStream`, `DoubleStream`; boxing/unboxing; statistics
- `immutability/` — Pure transformations and side-effect risks within pipelines
- `parallel/` — Ordering, short-circuiting, thread-safety; performance considerations
- `intermediate/` — Core intermediate ops: `filter`, `map`, `flatMap`, `distinct`, `peek`, `sorted`, `limit`, `skip`
- `terminaloperations/` — Collectors and terminal ops: `collect`, `groupingBy`, `partitioningBy`, matching/finding, min/max/count, joining, arrays and traversal, primitive statistics
- `advanced/` (optional) — `takeWhile`, `dropWhile`, `mapMulti`, teeing collector, `toMap` patterns

## Implemented Examples
- Intermediate operations:
  - `intermediate/DistinctExample.java` — deduplication semantics
  - `intermediate/FilterExample.java` — predicate-based filtering
  - `intermediate/FlatMapExample.java` — flattening nested structures
  - `intermediate/LimitExample.java` — truncation
  - `intermediate/MapExample.java` — element transformation
  - `intermediate/PeekExample.java` — pipeline debugging/inspection
  - `intermediate/SkipExample.java` — leading-element omission
  - `intermediate/SortedExample.java` — natural and comparator-based ordering
- Stream creation:
  - `creation/StreamCreationExamples.java`
- Immutability and side effects:
  - `immutability/ImmutabilityAndSideEffects.java`
- Parallel streams:
  - `parallel/ParallelStreamsPitfalls.java`
- Prerequisites:
  - `prerequisites/FunctionalInterfacesPlayground.java`
  - `prerequisites/MethodReferencesExample.java`
  - `prerequisites/OptionalPlayground.java`
- Terminal operations:
  - `terminaloperations/CollectExample.java`
  - `terminaloperations/GroupingByExample.java`
  - `terminaloperations/PartitioningByExample.java`
  - `terminaloperations/MatchingAndFindingExample.java`
  - `terminaloperations/MinMaxCountExample.java`
  - `terminaloperations/PrimitiveAndStatisticsExample.java`
  - `terminaloperations/ForEachAndToArrayExample.java`
  - `terminaloperations/JoiningAndToListExample.java`
  - `terminaloperations/ReduceExample.java`

## Recommended Additions for Completeness
- Advanced intermediate:
  - `advanced/TakeDropWhileExample.java` — ordered stream behavior
  - `advanced/MapMultiExample.java` — multi-emission mapping vs `flatMap`
- Collectors:
  - `collectors/TeeingCollectorExample.java` — combine two downstream collectors
  - `collectors/ToMapMergeSupplierExample.java` — merge function and map supplier patterns
  - `collectors/SummarizingMappingExample.java` — `summarizingInt/Long/Double`, `mapping`, `flatMapping`, `collectingAndThen`
- Primitives:
  - `primitive/PrimitiveStreamsExample.java` — dedicated numeric pipelines and boxing/unboxing

## Notes on Partitioning vs Grouping
- `partitioningBy` targets boolean classifiers and guarantees both buckets (`true`/`false`).
- Custom-labeled buckets use `groupingBy` with a classifier or post-process `partitioningBy` boolean keys.

## Preparation Checklist
- Functional interfaces: `Predicate`, `Function`, `Consumer`, `Supplier`, `UnaryOperator`, `BinaryOperator`, `Comparator`, `BiFunction`, `BiConsumer`
- Lambdas and method references: static, instance, constructor
- Optional: `of/ofNullable/empty`, `map/flatMap/filter`, defaulting and error signaling
- Stream creation: collections, arrays, files, generators (`generate`/`iterate`), `ofNullable`, `concat`
- Intermediate ops: stateless vs stateful; ordering; laziness
- Terminal ops: reduce; matching/finding; collectors (`toList`, `groupingBy`, `partitioningBy`, `joining`); min/max/count; `toArray`; `forEach/forEachOrdered`
- Primitive streams: `mapToInt/Long/Double`; `sum`, `average`, `summaryStatistics`; avoiding boxing when aggregating
- Parallel streams: short-circuit behavior, ordering guarantees, side effects
- Immutability: pure pipelines vs external mutation

## Run
PowerShell, Maven:
```
mvn -q -DskipTests compile
mvn -q exec:java -Dexec.mainClass=com.ashish.java.concepts.streams.practice.intermediate.FilterExample
mvn -q exec:java -Dexec.mainClass=com.ashish.java.concepts.streams.practice.terminaloperations.MatchingAndFindingExample
```

## References
- `java.util.stream.Stream`, `java.util.stream.Collectors`, `java.util.stream.IntStream`
- Effective Java (Bloch) — Streams and lambdas
- Java Language Specification — Lambda expressions and type inference
