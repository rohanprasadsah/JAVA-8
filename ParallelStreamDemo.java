import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        //Using Stream
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x->x+1).limit(30000).toList();
        List<Integer> list2 = list.stream().map(ParallelStreamDemo::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Sequetial Stream " + (endTime - startTime));

        //using PrallelStream
        startTime = System.currentTimeMillis();
        List<Integer> pslist = Stream.iterate(1, x->x+1).limit(30000).toList();
        List<Integer> pslist2 = list.parallelStream().map(ParallelStreamDemo::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel Stream " + (endTime - startTime));
    }

    public static int factorial(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
}
