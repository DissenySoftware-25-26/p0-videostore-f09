
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
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : this.rentals) {
            // (b) thisAmount -> price
            // (a)+(c) ara el càlcul és dins Rental

            // punts de client freqüent (sense canvis de lògica)
            frequentRenterPoints++;
            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE &&
                    rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(getAmountFor(rental)) + "\n";
            totalAmount += getAmountFor(rental);
        }

        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
        return result;
    }



}