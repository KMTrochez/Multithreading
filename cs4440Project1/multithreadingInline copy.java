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
			String cardNumber = "4388576018402626"; //INVALID
			//String cardNumber = "4388576018410707"; //VALID
			Thread multhread1 = new Thread(() -> {   	
				if(cardNumber.length() >= 13 && cardNumber.length() <= 19 && cardNumber.matches("[0-9]+"))
				{
					System.out.println("The card number: " + cardNumber + " is a valid credit card number input.");
					
				}
				else
				{
					System.out.println("The card number: " + cardNumber + " is not a valid credit card number input.");
			
				}
            });
			multhread1.start();
	        
	        Thread multhread2 = new Thread(() -> {
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
            });
			multhread2.start();
	        
	        Thread multhread3 = new Thread(() -> {
				int evenSum = 0;
				String cardNumb = cardNumber + "";
				for (int i = cardNumb.length() -2; i >=0; i -=2)
				{
					int dblDigit = ((Integer.parseInt(cardNumb.charAt(i) + "")) * 2);
		
					if(dblDigit <=9)
					{
						evenSum += dblDigit;
					}
					else
					{
						evenSum += (dblDigit / 10 + dblDigit % 10);
					}
				}
				
				System.out.println("The Sum of the double even placed integer is:  " + evenSum);
            });
			multhread3.start();
	        
	        Thread multhread4 = new Thread(() -> {
                int oddSum = 0;
				String cardNumb = cardNumber + "";
		
				for (int i = cardNumb.length() -1; i >=0; i -=2)
				{
					int digits = (Integer.parseInt(cardNumb.charAt(i) + ""));
					oddSum += digits;
				}
				System.out.println("The Sum of the odd placed integer is:  " + oddSum);
            });
			multhread4.start();
	        
	        Thread multhread5 = new Thread(() -> {
				int sum = 0;
				sum = evenSum + oddSum;
				System.out.println("The sum of both even and odd sums is = " + sum + ".");
            });
			multhread5.start();
	        
	        Thread multhread6 = new Thread(() -> {
				if (sum % 10 == 0)
				{
					System.out.println("The card number " + cardNumber + " is Luhn valid.");
				}
				else
				{
					System.out.println("The card number " + cardNumber + " is not Luhn valid.");
				}
            });
			multhread6.start();


			try{
				multhread1.join();
				multhread2.join();
				multhread3.join();
				multhread4.join();
				multhread5.join();
				multhread6.join();
			}
	        catch (InterruptedException ie) {ie.printStackTrace();}
	        
	        multhread1.stop();
	        multhread2.stop();
	        multhread3.stop();
	        multhread4.stop();
	        multhread5.stop();
	        multhread6.stop();
    	}   
}

    

//4388576018402626 invalid
//4388576018410707 valid
