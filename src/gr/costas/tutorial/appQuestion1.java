package gr.costas.tutorial;

public class appQuestion1 implements Runnable {

    public void run() {
        System.out.println("Hello from the  thread!" + Thread.currentThread().getId() + "I will sleep" );
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("I got interrupted. I must wake");
		}
        System.out.println("Thread " + Thread.currentThread().getId() + "I woke up" );
    }

    public static void main(String args[]) {
    	Thread t1 = new Thread(new appQuestion1());
    	t1.start();
    	t1.start(); // This will cause an exception 
    	// 1.Why the rest of the program will not run, but t1 will finish its work;
    	// 2. If I catch the exception how I will terminate all active threads
    	Thread t2 = new Thread(new appQuestion1());
    	t2.start();
    	t2.interrupt();
    }


}
