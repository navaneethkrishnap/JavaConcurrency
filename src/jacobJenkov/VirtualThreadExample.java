package jacobJenkov;

public class VirtualThreadExample {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            for(int i = 0; i < 10; i++){
                System.out.println("Number: "+ i);
            }
        };

        Thread virtualThread = Thread.ofVirtual().start(runnable);

        Thread unstartVThread = Thread.ofVirtual().unstarted(runnable);
        unstartVThread.start();

        try{
            unstartVThread.join();
        } catch (InterruptedException e){
            System.out.println("interrupted");
        }


    }
}
