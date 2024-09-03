package Lab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel
{
    //instance of Register class
    private final Register register = new Register();
    //text where user can input amount they want to change
    private final JTextField input = new JTextField(8);
    //panel that calculates change to be displayed
    private final PursePanel changePanel = new PursePanel();

    public RegisterPanel()
    {
        //setLayout(new BorderLayout());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //code that outputs the amount the user wants to display then holds that number
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount: "));
        inputPanel.add(input);
        add(inputPanel);
        add(changePanel);

        //Register ActionListener for input text field
        input.addActionListener(new InputListener());
    }
    private class InputListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //try catch method
            try
            {
                //converts number -> double
                double amt = Double.parseDouble(input.getText());
                //calls makeChange method of Register to calculate change then store it in Purse
                Purse purse = register.makeChange(amt);
                //updates changePanel with newPurse object
                changePanel.setPurse(purse);
                //ChangePanel redrawn with updated info
                changePanel.revalidate();
                changePanel.repaint();

                //Prints out the texted version of the amount given
                System.out.println(purse);
            }
            //if user prints an invalid amount then use error handling
            catch (NumberFormatException ex)
            {
                changePanel.setPurse(new Purse());
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
    }
}
