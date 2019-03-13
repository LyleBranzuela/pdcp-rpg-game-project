/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI;

import CUI.Entity_Package.Player;
import CUI.Stages.Stage;
import CUI.Stages.Stage_1;
import java.util.Scanner;

/**
 *
 * @author lyleb and khoap
 */
public class Menus
{

    Stage currentStage;
    Player currentPlayer;

    /**
     *
     */
    public Menus()
    {
        SaveLoad.getSaveList();
    }

    /**
     * Initializes the Menu
     */
    public void initializeMenu()
    {
        boolean exit = false;
        while (!exit)
        {
            String[] Menu =
            {
                "===============\n   Game Menu   \n===============\n",
                "New Game",
                "Load Game",
                "Tutorial",
                "Exit",
                "==============="
            };
            
            switch (UtilityMethods.setChoices(Menu))
            {
                case 1:
                    UtilityMethods.clearScreen();
                    newGame();
                    break;

                case 2:
                    UtilityMethods.clearScreen();
                    exit = true;
                    break;

                case 3:
                    UtilityMethods.clearScreen();
                    exit = true;
                    break;
                    
                case 4:
                    UtilityMethods.clearScreen();
                    System.out.println("Exiting the Game...");
                    exit = false;
                    System.exit(0); 
                    break;
                
                default:
                    exit = false;
                    break;
            }
        }

    }

    /**
     *
     * @return
     */
    public Player newGame()
    {
        this.currentPlayer = new Player("Placeholder");
        // Default stage for the player.
        this.currentStage = new Stage_1();
        this.currentPlayer.setCurrentStageLevel(this.currentStage);

        return this.currentPlayer;
    }

    /**
     *
     * @return
     */
    /**
     * public Player loadCharacterPart() { Scanner loadReader = new
     * Scanner(System.in); UtilityMethods.clearScreen();
     *
     * System.out.println("==============="); System.out.println(" Save List ");
     * System.out.println("==============="); System.out.println("[1]" +
     * SaveLoad.getSaveList().get(0)); System.out.println("[2]" +
     * SaveLoad.getSaveList().get(1)); System.out.println("[3]" +
     * SaveLoad.getSaveList().get(2)); System.out.println("[4]Back");
     * System.out.println("===============");
     *
     * this.currentPlayer = SaveLoad.loadCharacter(loadReader.nextInt());
     * this.currentStage =
     * currentStage.getStage(this.currentPlayer.getCurrentStageLevel());
     *
     * return this.currentPlayer; }
     *
     */
}
