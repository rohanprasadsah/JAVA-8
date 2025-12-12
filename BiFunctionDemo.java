import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionDemo {
    public static void main(String[] args) {
        BiFunction<String, String, Integer> bf1=(s1,s2)->s1.length()+s2.length();
        System.out.println(bf1.apply("Hello", "World"));

        //andThen()
        Function<Integer,Integer> f1=x->2*x;
        System.out.println(bf1.andThen(f1).apply("ho", "hoi"));
    }
}
