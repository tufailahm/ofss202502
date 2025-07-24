package com.training.finance;

public class Demo
{
	int num=100;	//instance variable
	String name="Neha";
	final int TOTAL_MARKS =100;
	public void display(int i)
	{
		final int age=98;
		var address = "Pune";
		var marks = 98;
		int num=300;
		System.out.println(num+age);		//398
		System.out.println(this.num+age);		//198
	}
	public void changeNumbers()
	{
		num++;
	}
	public static void main(String args[])
	{
		Demo d1 = new Demo();
		Demo d2 = new Demo();
		d1.changeNumbers();
		d1.display(500);
	}
}