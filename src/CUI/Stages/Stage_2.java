/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Stages;

import CUI.Entity_Package.Player;
import CUI.GameOverScreen;
import CUI.UtilityMethods;
import java.util.Scanner;

/**
 * Class for the Stage 1 of the Game.
 *
 * @author lyleb and khoap
 */
public class Stage_2 extends Stage
{

    private Player player;
    private String userInput;
    private String guardMovement;
    private boolean isCompleted;

    /**
     * Generates movements from random numbers
     *
     * @return nothing.
     */
    private void genMove()
    {
        int x = UtilityMethods.randNum(3) + 1;

        switch (x)
        {
            case 1:
                System.out.println("The guard in the middle is moving away from you, but there's still danger on the side.");
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
        boolean isCorrect = false;
        switch (this.guardMovement)
        {
            case "S":
                if (this.userInput.equalsIgnoreCase("W"))
                {
                    isCorrect = true;
                    this.isCompleted = true;
                }
                else
                {
                    System.out.println("");
                    GameOverScreen.printGameOverScreen(this.player, "Game Over! You have been detected!");
                    isCorrect = false;
                    this.isCompleted = false;
                }
                break;
            case "A":
                if (this.userInput.equalsIgnoreCase("D"))
                {
                    isCorrect = true;
                    this.isCompleted = true;
                }
                else
                {
                    System.out.println("");
                    GameOverScreen.printGameOverScreen(this.player, "Game Over! You have been detected!");
                    isCorrect = false;
                    this.isCompleted = false;
                }
                break;
            case "D":
                if (userInput.equalsIgnoreCase("A"))
                {
                    isCorrect = true;
                    this.isCompleted = true;
                }
                else
                {
                    System.out.println("");
                    GameOverScreen.printGameOverScreen(this.player, "Game Over! You have been detected!");
                    isCorrect = false;
                    this.isCompleted = false;
                }
                break;
            default:
                isCorrect = false;
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
        this.player = player;
        int successAttempt = 0;
        boolean isValid = false;

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
                // Clears out the buffer that was inputted beforehand.
                scan.close();
                scan = new Scanner(System.in); 
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
                        isValid = true;
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
                System.out.println("");
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
