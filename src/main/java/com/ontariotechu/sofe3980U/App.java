package com.ontariotechu.sofe3980U;

//import org.joda.time.LocalTime;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	/**
	* Main program:  The entry point of the program. The local time will be printed first,
	*      Then it will create two binary variables, add them and print the result.
	*
	* @param args: not used
	*/
    public static void main( String[] args )
    {
		Scanner user_input = new Scanner(System.in);
//		LocalTime currentTime = new LocalTime();

		System.out.println("----------Welcome to Binary Calculator----------");
//		System.out.println("The current local time is: " + currentTime);
		System.out.println("\n");

		System.out.println("Enter a binary value");
		//Creating a binary object to store user's binary value
		Binary binary_val1 = new Binary(user_input.next());
		System.out.println("Enter a second binary value");
		Binary binary_val2 = new Binary(user_input.next());

		//output to show the user their inputed values
		System.out.println("Your first binary value: " + binary_val1.getValue()); //binary_val1 = 00010001000
		System.out.println("Your second binary value: " + binary_val2.getValue());  //binary_val2 = 111000

		//the code below implements the 4 functionality of Addition, AND, OR and Multiply between binary values
		System.out.println("\n");

		//Addition operation
		Binary sumOper = Binary.add(binary_val1,binary_val2);
		System.out.println(binary_val1.getValue() + " Summed with " +binary_val2.getValue() + " = " + sumOper.getValue());

		//AND operation
		Binary andOper = Binary.and(binary_val1,binary_val2);
		System.out.println(binary_val1.getValue() + " AND " +binary_val2.getValue() +" = " + andOper.getValue());

		//OR operation
		Binary orOper = Binary.or(binary_val1,binary_val2);
		System.out.println(binary_val1.getValue() + " OR " +binary_val2.getValue() + " = " + orOper.getValue());

		//Multiply operation
		Binary multOper = Binary.multiply(binary_val1,binary_val2);
		System.out.println(binary_val1.getValue() + " Multiplied with " +binary_val2.getValue() + " = " + multOper.getValue());

		//Closing scanner object
		user_input.close();

    }
}
