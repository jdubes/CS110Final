//Jacob Dubois
//Assignment 10
//December 6th
//Jackie Horton

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

//WARGAMEGUI demostrates my take on the war card game and battles two hands 
//against eachother to see who will be victorious



public class WarGameGUI extends JFrame {
        
         JLabel text2 = new JLabel(); 

  public WarGameGUI() {

     //This is where the WarGameCanvas is built and we add the necessary buttons
     //and other panels,labels, and colors.
     
     setBackground( new Color(135,56,42) );

     WarGameCanvas board = new WarGameCanvas();
     getContentPane().add(board, BorderLayout.CENTER);
     


     JPanel buttonPanel = new JPanel();
     buttonPanel.setBackground( new Color(220,200,180) );
     getContentPane().add(buttonPanel, BorderLayout.SOUTH);
     
     JPanel textPanel = new JPanel();
     textPanel.setBackground( new Color(10,40,230) );
     getContentPane().add(textPanel, BorderLayout.NORTH);
   
      JLabel text = new JLabel("War Game by Jacob Dubois");
      text.setFont(new Font("Serif", Font.PLAIN, 25));
      text.setForeground(Color.ORANGE);

      textPanel.add(text);
      textPanel.add(text2);

     JButton flip = new JButton( "Flip" );
     flip.addActionListener(board);
     buttonPanel.add(flip);

     JButton newGame = new JButton( "New Game" );
     newGame.addActionListener(board);
     buttonPanel.add(newGame);
     

      

   }

  public class WarGameCanvas extends JPanel implements ActionListener {



     String status;  // A message drawn onto the canvas nptifying the user of status              
      Font smallFont;    // Font that will be used for the message
     //Ctreation of all the labels and ImageIcons I used in this program
     ImageIcon image,image2,image3,image4,image5,image6,image7;
     JLabel label,label2,label3,label4,label5,label6,text2;
     JPanel textPanel;
     
 

    //Here we create the deck arraylist which holds the 52 card objects
    //And then we create two hands or players to hold 26 card objs each
          ArrayList<Card> deck = new ArrayList<Card>();
          ArrayList<Card> player1 = new ArrayList<Card>();
          ArrayList<Card> player2 = new ArrayList<Card>();
          Random r = new Random();

     public WarGameCanvas() {
           // Constructor that sets the foreground and
           // background colors, and starts the first game
           //as well as start the game.

     setBackground( new Color(0,120,0) );
     setForeground( Color.yellow);
   
             
              doNewGame();
     } 

     public void actionPerformed(ActionEvent evt) {

        String command = evt.getActionCommand();
		  
//The action listener is used to flip the cards when our flip button is clicked
//along with the new game button
        if (command.equals("Flip"))
        {
        //The first conditional allows us to continue the game if either player doesnt 
        //have 0 cards. We grab two cards and battle them by comapring the assigned
        //values to see which card wins.
        if (player1.size()!=0 && player2.size()!=0)
            {
              label3.setIcon(null);
              label5.setIcon(null);
              label4.setIcon(null);
             
              label6.setIcon(null);
           
           int size1 = player1.size();
           int size2 = player2.size();
            Random g = new Random();
            Random g2 = new Random();
            
            
            int go = g.nextInt(size1);
            int go2 = g2.nextInt(size2);
 
            
             
             Card a = player1.get(go);
             Card b = player2.get(go2);
           
              image2 = new ImageIcon(a.getImage());
              image3 = new ImageIcon(b.getImage());
   
              label.setIcon(image2);
              label2.setIcon(image3);

            
               revalidate();
               repaint();
        
           int res = battle(a,b);
           
           //After the battle we test to see who won and print out the results
           if (res == 0)
              {
              
                   
              status = "Player 1 won the flip. Player 1 Score: "+player1.size()+". Player 2 Score: "+player2.size();

                
               revalidate();
               repaint();

              }
           else if (res == 1)
              {
              status = "Player 2 won the flip. Player 2 Score: "+player2.size()+". Player 1 Score: "+player1.size();


              }
              //For the tie we make ore card obejects and compare them 
           else
               {
               status= "Player 1 tied Player 2. Let the war begin!";

           
           int size3 = player1.size();
           int size4 = player2.size();
            Random tr = new Random();
            Random tr2 = new Random();
            Random tr3 = new Random();
            Random tr4 = new Random();
            
            
            int tri = tr.nextInt(size3);
            int tr2i = tr2.nextInt(size3);
            int tr3i = tr3.nextInt(size4);
            int tr4i = tr4.nextInt(size4);

            
         

            Card c = player1.get(tri);
            Card d = player1.get(tr2i);
            Card e = player2.get(tr3i);
            Card f = player2.get(tr4i);
            
              image4 = new ImageIcon("back.jpg");
              image5 = new ImageIcon(d.getImage());
              image6 = new ImageIcon("back.jpg");
              image7 = new ImageIcon(f.getImage());
   
              label3.setIcon(image4);
               label5.setIcon(image6);
              label4.setIcon(image5);
             
              label6.setIcon(image7);
              

             
            
              revalidate();
              repaint();
              
               int ult = battle(d,f);
           
           
           if (ult == 0)
              {
              status ="Player 1 won the tie.";
              player2.remove(e);
              player2.remove(f);
              player1.add(e);
              player1.add(f);

              }
           else if (ult == 1)
              {
              status ="Player 2 won the tie.";
              player1.remove(c);
              player1.remove(d);
              player2.add(c);
              player2.add(d);
     
              }
           else
               {
                status ="Player 1 tied Player 2 again.";}
                }
                }
               
         else
               {
               if (player1.size()==0)
               {
                  status= "Player 1 has lost.";
               
               }
               else 
               {
                  status ="Player 2 has lost.";
               }
               
               }
           
           
           
           }
           //If the user clicks new game button we perform the new game mehtod
        else if(command.equals("New Game"))
        {
           doNewGame();
           }
     } 
//addToHand is the method we use to add 26 cards to each player arraylist until deck is empty
     void addToHand() {


        for (int i=0; deck.isEmpty()==false; i++)
          {
               player1.add(deck.remove(0));     // Deal a card to the hand.
               i++;
               player2.add(deck.remove(0));     // Deal a card to the second hand.
               
         }
         

}
		  //Battle is my method that returns a value after comparing the cards 
		  public int battle(Card a, Card b)
        {
        int result = -1;
		  
        if ( a.getValue() < b.getValue() ) {
          player1.remove(a);
          player2.add(a);
          status = "Player 1 wins. Player 1 score:";

          return result = 1;
			  
			  
        }
		  else if ( a.getValue() > b.getValue() ) {
           player2.remove(b);
			  player1.add(b);
			  
           status = "Player 2 wins. Player 2 score:";
			  return result =0;
        }
        else if ( a.getValue() == b.getValue() ) {
          
           status = "Tie";
           
            return result = -1;  
        }
        

        repaint();
        return result;
      
}
     void doNewGame() {
            // Called by the constructor,if
            // the user clicks the "New Game" button.  Start a new game.
             
    
    status = "Flip the card to see who wins.";
    //Clearing the deck and the hands to start over again
    deck.clear();
    player1.clear();
    player2.clear();
 
        
      //Adding 52 card objects to the hand
      deck.add(new Card("2c.jpg",2));
      deck.add(new Card("2d.jpg",2));
      deck.add(new Card("2h.jpg",2));
      deck.add(new Card("2s.jpg",2));
      deck.add(new Card("3c.jpg",3));
      deck.add(new Card("3d.jpg",3));
      deck.add(new Card("3h.jpg",3));
      deck.add(new Card("3s.jpg",3));
      deck.add(new Card("4c.jpg",4));
      deck.add(new Card("4d.jpg",4));
      deck.add(new Card("4h.jpg",4));
      deck.add(new Card("4s.jpg",4));
      deck.add(new Card("5c.jpg",5));
      deck.add(new Card("5d.jpg",5));
      deck.add(new Card("5h.jpg",5));
      deck.add(new Card("5s.jpg",5));
      deck.add(new Card("6c.jpg",6));
      deck.add(new Card("6d.jpg",6));
      deck.add(new Card("6h.jpg",6));
      deck.add(new Card("6s.jpg",6));
      deck.add(new Card("7c.jpg",7));
      deck.add(new Card("7d.jpg",7));
      deck.add(new Card("7h.jpg",7));
      deck.add(new Card("7s.jpg",7));
      deck.add(new Card("8c.jpg",8));
      deck.add(new Card("8d.jpg",8));
      deck.add(new Card("8h.jpg",8));
      deck.add(new Card("8s.jpg",8));
      deck.add(new Card("9c.jpg",9));
      deck.add(new Card("9d.jpg",9));
      deck.add(new Card("9h.jpg",9));
      deck.add(new Card("9s.jpg",9));
      deck.add(new Card("10c.jpg",10));
      deck.add(new Card("10d.jpg",10));
      deck.add(new Card("10h.jpg",10));      
      deck.add(new Card("10s.jpg",10));
      deck.add(new Card("jackc.jpg",11));
      deck.add(new Card("jackd.jpg",11));
      deck.add(new Card("jackh.jpg",11));      
      deck.add(new Card("jacks.jpg",11));
      deck.add(new Card("queenc.jpg",12));
      deck.add(new Card("queend.jpg",12));
      deck.add(new Card("queenh.jpg",12));      
      deck.add(new Card("queens.jpg",12));
      deck.add(new Card("kingc.jpg",13));
      deck.add(new Card("kingd.jpg",13));
      deck.add(new Card("kingh.jpg",13));      
      deck.add(new Card("kings.jpg",13));
      deck.add(new Card("acec.jpg",14));
      deck.add(new Card("aced.jpg",14));
      deck.add(new Card("aceh.jpg",14));      
      deck.add(new Card("aces.jpg",14));
      
      //This part of the code allows us to display the neccessary cards on our labels
      image = new ImageIcon("back.jpg");
      image2 = new ImageIcon("back.jpg");
      image3 = null;
      image4 = null;
      image5 = null;
      image6 = null;

        
       label = new JLabel(image);
       label2 = new JLabel(image2);
       label3 = new JLabel(image3);
       label4 = new JLabel(image4);
       label5 = new JLabel(image5);
       label6 = new JLabel(image6);

       
       

      


           add(label);
           add(label2);
           add(label3);
           add(label5);
           add(label4);
           add(label6);
           
        //Shuffling the deck with Collections method
      Collections.shuffle(deck);
      

          addToHand();
         
        repaint();
     } 
     //Paint method I used to paint my "status" message
         public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.setFont(smallFont);
         g.drawString(status,50,550);
         
 
               }
	  
      }

}
