package gr.costas.tutorial;

import gr.costas.synchronisation.MyCounter;

public class DecrementCounterThread implements Runnable {

	MyCounter counter;
	
	public DecrementCounterThread(MyCounter counter){
		this.counter = counter;
	}	
	
	@Override
    public void run() {
        System.out.println("Hello decrement from the  thread!" + Thread.currentThread().getId() );

        counter.decrement();
			
        System.out.println("Thread increment" + Thread.currentThread().getId() + " counter value is "+counter.value() );
        

    }

}
