import java.util.ArrayList;
import java.util.Scanner;

public class UNO_Main_Class
{
    public static void main(String[] args)
    {
        ArrayList<UnoCard_Class> playerCards = new ArrayList<UnoCard_Class>();
        ArrayList<UnoCard_Class> compCards = new ArrayList<UnoCard_Class>();
        
        int result; 
        Scanner stdin = new Scanner(System.in); 
        UnoCard_Class topCard; 		
        int choice; 		
        String currentColor; 	

        
        
        // loop for turns 
        gameLoop:
        while (true)
        {
            playerCards.clear();
            compCards.clear();
            result = 0;
            topCard = new UnoCard_Class();
            currentColor = topCard.color;

            System.out.println("\t\t\t** Welcome to Uno Sesame Street Version **");
            System.out.println("\t\t\t^^ ^^^^^^^ ^^ ^^^ ^^^^^^ ^^^^^^ ^^^^^^^ ^^ \n");

            withdraw(7, playerCards);
            withdraw(7, compCards);

            
             
            //loop for turns of the computer and the player 
            
            for (boolean playersTurn = true; result == 0; playersTurn ^= true)
            {
                choice = 0;
                System.out.println("\nThe top card is: " + topCard.getFace());

                 								
                
                
                if (playersTurn)
                {

                	// Displaying player's cards
                	
                    System.out.println("Your turn! Your choices:");
                    for (int i = 0; i < playerCards.size(); i++)
                    {
                        System.out.print(String.valueOf(i + 1) + ". " + 
                        ((UnoCard_Class) playerCards.get(i) ).getFace() + "\n");
                    }
                    
                    System.out.println(String.valueOf(playerCards.size() + 1 ) + ". " + "Draw card" + "\n" + 
                                       String.valueOf(playerCards.size() + 2) + ". " + "Quit");
                    
                    
                    
                    // loop for entering your choice 
                    do
                    {
                        System.out.print("\nEnter your choice: ");
                    } while (!stdin.hasNextInt() );
                    
                    
                    choice = stdin.nextInt() - 1;

                   
                    if (choice == playerCards.size() )
                    	withdraw(1, playerCards);
                   
                    else if (choice == playerCards.size() + 1)
                        break gameLoop;
                    
                    else if ( ((UnoCard_Class) playerCards.get(choice)).matches(topCard, currentColor) )
                    {
                        topCard = (UnoCard_Class) playerCards.get(choice);
                        playerCards.remove(choice);
                        currentColor = topCard.color;
                    
                        if (topCard.value >= 8)
                        {
                            playersTurn = false; 	

                            switch (topCard.value)
                            {
                                case 8: 		
                                System.out.println("Computer is drawing 1 card...");
                                withdraw(1,compCards);
                                break;

                                case 9:
                                System.out.println("Computer is drawing 2 cards...");
                                withdraw(2,compCards);
                                break; 
                                	
                                case 10: 			
                                String c;
                                do 					
                                {
                                    System.out.print("\nEnter the color you want: ");
                                    stdin = new Scanner(System.in);
                                } while(!stdin.hasNext("R..|r..|G....|g....|B...|b...|Y.....|y.....")); 
                             
                                if (stdin.hasNext("Red|red") )
                                    currentColor = "Red";
                                
                                else if (stdin.hasNext("Green|green") )
                                    currentColor = "Green";
                                
                                else if (stdin.hasNext("Blue|blue") )
                                    currentColor = "Blue";
                                
                                else if (stdin.hasNext("Yellow|yellow") )
                                    currentColor = "Yellow";

                                System.out.println("You chose " + currentColor);
                                break;
                            }
                        }
                    } 
                    
                    else System.out.println("Invalid choice. Turn skipped.");


                } 
                
                
                
                
                else 
                {
                    System.out.println("Computer's turn! It has " + String.valueOf(compCards.size() ) 
                                        + " cards left!" + ((compCards.size() == 1) ? "...Uno!":"") );
                    
                    
                    for (choice = 0; choice < compCards.size(); choice++)
                    {
                    	
                    	
                    	if ( ((UnoCard_Class) compCards.get(choice)).matches(topCard, currentColor) ) 
                            break; 
                    
                    }

                    if (choice == compCards.size() )
                    {
                         System.out.println("It has got no matching cards! Drawing cards...");
                         withdraw(1,compCards);
                    } 
                    
                    else 
                    {
                         topCard = (UnoCard_Class) compCards.get(choice);
                         compCards.remove(choice);
                        
                         currentColor = topCard.color;
                         System.out.println("It chooses " + topCard.getFace() + " !");

                         if (topCard.value >= 8)
                         {
                             playersTurn = true; 	// Skipping turn

                             switch (topCard.value)
                             {
                                 case 8: 			// Draw 1
                                 System.out.println("Drawing 1 card for you...");
                                 withdraw(1,playerCards);
                                 break;

                                 case 9:
                                 System.out.println("Drawing 2 cards for you...");
                                 withdraw(2,playerCards);
                                 break; 
                                 
                                 case 10:	 		 // Wild cards                         
                                 do					 
                                 {
                                     currentColor = new UnoCard_Class().color;
                                 } while (currentColor == "none");

                                 System.out.println("New color is " + currentColor);
                                 break;
                             }
                         }
                    }

                    
                    // checking for presence of cards 
                    if (playerCards.size() == 0)
                        result = 1;
                  
                    else if (compCards.size() == 0)
                        result = -1;
                }

            } 						
            // turns loop end

            
            
            
            
            if (result == 1)
                System.out.println("You win :)");
            
            else 
                System.out.println("You lose :(");

            System.out.print("\nDo you want to play again? ");
            stdin = new Scanner(System.in);

            if (stdin.next().toLowerCase().contains("n") )
                break;
        
        } 

        System.out.println("Thank you for playing UNO!");
    }
    
    
    // For drawing cards
    public static void withdraw(int cards, ArrayList<UnoCard_Class> deck)
    {
        for (int i = 0; i < cards; i++)
            deck.add(new UnoCard_Class() );
    }
}