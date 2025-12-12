import java.util.function.Supplier;

public class ConstructorReferenceDemo {
    public static void main(String[] args) {
        Supplier<Majdoor> s1=()->new Majdoor("Hari");
        System.out.println(s1.get().getName());

        System.out.println("-----------------");

        Supplier<Majdoor> s2=Majdoor::new;
        System.out.println(s2.get().getName());
    }
}

class Majdoor{
    private String name;
    private String defname="Constructor Reference";
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Majdoor(String name) {
        this.name = name;
    }
    public Majdoor() {
        this.name = defname;
    }
    @Override
    public String toString() {
        return "Majdoor [name=" + name + "]";
    }
}