public class Main {
    public static void main(String[] args) {
        FInterface se=()-> "Hello sde";
        System.out.println(se.sayHi());
        FInterface ed=()->"Editor";
        System.out.println(ed.sayHi());
    }
}
