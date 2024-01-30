package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code

		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}

    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}

	/**
		The code below does a logical OR operation on two binary values.
		@param num1 is the first binary variable
		@param num2 is the second binary variable
		@return A binary variable with a value of <i>num1||num2</i>
	 */

	public static Binary or(Binary num1, Binary num2)
	{
		//the value below represent the most significant bit (MSB) of the binary values
		int index1 = num1.number.length()-1;
		int index2 = num2.number.length()-1;


		//Vairable initialization
		String final_value = ""; // a string used for the result of the bitwise OR operation.
		int x = 0; //to hold the result of single digit OR operation

		//loops until both binary strings are fully processed
		while(index1>=0 || index2>=0){
			x=0; //clears the variable to 0 after each loop

			//Process a digit from num1
			if(index1 >= 0){
				/*
				checks the current digit of num1
				if the digit at the index is 1 then x = 1. Or else, x = 0 ((a?b:c) if a then b otherwise c concept)
				*/
				x = (num1.number.charAt(index1)=='1')? 1:x;
				index1--; //decrementing inorder for the index in the next iteration to start from 1 position to left
			}

			//The if below has the same function as the if above but it is now done for the binary value in the variable num2
			if(index2 >= 0){
				x = (num2.number.charAt(index2) == '1')? 1:x;
				index2--;
			}

			//final binary value 1 if x = 1 other wise it will be 0. (using OR logic)
			final_value = ((x==1)? "1":"0") + final_value;

		}

		Binary result = new Binary(final_value); //A binary object with the final binary value
		return result; //return the value to App.java



	}

	/**
	 * Does a logical AND operation on two binary variables
	 * @param num1 the first binary variable
	 * @param num2 the second binary variable
	 * @return A binary vairable with a value of <i>num1 AND num2</i>
	 */
	public static Binary and(Binary num1, Binary num2)
	{
		//the value below represent the most significant bit (MSB) of the binary values same as the step done for logical or
	int index1=num1.number.length()-1;
	int index2=num2.number.length()-1;

	//Variable initialization
	String final_value = ""; // a string used for the result of the bitwise AND operation.
	int x,y; // variables to hold single digit AND operation

	//loops until both binary values are fully processed
	while(index1>=0 || index2>=0){
		x = 0;
		y = 0;

		// process a digit from num1
		if (index1 >= 0){
		/*
		checks the current digit of num1
		if the digit at the index is 1 then x = 1. Or else, x = 0 (if a then b otherwise c concept)
		 */
			x = (num1.number.charAt(index1) == '1')? 1:0;
			index1--; ////decrementing inorder for the index in the next iteration to start from 1 position
		}

		if(index2 >= 0){
			y = (num2.number.charAt(index2) == '1')? 1:0;
			index2--;
		}

		//final value will be 1 if both x and y are 1, if not then 0 (using AND logic)
		final_value = ((x==1 && y==1)?"1":"0") + final_value;


	}

	Binary result = new Binary(final_value); //binary object with the calculated value
	return result; //return the value to App.java


	}

	/**
	 * Multiplies two binary variables
	 * @param num1 the first binary variable
	 * @param num2 the second binary variable
	 * @return A binary variable with a value of <i>num1 x num2</i>
	 */
	public static Binary multiply(Binary num1, Binary num2)
	{
		//the value below represent the least significant bit (LSB) of the binary values
		int index1=num1.number.length()-1;
		int index2=num2.number.length()-1;

		Binary result = new Binary("0"); // object used to store the result of the multiplication

		//Checking for multiplier and multiplicand
		// Bignum = multiplicand, Smallnum = multiplier
		Binary Bignum = (index1>=index2)? num1:num2;
		Binary Smallnum = (Bignum == num1)?num2:num1;

		num1 = Bignum;
		num2 = Smallnum;

		// loops over each bit of the multiplier starting from LSB
		for(int i=Smallnum.number.length()-1; i>=0; i--){

			//Checks if the current bit of the multiplier is 1, if yes then add
			if(Smallnum.number.charAt(i)=='1'){
				result = add(result,num1);
			}

			//0 is concatenated to the end of num1s binry string. This mimics shifting one place to the left
			num1.number+="0";
		}

		return result;
	}







}	
