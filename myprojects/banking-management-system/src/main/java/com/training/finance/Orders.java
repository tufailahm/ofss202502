package com.training.finance;
class Booking
{
    String bookingName = "demo";
    protected void finalize() throws Throwable {
        System.out.println("Booking object garbage collected");
    }
}
public class Orders {

    public static void main(String[] args) {
        Booking b1 = new Booking();
        Booking b2 = new Booking();
        Booking b3 = new Booking();
        b1 = null;
        b2 = null;

        System.gc();
    }
}

