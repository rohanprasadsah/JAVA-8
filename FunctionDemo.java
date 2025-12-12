import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {

        //apply()
        Function<String, Integer> f1=x->x.length();
        System.out.println(f1.apply("iugasf"));

        Function<String, String> f2=x->x.substring(0, 3);
        System.out.println(f2.apply("substring"));

    
        Function<List<Student>, List<Student>> f3=x->{
           List<Student> fl=new ArrayList<>();
           for(Student s:x){
            if(s.getAge()>60){
                fl.add(s);
            }
           }
           return fl;
        };
        List<Student> l=Arrays.asList(new Student("Ram", 32), new Student("Sam", 2), new Student("Hari", 302));
        System.out.println(f3.apply(l));

        //andThen()
        Function<Integer, Integer> f4=x->2*x;
        Function<Integer, Integer> f5=x->x*x*x;
        System.out.println(f4.andThen(f5).apply(3));    //first f4 execute then f5
        System.out.println(f5.andThen(f4).apply(3));    //first f5 execute then f4
        
        //compose()
        System.out.println(f4.compose(f5).apply(3));    //first f5 execute then f4
        System.out.println(f5.compose(f4).apply(3));    //first f4 execute then f5

        //identity()
        Function<String, String> f6=Function.identity();
        System.out.println(f6.apply("Karan"));
    }

    private static class Student{
        String name;
        int age;
        public Student(String name, int age) {
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
        @Override
        public String toString() {
            return "name=" + name + " -> age=" + age;
        }
    }
}
