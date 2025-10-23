package jacobJenkov;

import static java.lang.Thread.sleep;

public class ThreadExample9 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            while(true){
                sleep(1000);
                System.out.println("Child thread is running.");
            }
        };
        Thread t = new Thread(runnable);
        System.out.println("main thread executes this");System.out.println("now I am using -- setDaemon() --");
        t.setDaemon(true);
        t.start();
        System.out.println("main thread executes this also");
        sleep(3000);
        System.out.println("main thread now stops");
//        System.out.println("now I am using -- setDaemon() --");
//        t.setDaemon(true);
    }


    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("thread interrupted");
        }
    }
}
