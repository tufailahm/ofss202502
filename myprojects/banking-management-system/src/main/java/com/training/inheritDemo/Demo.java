package com.training.inheritDemo;
class Product
{
        String productName;
        int price=100;
        public void printProductDetails(){
            System.out.println("Product Name is :"+productName);
        }
    protected KarnatakaCalculator calculateCost(){
            System.out.println(price+price*.12);
            return null;
        }
}
class Food extends Product
{
        String bestBefore;
        public void printFoodDetails(){
            System.out.println("Product Name is :"+productName);
            System.out.println("Product Best Before is :"+bestBefore);
        }
    public KarnatakaCalculator calculateCost(){            //method overriding
        System.out.println(price+price*.12+100+100);
        return null;
    }
}
public class Demo {
    public static void main(String[] args) {
        //Way 1
        System.out.println("way1 ");
        Product productRealObject = new Product();
        productRealObject.calculateCost();
        Food foodObject = new Food();
        foodObject.calculateCost();

        //Way2
        System.out.println("way2 ");
        Product product = new Product();
        product = new Food();
        product.calculateCost();

        Food food = new Food();
        Product prod = food;
        prod.calculateCost();

        Food x1 = new Food();
        Object x4 = x1;
        Product x5 = (Product)x4;
        x5.printProductDetails();

    }
}



class Calculator
{
}

class KarnatakaCalculator extends Calculator
{
}