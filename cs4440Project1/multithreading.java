package cs4440Project1;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Multhreading extends Thread 
{

    @SuppressWarnings("deprecation")
	public static void main(String [] args)
    {
        for(String input:args)
        {
	        long threadStartTime = System.nanoTime();
	        Validation v = new Validation();
	        CheckCard c = new CheckCard();
	        LuhnEven le = new LuhnEven();
	        LuhnOdd lo = new LuhnOdd();
	        LuhnSum s = new LuhnSum();
	        LuhnValidation lv = new LuhnValidation();
	        Thread multhread1 = new Thread(new Multhreading());
	        Thread multhread2 = new Thread(new Multhreading());
	        Thread multhread3 = new Thread(new Multhreading());
	        Thread multhread4 = new Thread(new Multhreading());
	        Thread multhread5 = new Thread(new Multhreading());
	        Thread multhread6 = new Thread(new Multhreading());
	        long startTime = System.nanoTime();
	    	long endTime = System.nanoTime();
	        long threadTotalTime;
        	String cardNumber = input;
	        startTime = System.nanoTime();
	        multhread1.start();
	        try 
	        {       	
	        	v.validation(cardNumber);
	        	multhread1.join();
	        	endTime = System.nanoTime();
	            threadTotalTime = endTime - startTime;  		
	            System.out.println("Thread 1 run time: " + threadTotalTime + " nano seconds");
	        	
	        }
	        catch (InterruptedException ie) {ie.printStackTrace();}
	        
	        startTime = System.nanoTime();
	        multhread2.start();
	        try 
	        {
	        	
	        	c.checkCard(cardNumber);
	        	multhread2.join();
	        	endTime = System.nanoTime();
	            threadTotalTime = endTime - startTime;  		
	            System.out.println("Thread 2 run time: " + threadTotalTime + " nano seconds");
	        	
	        }
	        catch (InterruptedException ie) {ie.printStackTrace();}
	        
	        startTime = System.nanoTime();
	        multhread3.run();
	        try 
	        {
	        	le.luhnEven(cardNumber);
	        	multhread3.join();
	        	endTime = System.nanoTime();
	            threadTotalTime = endTime - startTime;  		
	            System.out.println("Thread 3 run time: " + threadTotalTime + " nano seconds");
	        }
	        catch (InterruptedException ie) {ie.printStackTrace();}
	        
	        startTime = System.nanoTime();
	        multhread4.start();
	        try 
	        {
	        	lo.luhnOdd(cardNumber);
	        	multhread4.join();
	        	endTime = System.nanoTime();
	            threadTotalTime = endTime - startTime;  		
	            System.out.println("Thread 4 run time: " + threadTotalTime + " nano seconds");
	        }
	        catch (InterruptedException ie) {ie.printStackTrace();}
	        
	        startTime = System.nanoTime();
	        multhread5.start();
	        try 
	        {
	        	s.luhnSum(cardNumber);
	        	multhread5.join();
	        	endTime = System.nanoTime();
	            threadTotalTime = endTime - startTime;  		
	            System.out.println("Thread 5 run time: " + threadTotalTime + " nano seconds");
	        }
	        catch (InterruptedException ie) {ie.printStackTrace();}
	        
	        startTime = System.nanoTime();
	        multhread6.start();
	        try 
	        {
	        	lv.luhnValidation(cardNumber);
	        	multhread6.join();
	        	endTime = System.nanoTime();
	            threadTotalTime = endTime - startTime;  		
	            System.out.println("Thread 6 run time: " + threadTotalTime + " nano seconds");
	        }
	        catch (InterruptedException ie) {ie.printStackTrace();}
	        
	        endTime = System.nanoTime();
	        threadTotalTime = endTime - threadStartTime;  		
	        System.out.println("Total threads run time: " + threadTotalTime + " nano seconds");  
	        multhread1.stop();
	        multhread2.stop();
	        multhread3.stop();
	        multhread4.stop();
	        multhread5.stop();
	        multhread6.stop();
    	}   
    }
}

    //Card Verification
    class Validation
    {
		public static void main(String[] args) throws Exception
		{
			
		}
    	public void validation(String cardNumber)
        {
        //Step 1    	
	        if(cardNumber.length() >= 13 && cardNumber.length() <= 19 && cardNumber.matches("[0-9]+"))
	        {
	        	System.out.println("The card number: " + cardNumber + " is a valid credit card number input.");
	        	
	        }
	        else
	        {
	            System.out.println("The card number: " + cardNumber + " is not a valid credit card number input.");
	    
	        }
        }
        
    }
    
    class CheckCard
    {
		public static void main(String[] args) throws Exception
		{
			
		}
        public void checkCard(String cardNumber)
        {
	    	if(cardNumber.length() >= 13 && cardNumber.length() <= 19 && cardNumber.matches("[0-9]+"))
	    	{
		    	System.out.print("This card is a ");
		    	
		        if ((cardNumber.startsWith("34") ||  cardNumber.startsWith("37")) &&  cardNumber.length() == 15)
		        {
		            System.out.println("American Express Card");
		            
		        }
		        else if (cardNumber.startsWith("6") &&  cardNumber.length() <= 16 &&  cardNumber.length() >= 19)
		        {
		            System.out.println("Discover Card");
		            
		        }
		        else if ((cardNumber.startsWith("51") || cardNumber.startsWith("52") ||  cardNumber.startsWith("53") 
		                ||  cardNumber.startsWith("54") ||  cardNumber.startsWith("55")) &&  cardNumber.length() == 16)
		        {
		            System.out.println("Mastercard Card");
		            
		        }
		        else if ((cardNumber.startsWith("4")) && ( cardNumber.length() == 13 || cardNumber.length() == 16))
		        {
		            System.out.println("Visa Card");
		            
		        }
	    	}
        }
    }

    class LuhnEven
    {	
        //Step 3
		public static void main(String[] args) throws Exception
		{
			
		}
        public int luhnEven(String cardNumber)
        {
	        int sum = 0;
	        String cardNumb = cardNumber + "";
	
	        for (int i = cardNumb.length() -2; i >=0; i -=2)
	        {
	            int dblDigit = ((Integer.parseInt(cardNumb.charAt(i) + "")) * 2);
	
	            if(dblDigit <=9)
	            {
	                sum += dblDigit;
	            }
	            else
	            {
	                sum += (dblDigit / 10 + dblDigit % 10);
	            }
	        }
	        
	        System.out.println("The Sum of the double even placed integer is:  " + sum);
	        return sum;
        }
    }

    class LuhnOdd
    {	
        //Step 4
        public static void main(String [] args)
        {

        }
    	public int luhnOdd(String cardNumber)
    	{
	        int sum = 0;
	        String cardNumb = cardNumber + "";
	
	        for (int i = cardNumb.length() -1; i >=0; i -=2)
	        {
	            int digits = (Integer.parseInt(cardNumb.charAt(i) + ""));
	            sum += digits;
	        }
	        System.out.println("The Sum of the odd placed integer is:  " + sum);
	        return sum;
    	}

    }

   class LuhnSum
   {
	   
	   //Step 5
	   public static void main(String[] args) throws Exception
	   {
			
	   }
	   public int luhnSum(String cardNumber)
	   {
	       LuhnEven le = new LuhnEven();
	       LuhnOdd lo = new LuhnOdd();
		   int sum = 0;
	       sum = le.luhnEven(cardNumber) + lo.luhnOdd(cardNumber);
	       System.out.println("The sum of both even and odd sums is = " + sum + ".");
	       return sum;
	   }
   }

    class LuhnValidation
    {	
        //Step 6
		public static void main(String[] args) throws Exception
		{
			
		}
        public void luhnValidation(String cardNumber)
        {
            LuhnSum s = new LuhnSum();
	    	int luhnSum = s.luhnSum(cardNumber);
	    	
	        if (luhnSum % 10 == 0)
	        {
	            System.out.println("The card number " + cardNumber + " is Luhn valid.");
	        }
	        else
	        {
	            System.out.println("The card number " + cardNumber + " is not Luhn valid.");
	        }
        }
    }

    

//4388576018402626 invalid
//4388576018410707 valid
