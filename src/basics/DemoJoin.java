package basics;

public class DemoJoin {
    public static void main(String[] args) {
        Example ob1 = new Example("One");
        Example ob2 = new Example("two");
        Example ob3 = new Example("three");

        System.out.println("Thread One is alive: "+ ob1.t.isAlive());
        System.out.println("Thread Two is alive: "+ ob2.t.isAlive());
        System.out.println("Thread three is alive: "+ ob3.t.isAlive());

        try{
            System.out.println("Waiting for threads to finish...");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e){
            System.out.println("main thread interrupted");
        }
        System.out.println("thread one is alive: "+ ob1.t.isAlive());
        System.out.println("thread two is alive: "+ ob2.t.isAlive());
        System.out.println("thread three is alive: "+ ob3.t.isAlive());

        System.out.println("Main thread exiting..");
    }
}
