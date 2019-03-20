/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI;

import CUI.Entity_Package.Player;
import CUI.Stages.Stage;
import CUI.Stages.Stage_1;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lyleb and khoap
 */
public class Menus
{

    Player player;

    /**
     * Constructor of the Menu, creates the player object.
     */
    public Menus()
    {
        this.player = new Player("John");
    }

    /**
     * Initializes the Menu.
     */
    public void initializeMenu()
    {
        try
        {
            SaveLoad.initializeSaveList();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class" + e + "not found");
        }
        catch (IOException e)
        {
            System.out.println("Error reading from file " + e);
        }

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
                // New Game
                case 1:
                    newGame();
                    exit = true;
                    break;

                // Load Game
                case 2:
                    loadCharacterMenu();
                    exit = true;
                    break;

                // Tutorial
                case 3:
                    exit = false;
                    break;

                // Exit
                case 4:
                    System.out.println("Exiting the Game...");
                    exit = true;
                    System.exit(0);
                    break;

                default:
                    exit = false;
                    break;
            }
        }

    }

    /**
     * Creates a new player in a new game.
     */
    private void newGame()
    {
        Scanner scan = new Scanner(System.in);
        String name;
        System.out.println("============================================================");
        System.out.print("Enter Your Name (Maximum of 10 Characters): ");
        name = scan.nextLine();
        while (name.length() > 10 || name.length() < 1)
        {
            System.out.println();
            System.out.println("============================================================");
            System.out.println("[Please enter a name at max of 10 or min of 1 character/s.]");
            System.out.println("============================================================");
            System.out.print("Enter Your Name: ");
            name = scan.nextLine();
        }

        // Create a new Object of the Player
        this.player = new Player(name);
        // Default stage for a new player.
        this.player.setCurrentStageLevel(new Stage_1());
        System.out.println("============================================================");
        this.player.getCurrentStage().initiateStage(this.player);
    }

    /**
     * Loads the current character player.
     */
    public void loadCharacterMenu()
    {
        Boolean breakLoop = false;
        // Placeholder Stage
        Stage stage = new Stage_1();
        // Get Save List 
        String[] saveList = SaveLoad.getSaveList();

        while (!breakLoop)
        {
            String[] loadMenu =
            {
                "\n===============\n   Save List   \n===============\n",
                saveList[0],
                saveList[1],
                saveList[2],
                "Back",
                "==============="
            };

            int choice = UtilityMethods.setChoices(loadMenu);
            switch (choice)
            {
                // Load 1st Save File
                case 1:
                // Load 2nd Save File
                case 2:
                // Load 3rd Save File
                case 3:
                    if (SaveLoad.loadCharacter(choice - 1) == null)
                    {
                        System.out.println("[Please choose a non-empty save.]");
                        breakLoop = false;
                    }
                    else
                    {
                        this.player = SaveLoad.loadCharacter(choice - 1);
                        this.player.getCurrentStage().initiateStage(this.player);
                        System.out.println("============================================================");
                        System.out.println("Initiating Stage " + stage.getStageLevel() + "...");
                        System.out.println("============================================================");
                        breakLoop = true;
                    }
                    break;

                // Back
                case 4:
                    System.out.println();
                    breakLoop = true;
                    initializeMenu();
                    break;

                default:
                    breakLoop = false;
                    break;
            }
        }
    }

    /**
     * Saves the current character player. 
     * Only shows up on the game over screen.
     *
     * @param player which player to save.
     */
    public void saveCharacterMenu(Player player)
    {
        Boolean breakLoop = false;

        // Retrieving all Save Files
        String[] saveList = SaveLoad.getSaveList();

        while (!breakLoop)
        {
            String[] saveMenu =
            {
                "\n===============\n   Save List   \n===============\n",
                saveList[0],
                saveList[1],
                saveList[2],
                "Back",
                "==============="
            };

            int choice = UtilityMethods.setChoices(saveMenu);
            switch (choice)
            {
                // Save at the 1st Save File
                case 1:
                // Save at the 2nd Save File
                case 2:
                // Save at the 3rd Save File
                case 3:
                    try
                    {
                        SaveLoad.saveCharacter(choice - 1, player);
                        System.out.println("============================================================");
                        System.out.println("Character " + player.getName() + " Saved!");
                        System.out.println("============================================================");
                        breakLoop = true;
                    }
                    catch (IOException e)
                    {
                        System.out.println("Error, at " + e);
                        breakLoop = false;
                    }
                    break;

                // Back
                case 4:
                    System.out.println();
                    GameOverScreen.printGameOverScreen(player);
                    breakLoop = true;
                    break;

                default:
                    breakLoop = false;
                    break;
            }
        }
    }

    /**
     * Tutorial Screen in the Menus.
     */
    private void tutorialScreen()
    {

    }
}
