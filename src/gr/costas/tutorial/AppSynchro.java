package gr.costas.tutorial;

import gr.costas.synchronisation.SynchronizedCounter;



public class AppSynchro  {
	
    

    public static void main(String args[]) {
    	
    	//NotSynchroCounter counter = new NotSynchroCounter() ; 
    	SynchronizedCounter counter = new SynchronizedCounter();
    	
    	System.out.println("Counter value is "+ counter.value());
    	try {
    		IncrementCounterThread a1 = new IncrementCounterThread(counter);
    		Thread t1 = new Thread(a1);
    		
    		DecrementCounterThread a2 = new DecrementCounterThread(counter);
    		Thread t2 = new Thread(a2);
    		t1.start();
    		//Thread.sleep(2000);
    		t2.start();
    		//Thread.sleep(3000);
    		
        	t2.join();
        	System.out.println("Finished Counter value is "+ counter.value());
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// Stop all active threads
			System.out.println(" The number of active threads is "+Thread.activeCount());
			for (Thread t: Thread.getAllStackTraces().keySet()){
					System.out.println("Iterating All Active Threads :"+t.getId() + " "+ t.getState().toString());
			}
		}

    }



}
