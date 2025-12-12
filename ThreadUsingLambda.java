public class ThreadUsingLambda {
    public static void main(String[] args) {
        Runnable r=()->{
            for(int i=0;i<=5;i++){
                System.out.println("Hello "+i);
            }
        };
        Thread t=new Thread(r);
        for(int i=0;i<=5;i++){
            System.out.println("Bye "+i);
        }
        t.start();
    }
}
