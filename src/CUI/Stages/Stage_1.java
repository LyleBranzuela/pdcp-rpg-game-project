/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Stages;

import CUI.Entity_Package.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for the Stage 1 of the Game. Password by the riddle that needs to be
 * inputted by the user.
 *
 * Player input a number to unlock a padlock to escape their cell
 *
 * @author lyleb and khoap
 */
public class Stage_1 extends Stage
{

    private boolean isCompleted = false;
    private final int password = 1412;
    public int userInput;

    /**
     * Create the content for stage 1.
     */
    @Override
    public void initiateStage(Player player)
    {
        Scanner scan = new Scanner(System.in);
        try
        {
            // First Paragraph - Intro
            System.out.println("You wake up to find yourself locked in a prison cell");
            Thread.sleep(2000);
            System.out.println("You vividly remember what happened last night.");
            Thread.sleep(2000);
            System.out.println("While searching for supplies, you were captured by a group of infected.");
            Thread.sleep(3000);

            // Second Paragraph - Eavesdropping
            System.out.println();
            System.out.println("You hear a faint noise coming from the door. ");
            Thread.sleep(2000);
            System.out.println("Curious, and confused, you pressed your head onto it to hear it more clearly.");
            Thread.sleep(2000);
            System.out.println("...");
            Thread.sleep(3000);
            System.out.println("You hear something...");
            Thread.sleep(4000);
            System.out.println("Someone talking...");
            Thread.sleep(2000);
            System.out.println("[\"We've captured this person named " + player.getName() + ". Should we kill it off or offer it to them?\"]");
            Thread.sleep(4000);
            System.out.println("As you press your ears harder on the wall, you hear another person speak. A person with a much deeper voice...");
            Thread.sleep(4000);
            System.out.println("[\"Send..." + player.getName() + " to the entity. That way we'll be able to track the others.\"]");
            Thread.sleep(5000);
            System.out.println("[\"For now, we need to search for the others. The entity will take care of this guy.\"]");
            Thread.sleep(3000);
            System.out.println("You hear footsteps getting fainter and fainter as they leave the room outside.");
            Thread.sleep(3000);
            System.out.println("Realizing they are going to use you to find the other survivors, you start searching for a way to escape...");
            Thread.sleep(5000);

            // Third Paragraph - Rummaging Through The Room
            System.out.println();
            System.out.println("As you rummage through the room, you have found a note inside a drawer.");
            Thread.sleep(3000);
            System.out.println("You notice a lock that requires a 4 digit code to unlock.");
            Thread.sleep(3000);
            System.out.println("The note contains a riddle that might be the passcode, solve it and get out before the entity arrives: ");
            Thread.sleep(3000);

            // Fourth Paragraph - The Note
            System.out.println();
            System.out.println("The note suggests it's a four digit password:  ");
            Thread.sleep(2000);
            System.out.println("- The second digit is four times the first digit.");
            Thread.sleep(2000);
            System.out.println("- The third digit is three less than the second digit.");
            Thread.sleep(2000);
            System.out.println("- The the fourth digit is two times the third digit.");
            Thread.sleep(2000);
            System.out.print("Enter the passcode: ");

            while (this.userInput != this.password)
            {
                this.userInput = scan.nextInt();
                if (this.userInput != this.password)
                {
                    Thread.sleep(1000);
                    System.out.print("...");
                    Thread.sleep(2000);
                    System.out.println("The passcode was wrong, try again.");
                    System.out.print("Enter the passcode: ");
                }
            }
            Thread.sleep(2000);
            System.out.println("...");
            Thread.sleep(4000);
            System.out.println("============================================================================");
            System.out.println("The lock came off, you peaked through the door to see three patrolling guards.");
            System.out.println("============================================================================");
            this.isCompleted = true;
            // Sets the stage level into Stage 2 and Iniate it with the Player Object
            player.setCurrentStageLevel(new Stage_2());
            player.getCurrentStage().initiateStage(player);
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt(); // restore interrupted status
        }
    }
}
