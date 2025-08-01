package org.example;

public class Calculator
{
	public int sum(int num1,int num2)
	{
		return num1+num2;
	}
	public int divide(int num1,int num2)
	{
		return num1/num2;
	}
	public int convertStringToNumber(String marks) { // "90"
		return Integer.parseInt(marks);
	}
}