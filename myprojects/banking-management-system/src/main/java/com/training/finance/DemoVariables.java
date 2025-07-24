package com.training.finance;

public class DemoVariables
{
	int num1=100;	//instance variable
	static int num2=200;	//class variables -- only one copy of this will remain in memory
	{
		System.out.println("HELLO");
	}

	static {
		System.out.println("WELCOME");
	}
	public void display(DemoVariables d1)
	{
		int num1=1000;
		d1.num1++;
		this.num1++;
		num1++;
	}
	public void changeNumbers()
	{
		num2++;
	}
	public void display(){
		System.out.println("Num1 :"+num1);
		System.out.println("Num2 :"+num2);
	}
	public static void main(String args[])
	{
		System.out.println("MAIN CALLED");
		DemoVariables d1 = new DemoVariables();
		DemoVariables d2 = new DemoVariables();
		d1.changeNumbers();
		d1.display(d2);
		d1.changeNumbers();
		d1.display();
		d2.display();
		System.out.println(d1.num1+d1.num2+d2.num1+d2.num2);
		System.out.println(false);
		System.out.println("1919");
	}
}










