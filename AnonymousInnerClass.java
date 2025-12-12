public class AnonymousInnerClass {
    public static void main(String[] args) {
        AII a=new AII(){
            @Override
            public String getName() {
                return "Software Engineer";
            }
            @Override
            public int getSal() {
                return 100;
            }
        };
        System.out.println(a.getName());
        System.out.println(a.getSal());
    }
}
