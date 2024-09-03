package Lab1;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel
{
    //Hold denomination and their qualities
    private Purse purse = new Purse();

    //updates purse and then PursePanel will display
    public void setPurse(Purse purse)
    {
        this.purse = purse;
    }
    //displays images and text
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //start position for drawing images
        int x = 80;
        int y = 300;
        for (Map.Entry<Denomination, Integer> entry : purse.getEntries())
        {
            Denomination denom = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++)
            {
                Image img = new ImageIcon(denom.img()).getImage();
                g.drawImage(img, x, y, 130, 110, this);
                y += 50;
                if (y > getHeight() - 30)
                {
                    y = 80;
                    x += 80;
                }
            }
        }
    }
}
