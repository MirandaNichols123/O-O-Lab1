package Lab1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PursePanel extends JPanel {
    //Hold denomination and their qualities
    private Purse purse = new Purse();

    //updates purse and then PursePanel will display
    public void setPurse(Purse purse)
    {
        this.purse = purse;
    }

    //displays images and text
    protected void paintComponent(Graphics g) {
        //makes sure panel is properly cleared and set up properly
        super.paintComponent(g);
        //start position for drawing images
        int x = 10;
        int y = 10;
        //tracks height of tallest image in a row
        int maxImageHeight = 0;

        //creates a list from Purse entries and sort them by denomination value(L->S)
        List<Map.Entry<Denomination, Integer>> sortedEntries = new ArrayList<>(purse.getEntries());
        sortedEntries.sort((entry1, entry2) -> Double.compare(entry2.getKey().amt(), entry1.getKey().amt()));

        // Add labels with images to the panel
        for (Map.Entry<Denomination, Integer> entry : sortedEntries) {
            {
                Denomination denom = entry.getKey();
                //gets count of current denomination
                int count = entry.getValue();
                //load image for the current denomination
                Image img = new ImageIcon(denom.img()).getImage();

                //Sets a fixed width for the image
                int imgWidth = 130;
                int imgHeight = 90;

                //draw the image multiple amount of times until it hits the number of denomination
                for (int i = 0; i < count; i++) {
                    //checks image to make sure it does not exceed panel width
                    if (x + imgWidth > getWidth()) {
                        //x coord to start new row
                        x = 10;
                        //move y down by 10 and image height
                        y += maxImageHeight + 10;
                    }
                    g.drawImage(img, x, y, imgWidth, imgHeight, this);
                    //move x-coord to right of next image
                    x += imgWidth + 10;
                    maxImageHeight = imgHeight;
                }
            }
        }
    }
}


