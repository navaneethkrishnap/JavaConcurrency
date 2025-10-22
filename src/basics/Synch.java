package basics;

class CallMe{
    // this call method is not synchronised so multiple threads which invokes this method will
    // race to finish the method -- this condition is called race condition

//    void call(String msg){
//        System.out.print("["+ msg);
//        try{
//            Thread.sleep(1000);
//
//        } catch (InterruptedException e){
//            System.out.println("interrupted");
//        }
//        System.out.println("]");
//    }

    // synchronised and race condition is eliminated
    synchronized void call(String msg){
        System.out.print("["+ msg);
        try{
            Thread.sleep(1000);

        } catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable{
    String msg;
    CallMe target;
    Thread t;

    public Caller(CallMe tar,  String s){
        target = tar;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run(){
        target.call(msg);
    }
}

public class Synch {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target,"hello");
        Caller ob2 = new Caller(target, "synchronised");
        Caller ob3 = new Caller(target, "world");

        try{
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
}
