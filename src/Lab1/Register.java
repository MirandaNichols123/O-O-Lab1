package Lab1;

import java.util.Arrays;
import java.util.List;

public class Register
{
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

    public Purse makeChange(double amt) {
        //creates a new purse object
        Purse purse = new Purse();

        //Checks if amt is greater or equal to than 0
        if (amt <= 0) {
            return purse;
        }
        //enhanced for loop
        for (Denomination denom : DENOMINATIONS) {
            int count = (int) (amt / denom.amt());
            if (count > 0) {
                purse.add(denom, count);
                amt -= count * denom.amt();

                //prevents floating-point precision
                amt = Math.round(amt * 100.0) / 100.0;

                //if remaining amount is small, break
                if (amt < 0.01) break;
            }
        }
        return purse;
    }
    public static void main(String[] args) {
        Register register = new Register();
        Purse purse = register.makeChange(104.79);

        // Simulate removing some denominations from the purse
        Denomination oneDollarNote = new Denomination("One-Dollar Note", 1.00, "bill", "one_dollar.png");
        double removedValue = purse.remove(oneDollarNote, 2); // Remove 2 one-dollar notes

        System.out.println("Removed value: " + removedValue);
        System.out.println("Remaining purse: \n" + purse);
        // Print the total value of the purse
        double totalValue = purse.getValue();
        System.out.println("Total value of the purse: $" + totalValue);
    }
}
