package Lab1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Purse
{
    //A map that stores denomination and their qualities
    private final Map<Denomination, Integer> cash = new HashMap<>();

    //Method that adds a certain number of a specific denomination
    public void add(Denomination type, int num)
    {
        //checks and updates the count of denomination by adding num to current count
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }
//remove a certain number of a specific denomination
    public double remove(Denomination type, int num)
    {
        //checks if denomination exists
        if (cash.containsKey(type))
        {
            //current number of denomination
            int currentNum = cash.get(type);
            if (currentNum < num)
            {
                num = currentNum;
            }
            //updates map by subtracting the removed number of denomination
            cash.put(type, cash.get(type) - num);
            return type.amt() * num;
        }
        //if denomination DNE i purse return 0.0
        return 0.0;
    }
    //Method to calculate the total value of money in the purse
    public double getValue()
    {
        return cash.entrySet().stream()//stream of 'cash' map entry
                .mapToDouble(e->e.getKey().amt() * e.getValue())//maps each entry to corresponding value by multiplying denomination value
                .sum();
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        //iterates through map and append denomination names and qualities
        cash.forEach((denom, count)->
        {
            if(count>0)
            {
                sb.append(count).append(" ").append(denom.name()).append("\n");
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
