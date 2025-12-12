import java.util.function.BiPredicate;

public class BiPredicateDemo {
    public static void main(String[] args) {
        BiPredicate<Integer,Integer>bp1=(x,y)->x%2==0&&y%2==0;
        System.out.println(bp1.test(2,4));

        BiPredicate<String, Integer> bp2=(s,x)->s.length()==x;
        System.out.println(bp2.test("Karan", 5));

        //and()
        System.out.println();
    }
}
