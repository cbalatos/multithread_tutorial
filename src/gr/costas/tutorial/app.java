package gr.costas.tutorial;

public class app implements Runnable {
	
	Thread toWait;
	

    public void run() {
    	if (this.toWait == null){
        System.out.println("Hello from the  thread!" + Thread.currentThread().getId() + "I will sleep" );
       
        try {
			Thread.sleep(6000);

		} catch (InterruptedException e) {
			System.out.println("I got interrupted. I must wake");
		}
        System.out.println("Thread " + Thread.currentThread().getId() + "I woke up" );
        
    	}  else{
            System.out.println("Hello from a waiting  thread!" + Thread.currentThread().getId() + "I will sleep" );
            try {
            	this.toWait.join();
            	System.out.println("Thread " +this.toWait.getId() + "Finished. Now i must I wake up" );

    		} catch (InterruptedException e) {
    			System.out.println("I got interrupted. I must wake");
    			
    		}
            System.out.println("Thread " + Thread.currentThread().getId() + "I woke up" );
    		
    	}
    }
    


    public static void main(String args[]) {
    	try {
			Thread t1 = new Thread(new app());
			t1.start();
			//t1.start();
			Thread t2 = new Thread(new app());
			t2.start();
			t2.interrupt();
			
			Thread t3 = new Thread((new app()).setToWait(t1));
			t3.start();
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

	public Thread getToWait() {
		return toWait;
	}

	public app setToWait(Thread toWait) {
		this.toWait = toWait;
		return this;
	}


}
