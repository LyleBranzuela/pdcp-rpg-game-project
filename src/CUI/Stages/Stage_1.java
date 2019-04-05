/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Stages;

import CUI.Entity_Package.Player;
import CUI.GameOverScreen;
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

    /**
     * Create the content for stage 1.
     */
    @Override
    public void initiateStage(Player player)
    {
        // Iniating the Stage's Variables
        // 5 Minutes (In Seconds)
        this.currentPlayer = player;
        final int password = 1412;
        int userInput = 0;
        Scanner scan = new Scanner(System.in);

        try
        {

            System.out.print("[Type S to Skip Cutscene | Type Any to Start]: ");
            String selection = scan.nextLine();
            System.out.println("============================================================");
            switch (selection)
            {
                case "s":
                case "S":
                    System.out.println("[Skipping Cutscene...]");
                    Thread.sleep(2000);
                    break;
                default:
                    // First Paragraph - Intro
                    System.out.println("You wake up to find yourself locked in a prison cell.");
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
                    System.out.print("\n...");
                    Thread.sleep(3000);
                    System.out.print("You hear something...");
                    Thread.sleep(4000);
                    System.out.print("Someone talking.\n");
                    Thread.sleep(2000);
                    System.out.println("[\"We've captured " + player.getName() + ". Should we kill it off or offer it to them?\"]");
                    Thread.sleep(4000);
                    System.out.println("As you press your ears harder on the wall, you hear another person speak. A person with a much deeper voice...");
                    Thread.sleep(4000);
                    System.out.println("[\"Send..." + player.getName() + " to the entity. That way we'll be able to track the others.\"]");
                    Thread.sleep(5000);
                    System.out.println("[\"For now, we need to search for the others. The entity will take care of this.\"]");
                    Thread.sleep(3000);
                    System.out.println("You hear footsteps getting fainter and fainter as they leave the room outside.");
                    Thread.sleep(3000);
                    System.out.println("Realizing they are going to use you to find the other survivors, you start searching for a way to escape...");
                    Thread.sleep(3000);

                    // Third Paragraph - Rummaging Through The Room
                    System.out.println();
                    System.out.println("As you rummage through the room, you have found a note inside a drawer.");
                    Thread.sleep(3000);
                    System.out.println("You notice a lock that requires a 4 digit code to unlock.");
                    Thread.sleep(3000);
                    System.out.println("The note contains a riddle that might be the passcode, solve it and get out before the entity arrives: ");
                    Thread.sleep(3000);
            }
            // Fourth Paragraph - The Note
            System.out.println();
            System.out.println("The note suggests it's a four digit password:");
            Thread.sleep(2000);
            System.out.println("- The second digit is four times the first digit.");
            Thread.sleep(2000);
            System.out.println("- The third digit is three less than the second digit.");
            Thread.sleep(2000);
            System.out.println("- The the fourth digit is half of the second digit and two times the third digit.");
            Thread.sleep(2000);
            System.out.println("- The passcode must be answered within 5 minutes.");
            Thread.sleep(2000);

            int tries = 0;
            boolean expired = false;
            while (scan.hasNextInt())
            {
                scan.nextInt();
            }
            long limit = 300000L;
            long startTime = System.currentTimeMillis();
            while (userInput != password && tries != 3 && !expired)
            {
                try
                {
                    System.out.println("==============================================================================");
                    System.out.print("Enter the passcode: ");
                    userInput = scan.nextInt();
                    if ((startTime + limit) < System.currentTimeMillis())
                    {
                        expired = true;
                        System.out.println("You ran out of time and the guards come in.");
                        GameOverScreen.printGameOverScreen(player, "You have been detected!");
                    }
                    System.out.print("...");

                    if (userInput != password)
                    {
                        tries++;
                        System.out.print("The passcode was wrong, " + tries + " of the 3 RED DOTS glow.\n");
                    }
                }
                // If the user inputted a passcode that isn't a number.
                catch (InputMismatchException e)
                {
                    System.out.print("The passcode only seems to accept numbers.\n");
                    scan = new Scanner(System.in);
                }
                finally
                {
                    if (tries == 3)
                    {
                        System.out.print("All the red dots on the passcode glows...\n");
                        Thread.sleep(2000);
                        System.out.println("The alarm goes off and the guard notices you.");
                        System.out.println();
                        GameOverScreen.printGameOverScreen(player, "You have been detected!");
                    }
                }
            }
            System.out.print("\n\n==============================================================================\n");
            System.out.println("The lock came off, you peek through the door to see three patrolling guards.");
            System.out.println("==============================================================================");
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
