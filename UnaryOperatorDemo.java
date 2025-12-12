import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        Function<Integer,Integer> f=x->x+x;
        System.out.println(f.apply(2));

        System.out.println("-----------------");

        //We use UnaryOperator interface instead of Function interface when the output type is same as input type
        //If the output type is different from input type then we use Function interface instead of UnaryOperator
        UnaryOperator<Integer> uo=x->x+x;
        System.out.println(uo.apply(3));
    }
}
