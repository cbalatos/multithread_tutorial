package gr.costas.tutorial;

public class SleepMessages {
    public static void main(String args[])
        throws InterruptedException {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };

        for (int i = 0;
             i < importantInfo.length;
             i++) {
        	try{
            //Pause for 4 seconds
            Thread.sleep(4000);
        	} catch (InterruptedException e) { //Supporting Interruption
        		// We've been interrupted: no more messages.
        		return;
        	}
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }
}
