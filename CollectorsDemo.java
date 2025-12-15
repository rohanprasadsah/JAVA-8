import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        //Collectors is a utility class in java that provides a set of static methods for creating collectors.

        //1. Collecting to a List
        List<Integer> list = Arrays.asList(1,2,3,4,5).stream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println(list);

        //2. Collecting to a Set
        Set<Integer> set = Arrays.asList(1,2,3,2,5).stream().collect(Collectors.toSet());
        System.out.println(set);

        //3. Collecting to a specific collection
        ArrayDeque<Integer> arrayDeque = Arrays.asList(1,2,3,4,5).stream().collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println(arrayDeque);

        //4. Joining Strings -> concatenates stream elements into a single String.
        String joinedCollectionAsString = Arrays.asList("hi", "how", "are", "you", "?").stream().collect(Collectors.joining(". "));
        System.out.println(joinedCollectionAsString);

        //5. Summaraizing data -> Generates statistical summary of the data in the stream such as count, sum, min, max, average, etc.
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        IntSummaryStatistics summarizedStats = nums.stream().collect(Collectors.summarizingInt(x->x));
        System.out.println("Count: " + summarizedStats.getCount());
        System.out.println("Sum: " + summarizedStats.getSum());
        System.out.println("Min: " + summarizedStats.getMin());
        System.out.println("Max: " + summarizedStats.getMax());
        System.out.println("Average: " + summarizedStats.getAverage());

        //6. calculating Avg
        Double avg = nums.stream().collect(Collectors.averagingInt(x->x));
        System.out.println("Avg: " + avg);

        //7. calculating sum
        int sum = nums.stream().collect(Collectors.summingInt(x->x));
        System.out.println("Sum: " + sum);

        //8. calculating count
        long count = nums.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        //9. Grouping Elements
        List<String> words = Arrays.asList("hello", "world", "everything", "good", "java");

        // System.out.println(words.stream().collect(Collectors.groupingBy(x->x.length())));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));

        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(". "))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));
        
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length,TreeMap::new,Collectors.counting()));
        System.out.println("TreeMap: " + treeMap);  //TreeMap is sorted by keys

        //10. Partitioning elements -> Partitions elements into two groups (true or false) based on a predicate.
        Map<Boolean, List<String>> partition = words.stream().collect(Collectors.partitioningBy(x->x.length()>4));
        System.out.println("Partition: " + partition);

        Map<Boolean,Long> partition0 = words.stream().collect(Collectors.partitioningBy(x->x.length()>4, Collectors.counting()));
        System.out.println("Partition0: " + partition0);

        //11. Mapping & Collecting -> Maps elements of the stream to another type and then collects them into a new collection.
        List<String> mapCollect = words.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
        System.out.println("MapCollect: " + mapCollect);

        System.out.println("-----------------");

        //Example 1 : Collecting names by length
        List<String> l1 = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));

        // Example 2: Counting Word Occurrences
        String sentence = "hello world hello java world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x->x, Collectors.counting())));

        // Example 3: Partitioning Even and Odd Numbers
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x->x%2==0)));

        // Example 4: Summing Values in a Map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);
        System.out.println(items.entrySet().stream().collect(Collectors.summingInt(x->x.getValue())));
        System.out.println(items.values().stream().reduce(0,(x,y)->x+y));
        System.out.println(items.values().stream().reduce(Integer::sum).get());

        // Example 5: Creating a Map from Stream Elements
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(x->x, String::length)));

        //Example 6
        List<String> fruits2 = Arrays.asList("Apple", "Banana","Apple", "Cherry", "Apple", "Banana");
        System.out.println(fruits2.stream().collect(Collectors.toMap(x->x, v->1, (x,y)->x+y)));
    }   
}
