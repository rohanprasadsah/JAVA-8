import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreamDemo {
    public static void main(String[] args) {
        //Since we created the array using primitive data type 'int' so if we create stream using it then it will be of type IntStream
        int[] num={1,2,3,4,5};
        IntStream s1 = Arrays.stream(num);

        //To get Stream instead of IntStream we have to use 'boxed()' method
        Stream<Integer> s2 = Arrays.stream(num).boxed();

        //but if we create the Array using wrapper class 'Integer' instead of primitive data type 'int' then it will be of type Stream<Integer>
        Integer[] num2={1,2,3,4,5};
        Stream<Integer> s3 = Arrays.stream(num2);

        //IntStream.range() -> returns a stream of integers from start to end (start inclusive, end exclusive)
        System.out.println(IntStream.range(1, 8).boxed().collect(Collectors.toList()));

        //IntStream.rangeClosed() -> returns a stream of integers from start to end (start inclusive, end inclusive)
        System.out.println(IntStream.rangeClosed(1, 8).boxed().collect(Collectors.toList()));

        //IntStream.of() -> returns a stream of integers
        IntStream of = IntStream.of(1,2,3,4,5);

        //Random -> Random is a class in java.util package that provides methods for generating streams of random numbers.
        //new Random().doubles() -> new Random().doubles() returns an infinite DoubleStream of values between 0.0 and 1.0 if streamSize is not specified
        DoubleStream doubles = new Random().doubles(5);
        System.out.println(doubles.boxed().collect(Collectors.toList()));

        //new Random().ints() -> new Random().ints() returns an infinite IntStream of random int values covering the full int range (Integer.MIN_VALUE to Integer.MAX_VALUE)
        IntStream ints = new Random().ints(5);
        // System.out.println(ints.sum());
        // System.out.println(ints.max());
        // System.out.println(ints.min());
        // System.out.println(ints.average());
        // System.out.println(ints.count());
        System.out.println(ints.summaryStatistics());
        // here we used the stream so if we try try to reuse it then it will give an exception
        // System.out.println(ints.boxed().collect(Collectors.toList()));

        
        //mapToInt() -> returns a stream of integers by mapping each element of the source stream to an int value using the provided function
        DoubleStream doubles2 = new Random().doubles(5);
        System.out.println("doubles.mapToInt() : " + doubles2.mapToInt(x->(int)(x)).boxed().collect(Collectors.toList()));
    }
}
