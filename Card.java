import javax.swing.*;

public class Card {


   private final String image;
   private final int value;  // The value of this card, from 1 to 11.
   
//    final BufferedImage image;
//    private ImageIcon image; // pic for x,o null otherwise


   public Card(String i, int theValue) {
           // Construct a card with the specified value and suit.
           // Value must be between 1 and 13.  Suit must be between
           // 0 and 3.  If the parameters are outside these ranges,
           // the constructed card object will be invalid.
       value = theValue;
       image = i;

        
       
   }




   public int getValue() {
           // Return the int that codes for this card's value.
       return value;
   
   }


   public String getImage() {
          // Return a String representation of this card, such as
          
          return image;


   
}
}