import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ConstructorReferenceDemo {
    public static void main(String[] args) {
        Supplier<Majdoor> s1=()->new Majdoor("Hari");
        System.out.println(s1.get().getName());

        System.out.println("-----------------");

        Supplier<Majdoor> s2=Majdoor::new;
        System.out.println(s2.get().getName());

        System.out.println("-----------------");

        List<String> l=Arrays.asList("Rit","Mit","Hit");
        List<Majdoor> newList = l.stream().map(Majdoor::new).collect(Collectors.toList());
        System.out.println(newList);
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