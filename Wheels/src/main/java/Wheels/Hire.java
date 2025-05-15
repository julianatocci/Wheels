package Wheels;

import java.util.Date;

public class Hire {
    private Date startDate = null;
    private Wheels.Customer customer = null;
    private Wheels.Bike bike = null;
    private int numberOfDays = 0;
    private int hireId = 0;

    private static int hireCount = 001;

    public Hire(Date sDate, int numDays, Wheels.Bike bikeToHire, Wheels.Customer cust){
        startDate = sDate;
        numberOfDays = numDays;
        customer = cust;
        bike = bikeToHire;
        hireId = hireCount++;
    }

    public Wheels.Customer getCustomer(){
        return customer;
    }

    public Wheels.Bike getBike(){
        return bike;
    }

    public int getNumberOfDays(){
        return numberOfDays;
    }

    public Date getStartDate(){
        return startDate;
    }
}

