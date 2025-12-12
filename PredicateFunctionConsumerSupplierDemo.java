import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateFunctionConsumerSupplierDemo {
    public static void main(String[] args) {
        Predicate<Integer> p=x->x%2==0;
        Function<String,Integer> f=s->s.length();
        Consumer<Integer> c=x->System.out.println(x);
        Supplier<String> s=()->"Karana";

        if(p.test(f.apply(s.get()))){
            c.accept(f.apply(s.get()));
        }
        else{
            System.out.println("Odd String");
        }
    }
}
