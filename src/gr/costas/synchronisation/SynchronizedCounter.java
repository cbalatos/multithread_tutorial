package gr.costas.synchronisation;

public class SynchronizedCounter implements MyCounter{
    private int c = 0;

    public synchronized void increment() {
    	try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
        c++;
        System.out.println("++++++"+c);
    }

    public synchronized void decrement() {
        c--;
        System.out.println("------"+c);
    }

    public synchronized int value() {
        return c;
    }
}
