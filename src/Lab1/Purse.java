package Lab1;

import java.util.HashMap;
import java.util.Map;

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
    //Method to remove a certain number of a specific denomination
    public double remove(Denomination type, int num)
    {
        //checks if denomination exists
        if(cash.containsKey(type))
        {
            //current number of denomination
            int currentNum = cash.get(type);
            if (currentNum < num)
            {
                num = currentNum;
            }
            //if denomination DNE i purse return 0.0
            return 0.0;
        }

    }
}
