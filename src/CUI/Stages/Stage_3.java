/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Stages;

import CUI.Entity_Package.Player;
import CUI.Items.BarbedBat;
import CUI.Items.Daggers;
import CUI.Items.Item;
import CUI.Items.Machete;
import CUI.Items.Weapon;
import static CUI.UtilityMethods.clearScreen;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for the Stage 3 of the Game.
 * @author lyleb and khoap
 */
public class Stage_3 extends Stage
{
    Scanner scan = new Scanner(System.in);
    String userInput;
    int weaponChoice;
    boolean isValid = false;
    Item dualDag = new Daggers();
    Item barbedBat = new BarbedBat();
    Item machete = new Machete();
    
    
    /*
     * Creates content for stage 3
     *
     */
    @Override
    public void initiateStage(Player player)
    {
        try {
            // Continues from stage 2 and prints weapon info
            clearScreen();
            System.out.println("As you walk down a long hallway, you found a room where police kept confiscated weapons");
            System.out.println("");
            Thread.sleep(3000);
            System.out.println("Knowing guns will disrupt your hearing as well as alert the Infected, you start digging for something else");
            System.out.println("");
            Thread.sleep(3000);
            System.out.println("You have found: ");
            System.out.println("1) Barbed Bat: " + barbedBat.printDescription());
            System.out.println("2) Dual Daggers: " + dualDag.printDescription());
            System.out.println("3) Heavy Machete: " + machete.printDescription());
            System.out.println("");
            System.out.println("Pick a weapon (1/2/3): ");
            
            do {
                userInput = scan.nextLine();
                
                try {
                    weaponChoice = Integer.parseInt(userInput);
                    if(weaponChoice != 1 && weaponChoice !=2 && weaponChoice != 3)
                    {
                        System.out.println("Invalid input! Please input a number from 1 - 3");
                        isValid = false;
                    }
                    else
                    {    
                        switch(weaponChoice)
                        {
                            case 1:
                                player.pickupItem(this.barbedBat);
                                break;
                            case 2:
                                player.pickupItem(this.dualDag);
                                break;
                            case 3:
                                player.pickupItem(this.machete);
                                break;
                            default:
                                break;
                        }
                        isValid = true;
                    }
                } 
                catch (NumberFormatException e) {
                    
                    isValid = false;
                    System.out.println("Invalid input! Please input a number from 1 - 3");
                }
            } while (!isValid);  //Validates user input to make sure it is a number between 1 - 3.
            
   
            System.out.println("");
            System.out.println("You hear a strange howl followed by loud footsteps. The entity has arrived");
            Thread.sleep(3000);
            System.out.println("");
            System.out.println("You think to yourself: If you can kill the entity, everything will be back to normal");
            Thread.sleep(3000);
            System.out.println("");
            System.out.println("You walk out of the locker, heading towards the direction of the howl.");
            
            player.setCurrentStageLevel(new Stage_4());
            player.getCurrentStage().initiateStage(player);
            
            } 
        catch (InterruptedException ex) 
        {
            Thread.currentThread().interrupt(); // restore interrupted status
        }
    }
    
//    public static void main(String[] args)
//    {
//        Player test = new Player("Test");
//        Stage stage3 = new Stage_3();
//        
//        stage3.initiateStage(test);
//    }
}