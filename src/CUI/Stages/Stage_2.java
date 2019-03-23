/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Stages;

import CUI.Entity_Package.Player;
import CUI.GameOverScreen;
import java.util.Random;
import java.util.Scanner;

/**
 * Class for the Stage 1 of the Game.
 *
 * @author lyleb and khoap
 */
public class Stage_2 extends Stage
{
    Player player;
    Random rand = new Random();
    String userInput;
    String guardMovement;
    boolean isCompleted;
    boolean isValid;
    boolean isCorrect;

    /**
     * Generates a number for movement creation
     *
     * @return An integer with values from 1 - 3
     */
    public int genNum()
    {
        int number = rand.nextInt(2) + 1;

        return number;
    }

    /**
     * Generates movements from random numbers
     *
     * @return nothing.
     */
    private void genMove()
    {
        int x = genNum();

        switch (x)
        {
            case 1:
                System.out.println("The guard in the middle is moving away from you, but there's still guards on the side.");
                guardMovement = "S";
                break;
            case 2:
                System.out.println("A guard is coming from the right, avoid him!");
                guardMovement = "D";
                break;
            case 3:
                System.out.println("A guard iscoming from the left, avoid him!");
                guardMovement = "A";
                break;
            default:
                guardMovement = "W";
        }
    }

    /**
     * Checks to see if player has made the correct move.
     *
     * @return isCorrect boolean.
     */
    private boolean checkMove()
    {
        this.isCorrect = false;
        switch (this.guardMovement)
        {
            case "S":
                if (this.userInput.equalsIgnoreCase("W"))
                {
                    this.isCorrect = true;
                    this.isCompleted = true;
                }
                else
                {
                    System.out.println("");
                    GameOverScreen.printGameOverScreen(this.player, "Game Over! You have been detected!");
                    this.isCorrect = false;
                    this.isCompleted = false;
                }
                break;
            case "A":
                if (this.userInput.equalsIgnoreCase("D"))
                {
                    this.isCorrect = true;
                    this.isCompleted = true;
                }
                else
                {
                    System.out.println("");
                    GameOverScreen.printGameOverScreen(this.player, "Game Over! You have been detected!");
                    this.isCorrect = false;
                    this.isCompleted = false;
                }
                break;
            case "D":
                if (userInput.equalsIgnoreCase("A"))
                {
                    this.isCorrect = true;
                    this.isCompleted = true;
                }
                else
                {
                    System.out.println("");
                    GameOverScreen.printGameOverScreen(this.player, "Game Over! You have been detected!");
                    this.isCorrect = false;
                    this.isCompleted = false;
                }
                break;
            default:
                this.isCorrect = false;
                this.isCompleted = false;
                break;
        }
        return isCorrect;
    }

    /**
     * Create the content for stage 2.
     */
    @Override
    public void initiateStage(Player player)
    {
        // Iniating the Stage's Default Attributes
        Scanner scan = new Scanner(System.in);
        this.userInput = "";
        this.guardMovement = "";
        this.isCompleted = true;
        this.isValid = false;
        this.isCorrect = false;
        this.player = player;
        int successAttempt = 0;
        
        // Start Stage
        try
        {
            System.out.println("You broke out of the cell! Now sneak past the guards and find your way out!");
            Thread.sleep(2000);
            System.out.println("Watch the guards' movements and don't walk in the same direction they're heading!");
            Thread.sleep(2000);
            System.out.println("");
            System.out.println("[MOVEMENT: A - MOVE LEFT | W - MOVE FORWARD | D - MOVE RIGHT]");

            for (successAttempt = 0; successAttempt < 3; successAttempt++)  //Generates 3 moves and check for input.
            {
                this.genMove();
                System.out.print("Action [A|W|D]: ");
                do
                {
                    this.userInput = scan.nextLine();

                    if (!"W".equalsIgnoreCase(this.userInput) && !"A".equalsIgnoreCase(this.userInput)
                            && !"S".equalsIgnoreCase(this.userInput) && !"D".equalsIgnoreCase(this.userInput))
                    {
                        System.out.println("Invalid input! Try again!");
                    }

                    else
                    {
                        this.isValid = true;
                    }
                } while (!isValid);   //Validates user input

                if (checkMove())
                {
                    System.out.println("");
                    System.out.println("You have avoided that guard. Keep moving!");
                    System.out.println("");
                    Thread.sleep(1000);
                }
                else
                {
                    successAttempt = successAttempt + 3;   //Adds 3 to successAttempt to force break the loop upon detection.
                }
            }

            if (this.isCompleted == true)    // checks for stage completion and iniate stage 3 if completed
            {
                System.out.println("");
                System.out.println("==============================================================================");
                System.out.println("You have successfully avoided all three guards!");
                Thread.sleep(1000);
                System.out.println("You open a door and see a room with three weapons.");
                System.out.println("==============================================================================");

                player.setCurrentStageLevel(new Stage_3());
                player.getCurrentStage().initiateStage(player);
            }

        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt(); // restore interrupted status
        }
    }
}
