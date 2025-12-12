import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c=s->System.out.println(s.length());
        c.accept("karan");
        
        System.out.println("-----------------");

        Consumer<List<Integer>> cl=l->{
            for(Integer i:l){
                System.out.println(i*10);
            }
        };
        cl.accept(Arrays.asList(1,2,3,4,5));

        System.out.println("-----------------");

        Consumer<List<Integer>> cl1=l->{
            for(Integer i:l){
                System.out.println(i*2);
            }
        };
        cl.andThen(cl1).accept(Arrays.asList(1,2,3,4,5));
    }
}
