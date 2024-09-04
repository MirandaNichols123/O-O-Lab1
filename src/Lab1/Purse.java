package Lab1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Purse
{
    //Map that stores denomination and their qualities
    private final Map<Denomination, Integer> cash = new HashMap<>();

    //Method that adds a certain number of a specific denomination
    public double add(Denomination type, int num)
    {
        //checks and updates the count of denomination by adding num to current count
        //cash.put(type, cash.getOrDefault(type, 0) + num);
        //return 0;
        // Get the current count for the type, default to 0 if not present
        int currentCount = cash.getOrDefault(type, 0);
        // Calculate the new count
        int newCount = currentCount + num;
        // Update the map with the new count
        cash.put(type, newCount);
        //return value
        return type.amt() * num;
    }
    //removes a certain number of a specific denomination
    public double remove(Denomination type, int num)
    {
        //checks if denomination exists
        if (cash.containsKey(type)) {
            //current number of denomination
            int currentNum = cash.get(type);
            //adjusts num to be min of amount
            int RemovedCount = Math.min(num, currentNum);
            //Updates the count in map
            cash.put(type, currentNum - RemovedCount);
            if (cash.get(type) == 0) {
                cash.remove(type);
            }
            //return total value of removed denominations
            return type.amt() * RemovedCount;
        }
        //if denomination DNE i purse return 0.0
        return 0.0;
    }
    //Method to calculate the total value of money in the purse
    public double getValue()
    {
        //stream of 'cash' map entry and maps each entry to corresponding value by multiplying denomination value
        return cash.entrySet().stream()
                .mapToDouble(e->e.getKey().amt() * e.getValue())
                .sum();
    }
    //method generates a string representation of purse content in descending order
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        cash.entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getKey().amt(), entry1.getKey().amt()))
                .forEach(entry -> {
                    if (entry.getValue() > 0) {
                        sb.append(entry.getValue()).append(" ").append(entry.getKey().name()).append("\n");
                    }
                });

        return !sb.isEmpty() ? sb.toString() : "Empty Purse";
    }
    // New method to get entries
    public Set<Map.Entry<Denomination, Integer>> getEntries()
    {
        return Collections.unmodifiableSet(cash.entrySet());
    }

}
