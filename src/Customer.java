
import java.util.*;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add((Rental) rental);
    }

    public String getName() {
        return name;
    }


    private double getAmountFor(Rental rental) { return rental.getRentalPrice(); }

    private double getTotalCharge() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += getAmountFor(rental);
        } return totalAmount;
    }


    public String statement() {
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : this.rentals) {

            frequentRenterPoints += Rental.calculatePoints(rental);

            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(getAmountFor(rental)) + "\n";
        }

        result += "You owed " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
        return result;
    }




}