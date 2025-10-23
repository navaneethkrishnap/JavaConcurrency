package jacobJenkov;

public class ThreadExample10 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for(int i = 0; i < 5; i++){
                sleep(1000);
                System.out.println("running");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        System.out.println("This is executed by non-daemon thread after executing non-daemon threads" +
                "the jvm will kill all daemon threads " +
                "then kill itselfs ");

        try{
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }
    }

    public static void sleep(long  millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }
    }
}
