package com.training.inheritDemo;
abstract class Account
{
    public final void displayBalance(){
        System.out.println("Account balance is : 9550");
    }
    public abstract void openAccount();
    public abstract void closeAccount();
}
abstract class AccountProcess extends Account
{
    public abstract void addCharges();
    @Override
    public void closeAccount() {
    }
}
class SavingsAccount extends AccountProcess
{
    @Override
    public void openAccount() {

    }

    @Override
    public void addCharges() {

    }

    @Override
    public String toString() {
        return "Hello";
    }
}
class CurrentAccount extends Account
{

    @Override
    public void openAccount() {

    }

    @Override
    public void closeAccount() {

    }
}

public class DemoBanking {
    public static void main(String[] args) {
        SavingsAccount a = new SavingsAccount();
        a.displayBalance();
        a.openAccount();
        System.out.println(a.toString());
        System.out.println(a);
    }
}
