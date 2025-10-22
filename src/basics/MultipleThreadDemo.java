package basics;

class Example implements Runnable{
    String name;
    Thread t;

    Example(String tname){
        name = tname;
        t = new Thread(this, name);
        System.out.println("New Thread: "+ t);
        t.start();
    }

    public void run(){
        try{
            for(int i = 5; i > 0; i--){
                System.out.println(name + " : "+ i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println(name+" Interrupted");
        }
        System.out.println(name + " exited..");
    }
}

public class MultipleThreadDemo {
    public static void main(String[] args) {
        new Example("One");
        new Example("Two");
        new Example("Three");

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting");
    }
}
