/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Stages;

import CUI.Entity_Package.Entity;
import CUI.Entity_Package.Monster;
import CUI.Entity_Package.Player;
import CUI.GameOverScreen;
import CUI.Items.Blindfold;
import CUI.Items.Item;
import CUI.UtilityMethods;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/**
 * Class for the Stage 4 of the Game.
 *
 * @author lyleb and khoap
 */
public class Stage_4 extends Stage
{

    public int x, parryDiff;
    private ArrayList<String> easyParry;
    private ArrayList<String> mediumParry;
    private ArrayList<String> hardParry;

    /**
     * Function to add monster's attacks and solutions to arrays
     * 
     */
    public void addMoves()
    {
        // Generate the Easy Difficulty
        this.easyParry = new ArrayList();
        this.easyParry.add("W");
        this.easyParry.add("A");
        this.easyParry.add("D");
        this.easyParry.add("S");
        this.easyParry.add("D");
        this.easyParry.add("A");

        // Generate the Medium Difficulty
        this.mediumParry = new ArrayList();
        this.mediumParry.add("WW");
        this.mediumParry.add("WA");
        this.mediumParry.add("WD");
        this.mediumParry.add("SS");
        this.mediumParry.add("SD");
        this.mediumParry.add("SA");

        // Generate the Hard Difficulty
        this.hardParry = new ArrayList();
        this.hardParry.add("WAD");
        this.hardParry.add("WWA");
        this.hardParry.add("WWD");
        this.hardParry.add("SDA");
        this.hardParry.add("SSD");
        this.hardParry.add("SSA");
    }

    /**
     * Generates a random parry sequence for the user to deal with.
     *
     * @param parrySeq parry sequence to use.
     * @return the string version of the generated parry.
     */
    public String genParry(int parrySeq)
    {
        this.x = UtilityMethods.randNum(3);
        // Set Parry Difficulty
        this.parryDiff = parrySeq;
        String currentMove = "";

        // Difficulty >> [1 = Easy], [2 = Medium], [3 = Hard]
        switch (parrySeq)
        {
            case 1:
                currentMove = this.easyParry.get(x);
                break;
            case 2:
                currentMove = this.mediumParry.get(x);
                break;
            case 3:
                currentMove = this.hardParry.get(x);
                break;
            default:
                break;
        }

        return currentMove;
    }

    /**
     * Function to check whether the user's parry worked.
     *
     * @param userParry user's parry choice.
     * @return if it's a successful parry or not.
     */
    public boolean checkParry(String userParry)
    {
        boolean isCorrect = false;
        switch (this.parryDiff)
        {
            case 1:
                isCorrect = userParry.equalsIgnoreCase(this.easyParry.get(this.x + 3));
                break;
            case 2:
                isCorrect = userParry.equalsIgnoreCase(this.mediumParry.get(this.x + 3));
                break;
            case 3:
                isCorrect = userParry.equalsIgnoreCase(this.hardParry.get(this.x + 3));
                break;
            default:
                isCorrect = false;
                break;
        }
        return isCorrect;
    }

    /**
     * Calculate difference in player's and monster's horizontal coordinates.
     * 
     * @param player current player playing.
     * @param monster what monster to print.
     * @return horizontal distance between player and monster
     */
    public int getXDiff(Player player, Entity monster)
    {
        int xDiff = monster.x_coord - player.x_coord;

        return xDiff;
    }

    /**
     * Calculate difference in player's and monster's vertical coordinates.
     * 
     * @param player current player playing.
     * @param monster what monster the entity is.
     * @return vertical distance between player and monster
     */
    public int getYDiff(Player player, Entity monster)
    {
        int yDiff = monster.y_coord - player.y_coord;

        return yDiff;
    }

    /**
     * Returns the parry difficulty of the parry generated.
     * 
     * @return parry difficulty.
     */
    public int getParrySeq()
    {
        return this.parryDiff;
    }

    /**
     * Generate horizontal directional guides for player to find monster
     * 
     * @param player current player playing.
     * @param monster what monster to print.
     */
    public void printHorizon(Player player, Entity monster)
    {
        //Less than 0 = left, more than 0 = right, 0 = straight ahead.
        if (getXDiff(player, monster) < 0)
        {
            System.out.println("");
            System.out.println("You hear the sound coming from the left");
        }

        else if (getXDiff(player, monster) > 0)
        {
            System.out.println("");
            System.out.println("You hear the sound coming from the right");
        }

        else if (getXDiff(player, monster) == 0)
        {
            System.out.println("");
            System.out.println("You hear the sound straight ahead.");
        }

    }

    /**
     * Generate vertical directional guides for the player to find the monster
     * 
     * @param player current player playing.
     * @param monster what monster to print.
     */
    public void printVertical(Player player, Entity monster)
    {
        switch (getYDiff(player, monster))
        {
            case 0:
                System.out.println("...and it is extremely loud.");
                System.out.println("");
                break;
            case 1:
                System.out.println("...and it is much louder.");
                System.out.println("");
                break;
            case 2:
                System.out.println("...and it is getting louder.");
                System.out.println("");
                break;
            case 3:
                System.out.println("...and it is at a consistent volume.");
                System.out.println("");
                break;
            default:
                break;
        }

        if (getYDiff(player, monster) > 3)
        {
            System.out.println("...and it is getting quieter.");
            System.out.println("");
        }
        else if (getYDiff(player, monster) < 0)
        {
            System.out.println("...and you have just moved past it.");
            System.out.println("");
        }
    }

    /**
     * Creates the content for Stage 4
     * 
     * @param player current player playing.
     */
    @Override
    public void initiateStage(Player player)
    {
        try
        {
            super.stageLevel = 4;
            Player checkPointPlayer = player;
            Scanner scan = new Scanner(System.in);
            Random rand = new Random();
            Entity monster = new Monster("THE ENTITY");
            String userInput = "";
            int userAction;
            Item blindfold = new Blindfold();
            
            
            addMoves();
            
            boolean isMoveValid = false;
            boolean isMoveCorrect = false;
            int parrySuccess = 0;
            
            monster.setHealth(3);
            player.setHealth(1);
            monster.setLocation(rand.nextInt(5) + 3, 3);
            player.setLocation(5, 0);
            
            System.out.println("You followed the footprints and howls to a large room...");
            System.out.println("");
            Thread.sleep(2000);
            System.out.print("You're about to meet THE ENTITY, put your blindfold on! (Press 2): ");
            
            do 
            {
                try
                {
                    scan = new Scanner(System.in);
                    userAction = scan.nextInt();
                    if (userAction != 2)
                    {
                        System.out.println("[Invalid Input!]");
                        isMoveCorrect = false;
                    }
                    else
                    {
                        blindfold.useItem();
                        isMoveCorrect = true;
                    }
                }
                catch(InputMismatchException e)
                {
                    System.out.println("");
                    System.out.println("Invalid input! Please try again.");
                    scan = new Scanner(System.in);
                    System.out.println("");
                                    
                }
            } while (!isMoveCorrect);
            
            System.out.println("...");
            System.out.println("");
            Thread.sleep(2000);
            System.out.println("Use only your hearing and instincts to find the monster as seeing it would cause you to go insane");
            System.out.println("");
            Thread.sleep(2000);
            
            while (player.x_coord != monster.x_coord || player.y_coord != monster.y_coord)
            {
                printHorizon(player, monster);
                printVertical(player, monster);
                
                System.out.print("Your move(W/A/S/D): ");
                do
                {
                    scan = new Scanner(System.in);
                    userInput = scan.nextLine();
                   
                    if (!userInput.equalsIgnoreCase("W") && !userInput.equalsIgnoreCase("A")
                            && !userInput.equalsIgnoreCase("D") && !userInput.equalsIgnoreCase("S"))
                    {
                        System.out.println("Invalid input! Try again!");
                    }
                    else
                    {
                        isMoveValid = true;
                    }
                } while (!isMoveValid);  // Validates user input
                
                switch (userInput)
                {
                    case "W":
                        player.y_coord = player.y_coord + 1;
                        break;
                    case "S":
                        player.y_coord = player.y_coord - 1;
                        break;
                    case "A":
                        player.x_coord = player.x_coord - 1;
                        break;
                    case "D":
                        player.x_coord = player.x_coord + 1;
                        break;
                    default:
                        break;
                }
            }
            
            isMoveCorrect = false;
            isMoveValid = false;
            System.out.println("...");
            Thread.sleep(2000);
            System.out.println("You found THE ENTITY! Reverse its attacks to parry and look for openings!");
            
            while (monster.getHealth() > 0 && player.getHealth() != 0)
            {
                System.out.println("");
                Thread.sleep(2000);
                System.out.println("The monster used the following move: " + genParry(player.showWeapon().parrySeq()));
                System.out.print("Parry the attack: ");
                
                do
                {
                    scan = new Scanner(System.in);
                    userInput = scan.nextLine();
                    if (userInput.length() != getParrySeq())
                    {
                        System.out.println("Invalid input! Please try again");
                    }
                    
                    else if (!userInput.equalsIgnoreCase("S") && !userInput.equalsIgnoreCase("A") && !userInput.equalsIgnoreCase("D") && !userInput.equalsIgnoreCase("W")
                            && !userInput.equalsIgnoreCase("SS") && !userInput.equalsIgnoreCase("SD") && !userInput.equalsIgnoreCase("SA")
                            && !userInput.equalsIgnoreCase("SDA") && !userInput.equalsIgnoreCase("SSD") && !userInput.equalsIgnoreCase("SSA"))
                    {
                        player.setHealth(0);
                        // Starts all over from the Check Point
                        GameOverScreen.printGameOverScreen(checkPointPlayer, "Game over! You failed to counter the attack.");
                        break;
                    }
                    else
                    {
                        isMoveValid = true;
                    }
                } while (!isMoveValid);
                
                if (checkParry(userInput))
                {
                    parrySuccess++;
                    // Checks amount of successful attempt. Allows attack after every 3 successful block.
                    switch (parrySuccess)
                    {
                        case 3:
                        case 6:
                        case 9:
                            System.out.print("You found a weak spot, strike now! (Press 1): ");
                            
                            do 
                            {
                                try
                                {
                                    scan = new Scanner(System.in);
                                    userAction = scan.nextInt();
                                    if (userAction != 1)
                                    {
                                        System.out.println("[Invalid Input!]");
                                        isMoveCorrect = false;
                                    }
                                    else
                                    {
                                        System.out.println("You dealt " + player.showWeapon().attack() + " damage to the Entity");
                                        monster.setHealth(monster.getHealth() - player.showWeapon().attack());
                                        isMoveCorrect = true;
                                    }
                                }
                                catch(InputMismatchException e)
                                {
                                    System.out.println("");
                                    System.out.println("Invalid input! Please try again.");
                                    scan = new Scanner(System.in);
                                    System.out.println("");
                                    
                                }
                            } while (!isMoveCorrect);
                    }
                }
                
                else
                    player.setHealth(0); //Kills player if he fails to parry
            }
            
            
            if (monster.getHealth() <= 0 && player.getHealth() > 0)
            {
                Thread.sleep(2000);
                System.out.println("");
                System.out.println("With that fatal blow, you've defeated the monster.");
                Thread.sleep(1000);
                System.out.println("The apocalypse is finally over.");
                System.out.println("================================================================================");
            }
            else if(player.getHealth() == 0)
            {
                GameOverScreen.printGameOverScreen(checkPointPlayer, "Game over! You failed to dodge the entity's attack...");
            }
        } 
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt(); // restore interrupted status
        }      
   }
}
