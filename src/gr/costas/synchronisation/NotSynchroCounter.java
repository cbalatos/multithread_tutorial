package gr.costas.synchronisation;

public class NotSynchroCounter implements MyCounter{
    private int c = 0;

    public void increment() {
    	try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        c++;
    }

    public void decrement() {

        c--;
    }

    public int value() {
        return c;
    }

}