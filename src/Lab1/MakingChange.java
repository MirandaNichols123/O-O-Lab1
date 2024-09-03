package Lab1;

import javax.swing.*;

public class MakingChange
{
    public static void main(String[] args)
    {
        //main window for application
        JFrame frame = new JFrame("Making Change");
        //makes sure application will terminate after window closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets size of display window
        frame.setSize(700, 900);
        //centers the window on the screen
        frame.setLocationRelativeTo(null);
        frame.add(new RegisterPanel());
        frame.setVisible(true);
    }
}
