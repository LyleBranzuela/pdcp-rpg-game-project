/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Stages;

import CUI.Entity_Package.Player;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for the Stage 1 of the Game.
 * @author lyleb and khoap
 */
public class Stage_2 extends Stage
{
    Random rand = new Random();
    String userInput = "";
    String guardMovement = "";
    Scanner scan = new Scanner(System.in);
    boolean isCompleted = false;
    boolean isValid = false;
    
     /**
      * Generates a number for movement creation
      * 
      * @return An int with values from 1 - 3
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
        
        switch(x){
            case 1: 
                System.out.println("The guard is moving away from you. You are free to move forward.");
                guardMovement = "S";
                break;
            case 2:
                System.out.println("The guard is coming from the right, avoid him!");
                guardMovement = "D";
                break;
            case 3:
                System.out.println("The guard coming from the left, avoid him!");
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
        
        switch(guardMovement)
        {
            case "S":
                if(userInput.equalsIgnoreCase("W"))
                {
                    isCorrect = true;
                }
                break;
            case "A":
                if(userInput.equalsIgnoreCase("D"))
                {
                    isCorrect = true;
                }
                break;
            case "D":
                if(userInput.equalsIgnoreCase("A"))
                {
                    isCorrect = true;
                }
                break;
            default:
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
        int successAttempt = 0;
        try {
            System.out.println("You broke out of the cell! Now sneak past the guards and find your way out!");
            Thread.sleep(3000);
            System.out.println("Watch the guards' movements and don't walk in the same direction they're heading!");
            
            while(successAttempt != 3)
            {
                this.genMove();
                while(isValid != true)
                {
                    userInput = scan.nextLine();
                    if(!"W".equalsIgnoreCase(userInput) && !"A".equalsIgnoreCase(userInput) && !"S".equalsIgnoreCase(userInput) && !"D".equalsIgnoreCase(userInput))
                    {
                        System.out.println("Invalid input! Try again!");
                    }
                    else
                    {
                        isValid = true;
                    }      
                }
                if(checkMove())
                {
                    successAttempt++;
                }
                else
                    this.isCompleted = false;
            }
            
            System.out.println("You have successfully avoided all three guards! Look for the exit now!");
            this.isCompleted = true;
            player.setCurrentStageLevel(new Stage_3());
            player.getCurrentStage().initiateStage(player);
        } 
        catch (InterruptedException ex) 
        {
            Thread.currentThread().interrupt(); // restore interrupted status
        }    
    }
}
