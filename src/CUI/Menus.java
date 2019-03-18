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
    Player player;

    /**
     * Constructor of the Menu, creates the player object, and takes the save list.
     */
    public Menus()
    {
        this.player = new Player("John");
        SaveLoad.getSaveList();
    }

    /**
     * Initializes the Menu.
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
                // New Game
                case 1:
                    UtilityMethods.clearScreen();
                    newGame();
                    exit = true;
                    break;

                // Load Game
                case 2:
                    UtilityMethods.clearScreen();
                    loadCharacterMenu();
                    exit = true;
                    break;

                // Tutorial
                case 3:
                    UtilityMethods.clearScreen();
                    exit = false;
                    break;

                // Exit
                case 4:
                    UtilityMethods.clearScreen();
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
        while (name.length() > 10)
        {
            System.out.println("Please enter a name at max of 10 characters.");
            System.out.println("============================================================");
            System.out.print("Enter Your Name (Maximum of 10 Characters): ");
            name = scan.nextLine();
        }

        // Create a new Object of the Player
        this.player = new Player(name);
        // Default stage for a new player.
        this.player.setCurrentStageLevel(new Stage_1());
        System.out.println("============================================================");
        System.out.println("Hello, " + this.player.getName() + "!");
        System.out.println("============================================================");
        this.player.getCurrentStage().initiateStage(this.player);
    }

    /**
     * Loads the current character player.
     */
    private void loadCharacterMenu()
    {
        Boolean back = false;
        // Placeholder Stage
        Stage stage = new Stage_1();

        // Retrieving all Save Files
        String[] saveList = new String[3];
        for (int counter = 0; counter < 3; counter++)
        {
            saveList[0] = SaveLoad.getSaveList().get(counter).toString();
        }

        while (!back)
        {
            String[] loadMenu =
            {
                "===============\n   Save List   \n===============\n",
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
                    UtilityMethods.clearScreen();
                    this.player = SaveLoad.getSaveList().get(choice - 1);
                    this.player.getCurrentStage().initiateStage(this.player);
                    System.out.println("Initiating Stage " + stage.getStageLevel() + "...");
                    back = false;
                    break;

                // Back
                case 4:
                    UtilityMethods.clearScreen();
                    initializeMenu();
                    back = true;
                    break;

                default:
                    back = false;
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
