/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Stages;

import CUI.Entity_Package.Player;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            System.out.println("Captured by a group of Infecteds while searching for supplies, you wake up to find yourself locked in a laboratory");
            Thread.sleep(5000);
            System.out.println("Using your enhanced sense of hearing, you overheard that the Entity is coming to corrupt you");
            Thread.sleep(5000);
            System.out.println("Realizing they are going to use you to find the other survivors, you start searching for a way to escape...");
            Thread.sleep(5000);
            System.out.println();
            System.out.println("You have found a note in the room");
            Thread.sleep(2000);
            System.out.println("The note contains a riddle that might be the passcode, solve it and get out before the entity arrives: ");
            Thread.sleep(3000);
            System.out.println();
            System.out.println("This is a four digit number:  ");
            Thread.sleep(2000);
            System.out.println("- The second digit is four times the first digit.");
            Thread.sleep(2000);
            System.out.println("- The third digit is three less than the second digit.");
            Thread.sleep(2000);
            System.out.println("- The the fourth digit is two times the third digit.");

            Thread.sleep(2000);

            System.out.println("Enter the passcode: ");

            while (this.userInput != this.password)
            {
                this.userInput = scan.nextInt();
                if (this.userInput != this.password)
                {
                    System.out.println("That was wrong, try again!");
                }
            }

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
