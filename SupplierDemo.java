import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> s=()->"No input only output";
        System.out.println(s.get());
    }
}
