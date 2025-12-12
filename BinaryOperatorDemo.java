import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> bf=(x,y)->x+y;
        System.out.println(bf.apply(2, 3));

        System.out.println("-----------------");

        //We use BinaryOperator interface instead of BiFunction interface when the output type is same as input type
        //If the output type is different from input type then we use BiFunction interface instead of BinaryOperator
        BinaryOperator<Integer> bo=(x,y)->x*y;
        System.out.println(bo.apply(2, 3));
    }
}
