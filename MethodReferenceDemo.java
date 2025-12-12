import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void m1(String s){
        System.out.println(s);
    }
    public void m2(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        List<String> Students = Arrays.asList("Vir","Ram","Shyam");

        //Students.forEach(s->System.out.println(s));
        
        //Method Reference for static method
        Students.forEach(MethodReferenceDemo::m1);
        //Method Reference for instance method
        Students.forEach(new MethodReferenceDemo()::m2);
    }
}
