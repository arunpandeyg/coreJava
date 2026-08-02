public class Practice3 {
    //lambda function that Runnable
    public static void main(String[] args) {
        //before
         Runnable t1 = new Runnable() {
             @Override
             public void run() {
                 System.out.println("Thread 1: " );
             }
         };
         new Thread(t1).start();
    }
    //after
    Runnable t2 = () -> {System.out.println("Thread 2: ");};

}
