import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {

        //test()
        Predicate<Integer> predicate=a->a%2==0;
        System.out.println(predicate.test(1));
        System.out.println(predicate.test(2));

        System.out.println("-----------------");

        Person p=new Person("Ram", 18);
        Predicate<Person> p1=x->x.getAge()>10;
        System.out.println(p1.test(p));

        System.out.println("-----------------");
        
        Predicate<String> startsWithK=a->a.toLowerCase().charAt(0)=='k';
        Predicate<String> endsWithN=a->a.toLowerCase().charAt(a.length()-1)=='n';
        
        //and()
        Predicate<String> and=startsWithK.and(endsWithN);
        System.out.println(and.test("Karan"));
        
        System.out.println("-----------------");
        
        //or()
        Predicate<String> or=startsWithK.or(endsWithN);
        System.out.println(or.test("Kamal"));
        
        System.out.println("-----------------");

        //negate()
        Predicate<String> negate=startsWithK.negate();
        System.out.println(negate.test("Kamal"));
        
        System.out.println("-----------------");

        //isEqual()
        Predicate<Object> isEqual=Predicate.isEqual(2);
        System.out.println(isEqual.test(67));
    }
}

class Person{
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
}
