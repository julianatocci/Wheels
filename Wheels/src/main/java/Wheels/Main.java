package Wheels;

public class Main {
    public static void main(String[] args) {
        /* this little program will run through the methods on issueBikeUI
         *calling each in turn, like a user with a front end would do. */
        //first, create the UI
        Wheels.IssueBikeUI ui = new Wheels.IssueBikeUI();

        //1. Show details for chosen bike
        ui.showBikeDetails(100);

        //2. calculate cost os hiring this bike for 5 days
        ui.calculateCost(5);

        //3.create new Customer, payment and hire
        ui.createCustomer("Juliana", "PW2 6TR", 2145634456);

        //4. calculate the total cost
        ui.calculateTotalPayment();

        Wheels.Hire hire = ui.getHire();

        SQLiteHandler.createTable();
        SQLiteHandler.saveHireToDatabase(hire);
        SQLiteHandler.listRentals();
    }
}
