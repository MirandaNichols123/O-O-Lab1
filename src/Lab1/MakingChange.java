package Lab1;

import javax.swing.*;

public class MakingChange
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 900);
        //centers the window on the screen
        frame.setLocationRelativeTo(null);
        frame.add(new RegisterPanel());
        frame.setVisible(true);
    }
}
