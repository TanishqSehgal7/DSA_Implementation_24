package Java8_Stream_Lambdas_FunctionalPrograming;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Stream API was introduced in Java 8 amd allowed devs to 
		 * work with collections and sequences of data. It provides a way 
		 * to process data in a pipeline where operations can be applied to
		 * data elements one by one.
		 * 
		 * Stream supports sequential and parallel operations allowing you
		 * to take advatage of multi core processors
		 * 
		 * Stream does not store data rather it operates on data and streams
		 * are lazily evaluated, meaning operations are not performed until
		 * results are not needed.
		 * 
		 * Once a stream is operated upon, it gets closed immediately and cannot be used
		 * again, otherwise the compiler throws an error. But we can chain different 
		 * methods in one go in order to created multiple kinds of stream outputs 
		 * at once.
		 * 
		 * 
		 * Types of Stream:
		 * 
		 * 1. Sequential Stream: operations are performed in sequential order
		 * 2. Parallel Stream: operations are performed in paralle to leverage multi-core processors
		 * 
		 * 
		 * Advantages of Stream API
			1. Functional Programming: Encourages a functional programming approach with concise and 
				readable code.
			2. Parallel Processing: Easily process data in parallel using parallelStream().
			3. Laziness: Intermediate operations are lazily executed, optimizing performance by processing 
				data only when necessary.
			4. Immutability: Stream operations do not modify the source collection but instead return a 
				new stream.
				
			Stream Limitations
				Once Consumed, Can't Be Reused: Once a terminal operation is applied, the stream is closed.
				Not Suitable for Modifying Data: Streams are not designed for mutating or modifying 
				the source data.
				*/
		
		List<String> fruits = List.of("Apple", "Banana", "Kiwi", "Strawberry", "Mango");
		Stream<String> fruitStream = fruits.stream();
		
		fruitStream.forEach((fruit) -> {
			System.out.println(fruit);
		});
		
		List<Integer> numbers = List.of(4,2,6,7,8,8,9,45,2,5,5,7,8,2,34,34,56,52);
		
		List<Integer> uniqueList = numbers.stream()
				.sorted()
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println("\nList with unique elements:");
		uniqueList.forEach((number) -> System.out.print(number +" "));
		// gives sorted list with unique elements
		
		System.out.println('\n');
		
		List<Integer> doubleNumbers = numbers.stream()
				.sorted()
				.distinct()
				.map((number) -> number*2)
				.collect(Collectors.toList());
		
		System.out.println("\nList with values doubled");
		doubleNumbers.forEach((number) -> System.out.print(number + " "));
		// gives sorted list with unique elements, each element mapped to twice of itself
		
		System.out.println('\n');
		
		List<Integer> numbersGreaterThanTen = numbers.stream()
		.sorted()
		.distinct()
		.map((number) -> number*2)
		.filter((number) -> number > 10)
		.collect(Collectors.toList());
		
		System.out.println("\nList with values greater than 10");
		numbersGreaterThanTen.forEach((number) -> System.out.print(number + " "));
		// gives sorted list with unique elements with values > 10
		
		System.out.println('\n');
		
		int sum = numbers.stream()
				.reduce(0, (a,b) -> a+b);
		System.out.println("\nSum of " + numbers + " is: " + sum);
		
		// convert list into a map
		// lambdas in Java do not allow mutable state across invocations. so we cannot send count++ as key
		AtomicInteger autoKeyGen = new AtomicInteger(0);
		Map<Object, Object> map = numbers.stream()
										 	.sorted()
										 	.distinct()
										 	.collect(Collectors.toMap(
										 			key -> autoKeyGen.getAndIncrement(), 
										 			value -> value));
		
		System.out.println("\nList Converted to map");
		System.out.println(map);		
		
	}
}