package Lab1;

import java.util.Arrays;
import java.util.List;

public class Register
{
    //List the holds predefined sets of Denomination objects
    private static final List<Denomination> DENOMINATIONS = Arrays.asList(
            new Denomination("Hundred-Dollar Note", 100.00, "bill", "hundred_note.png"),
            new Denomination("Fifty-Dollar Note", 50.00, "bill", "fifty_note.png"),
            new Denomination("Twenty-Dollar Note", 20.00, "bill", "twenty_note.png"),
            new Denomination("Ten-Dollar Note", 10.00, "bill", "ten_note.png"),
            new Denomination("Five-Dollar Note", 5.00, "bill", "five_note.png"),
            new Denomination("One-Dollar Note", 1.00, "bill", "one_note.png"),
            new Denomination("Quarter", 0.25, "coin", "quarter.png"),
            new Denomination("Dime", 0.10, "coin", "dime.png"),
            new Denomination("Nickel", 0.05, "coin", "nickel.png"),
            new Denomination("Penny", 0.01, "coin", "penny.png"));

    //used to calculate the optimal change
    public Purse makeChange(double amt)
    {
        //creates a new purse object
        Purse purse = new Purse();
        //Checks if amt is greater or equal to than 0
        if (amt <= 0)
        {
            return purse;
        }

        // Round the amount to the nearest cent
        amt = Math.round(amt * 100.0) / 100.0;

        //enhanced for loop to iterate through the sorted denomination
        for (Denomination denom : DENOMINATIONS)
        {
            int count = (int)
                    //gets the inputted amt then divide it by the largest amt...
                    (amt / denom.amt());
            //checks if one denomination can be used
            if (count > 0)
            {
                //counts how many denominations are in Purse
                purse.add(denom, count);
                //subtracts total value of added denomination from remaining amt
                amt -= count * denom.amt();

                //if remaining amount is small, break
                if (amt < 0.01) break;
            }
        }
        return purse;
    }
    //tests out the Register.Java, Denomination.Java, and Purse.Java Works
    public static void main(String[] args) {
        Register register = new Register();
        Purse purse = register.makeChange(69.89);

        System.out.println("Initial Purse: \n" + purse);

        // Test removing a denomination not in the purse
        double removedValue = purse.remove(new Denomination("Penny", 0.01, "coin", "penny.png"), 3);
        System.out.println("Removed Value: $" + removedValue);
        System.out.println("Purse after removal: \n" + purse);

        // Adding denominations
        double addedValue = purse.add(new Denomination("Penny", 0.01, "coin", "penny.png"), 5);
        System.out.println("Added value: $" + addedValue);

        System.out.println("Remaining purse: \n" + purse);
        // Print the total value of the purse
        double totalValue = purse.getValue();
        System.out.println("Total value of the purse: $" + totalValue);
    }
}
