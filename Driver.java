import javax.swing.*;


public class Driver
{
   public static void main(String [] args)
   {
      JFrame frame = new WarGameGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(450,720);
      frame.setResizable(false);
      frame.validate();
      frame.setVisible(true);
   
   }


}
