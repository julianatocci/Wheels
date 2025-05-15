package Wheels;

import java.util.Date;

public class IssueBikeUI {
    //set up the member variables
    private Wheels.Bike chosenBike = null;
    private Wheels.Customer customer = null;
    private Payment payment = null;
    private Wheels.Hire hire = null;
    private int numberOfDays = 0;

    public Wheels.Hire getHire() {
        return hire;
    }

    public void showBikeDetails(int bikeNum){
        //find the bike by its number
        chosenBike = Wheels.Bike.findBikeByNumber(bikeNum);
        if(chosenBike != null){
            chosenBike.showDetails();
        }
    }

    public void calculateCost(int numDays){
        //set the member variable so it can be used later
        numberOfDays = numDays;
        //then ask the bike for the cost
        chosenBike.calculateCost(numDays);
    }

    public void createCustomer(String name, String postcode, int telephone){
        //create a customer and associated hire and payment
        customer = new Wheels.Customer(name, postcode, telephone);
        payment = new Payment(customer);
        hire = new Wheels.Hire(new Date(), numberOfDays, chosenBike, customer);
    }

    public void calculateTotalPayment(){
        //get the total payment from the payment object
        payment.calculateTotalPayment(hire);
    }
}
