package gr.costas.tutorial;

import gr.costas.synchronisation.MyCounter;

public class IncrementCounterThread implements Runnable {

	MyCounter counter;
	
	public IncrementCounterThread(MyCounter counter){
		this.counter = counter;
	}	
	
	@Override
    public void run() {
        System.out.println("Hello increment from the  thread!" + Thread.currentThread().getId() + "I will sleep" );
       
        counter.increment();
			

        System.out.println("Thread increment" + Thread.currentThread().getId() + " counter value is "+counter.value() );
        

    }

}
