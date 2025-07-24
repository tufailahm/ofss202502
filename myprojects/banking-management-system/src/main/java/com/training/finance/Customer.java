package com.training.finance;

public class Customer {
    int customerId=100;
    String customerName="Not Available";
    int billAmount = 0;
    String customerType;
    public Customer(){
        customerId = -1;
        customerName = "NameNotAvailable";
        billAmount = 100;
    }
    public Customer(int customerId,String customerName){
        this();
        this.customerId = customerId;
        this.customerName = customerName;
    }
    public Customer(int customerId,int billAmount){
        this();
        this.customerId = customerId;
        this.billAmount = billAmount;
    }
    public Customer(int customerId,int billAmount,String customerType){
        this();
        this.customerId = customerId;
        this.billAmount = billAmount;
        this.customerType = customerType;
    }
    public static void main(String[] args) {
        Customer customer1 = new Customer();        //def
        Customer customer2 = new Customer(100,"Jay");       //12
        Customer customer3 = new Customer(101,98000);           //16
        Customer customer4= new Customer(102,98000, CustomerType.Premium.toString());           //16


    }
}
