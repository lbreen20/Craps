
/**
 * The craps program allows a user to play the game craps, in which the rules are as
 * follows:
 * 1. A player rolls two six-sided dice and adds the numbers rolled together.
2. On this first roll, a 7 or an 11 automatically wins, and a 2, 3, or 12 
automatically loses, and play is over. If a 4, 5, 6, 8, 9, or 10 are rolled on 
this first roll, that number becomes the "point.”
3. The player continues to roll the two dice again until one of two things happens: 
either they roll the"point" from that first roll again, in which case they win; or 
they roll a 7, in which case they lose
 *
 * @author Luisa Breen
 * @version 1/15/20
 */
import java.util.Scanner;
public class Craps
{
    public static void giveInstructions()
    {
        Scanner in = new Scanner (System.in);
        System.out.println ("Would you like to play craps? [answer y/n]");
        String play = in.nextLine();
        if (play.equals ("") || play.substring (0,1).equalsIgnoreCase("y"))
        {
            System.out.println ("Do you need instructions?[answer y/n]");
            String instructions = in.nextLine();
            if (instructions.equals ("") || instructions.substring (0,1).equalsIgnoreCase("y"))
            {
                System.out.println ("1. Roll two six-sided dice and adds the numbers rolled together.");
                System.out.println ("2. If you get a 7 or 11 on this first roll you win");
                System.out.println ("3. If you get a 2, 3, or 12 on the first roll, you lose.");
                System.out.println ("4. Any other number you roll becomes your porint");
                System.out.println ("5. If you did not win or lose on the first roll, keep rolling until:");
                System.out.println ("a) you roll the point again, and win!");
                System.out.println ("b) you roll a 7, and lose!");
            }

        }
        else
        {
            System.out.println ("Okay, goodbye");
        }
 
    }
    
    
    public static int rollTheDice (Scanner in, Die d)
    {
        System.out.println ("Press enter to roll the dice");
        in.nextLine(); //not saving their input because they are just pressing enter
        int result1 = d.roll();
        int result2 = d.roll();
        int total = result1 + result2;
        System.out.println ("You rolled a" + result1 + "and a" + result2 + "for a total of" + total);
        return total;
    }
    
    
    public static void main (String [] args)
    {
        Scanner in = new Scanner (System.in);
        Die d = new Die();
        System.out.println ("The game of craps!");
        giveInstructions();
        System.out.println ("Let's play craps");
        String playStatus = "y";
        while (playStatus.substring(0,1).equalsIgnoreCase ("y"))
        {
            System.out.println ("First roll!");
            int result = rollTheDice (in,d);
            if (result == 7 || result == 11)
            {
                System.out.println ("You win!");
            }
            else if (result == 2 || result == 3 || result == 12)
            {
                System.out.println ("You lose");
            }
            else 
            {
                int point = result;
                System.out.println ("Your point is" + result + "." + "Roll again!");
                result = rollTheDice (in,d);
                while (result !=7 && result != point)
                {
                    System.out.println ("Roll again!");
                    result = rollTheDice (in,d);
                }
                if (result == 7)
                {
                    System.out.println ("You rolled a 7. You lose.");
                }
                else 
                {
                    System.out.println("Congratulations! You rolled your point so you win.");
                }
              
            }
            
           // System.out.println ("DEBUG: We're playing craps...");
            
            
            
            System.out.println ("Would you like to play again [y/n]?");
            playStatus = in.nextLine();
            if (playStatus.equals ("") ) {playStatus = "y";}
        }
        System.out.println ("Thanks for playing our game! Goodbye.");
    }
}
