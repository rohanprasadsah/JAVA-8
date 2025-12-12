import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<String, String> bc1=(s1,s2)->System.out.println(s1+" "+s2);
        bc1.accept("Hello", "Java 8");

        //andThen()
        BiConsumer<String, String> bc2=(s1,s2)->System.out.println(s1.length()+" "+s2.length());
        bc1.andThen(bc2).accept("Hii", "Hello");
    }
}
