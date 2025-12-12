import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorUsingLamda {
    public static void main(String[] args) {
        List<Integer> l=new ArrayList<>();
        l.add(15);
        l.add(5);
        l.add(12);
        l.add(9);
        l.add(10);
        System.out.println(l);
        Collections.sort(l);
        System.out.println(l);
        Collections.sort(l,(a,b)->b-a);     //Comparator implemnetation using Lambda expression
        System.out.println(l);
    }
}
