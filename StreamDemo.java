import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        //Usig Streams to find the sum of even numbers
        int sum=Arrays.stream(arr).filter(x->x%2==0).sum();
        System.out.println(sum);

        //Creating Streams
        //1. Using List
        List<Integer> li = Arrays.asList(1,2,3,4,5);
        Stream<Integer> listStream=li.stream();

        //2. Using Arrays
        String[] arrs={"Apple","Banana","Mango","Orange","Pineapple"};
        Stream<String> arrayStream = Arrays.stream(arrs);

        //3. Using Stream.of()
        Stream<Integer> of = Stream.of(1,2,3,4,5,6);

        //4. Using Stream.iterate()
        Stream<Integer> iterateStream = Stream.iterate(0, x->x+1).limit(20);

        //5. Using Stream.generate()
        Stream<Integer> generateStream = Stream.generate(()->(int)(Math.random()*100)).limit(100)/**.forEach(System.out::println)**/;

        
        System.out.println("-----------------");


        //Stream Operations
        List<Integer> list = Arrays.asList(0,89,6,5,54,43,5,551,5,42,64,24,64);

        //filter()
        List<Integer> filteredList=list.stream().filter(x->x%2==0&&x>2).collect(Collectors.toList());
        System.out.println(filteredList);

        //map()
        List<Integer> mappedList = filteredList.stream().map(x->x/2).collect(Collectors.toList());
        System.out.println(mappedList);

        //distinct()
        List<Integer> distinctList = mappedList.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList);

        //sorted()
        List<Integer> sortedList = distinctList.stream().sorted((a,b)->b-a).collect(Collectors.toList());
        System.err.println(sortedList);

        //limit()
        List<Integer> limitedList = sortedList.stream().limit(4).collect(Collectors.toList());
        System.out.println(limitedList);

        //skip()
        List<Integer> skippedList = limitedList.stream().skip(1).collect(Collectors.toList());
        System.out.println(skippedList);

        System.out.println("-----------------");

        //All the above used operations together
        List<Integer> modifiedList=list.stream().filter(x->x%2==0&&x>2).map(x->x/2).distinct().sorted((a,b)->b-a).limit(4).skip(1).collect(Collectors.toList());
        System.out.println(modifiedList);
        
        //reduce()
        int reducedList=modifiedList.stream().reduce(0, (x,y)->x+y);
        System.out.println("reduce() : "+reducedList);

        //peek() -> peek() is an intermediate operation used mainly for debugging. It lets us view or print stream elements while processing, and it can be placed anywhere in the stream pipeline before a terminal operation.
        List<Integer> peekList=Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().filter(x->x%2==0).peek(System.out::println).map(x->x+1).collect(Collectors.toList());
        System.out.println(peekList);

        System.out.println("-----------------");

        //min, max, count
        int min=Arrays.asList(1,2,3,4,8,9,10).stream().min((a,b)->a-b).get();
        System.out.println("min : "+min);

        int max=Arrays.asList(1,2,3,4,8,9,10).stream().max((a,b)->a-b).get();
        System.out.println("max : "+max);

        long count=Arrays.asList(1,2,3,4,8,9,10).stream().count();
        System.out.println("count : "+count);

        System.out.println("-----------------");

        //anyMatch(), allMatch(), noneMatch()
        boolean anyMatch=Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().anyMatch(x->x%2==0);
        System.out.println("anyMatch : "+anyMatch);
        
        boolean allMatch=Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().allMatch(x->x%2==0);
        System.out.println("allMatch : "+allMatch);
        
        boolean noneMatch=Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().noneMatch(x->x%55==0);
        System.out.println("noneMatch : "+noneMatch);

        //flatMap()
        List<List<String>> listo = Arrays.asList(Arrays.asList("apple","banana"), Arrays.asList("kiwi","pomegranate"), Arrays.asList("orange","mango"));
        String[] listoArr = listo.stream().flatMap(x->x.stream()).map(String::toUpperCase).toArray(String[]::new);
        System.out.println(Arrays.toString(listoArr));

        List<String> listo2 = Arrays.asList("Hello World","JAVA Streams are powerful", "flatMap() is useful");
        String[] listo2Arr = listo2.stream().flatMap(x->Arrays.stream(x.split(" "))).toArray(String[]::new);
        System.out.println(Arrays.toString(listo2Arr));

        System.out.println("-----------------");
        
        //forEachOrdered() -> the forEachOrdered() method is similar to forEach(), but it guarantees that elements are processed in the same order as they appear in the stream even we are using parallel stream.
        List<Integer> asList = Arrays.asList(1,2,3,4,5);
        System.out.println("forEach() with parallel stream : ");
        asList.parallelStream().forEach(System.out::println);
        System.out.println("forEachOrdered() with parallel stream : ");
        asList.parallelStream().forEachOrdered(System.out::println);

        System.out.println("-----------------");

        //Streams cannot be reused after a terminal operation is applied.
        Stream<String> streeeeam = Arrays.asList("Check", "it", "will", "give", "llegalStateException").stream();
        streeeeam.forEach(System.out::println);
        List<String> list2 = streeeeam.map(String::toUpperCase).toList();
    }
}
