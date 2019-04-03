/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI;

import CUI.Entity_Package.Player;

/**
 * Game Over Screen that can be reused through multiple classes.
 *
 * @author lyleb and khoap
 */
public class GameOverScreen
{

    public static String deathMessage;

    /**
     * Used if there's no death message sent, which uses the previous death
     * message.
     *
     * For the save menu as it doesn't have its own death message, but rely on the previous one.
     *
     * @param player player to be sent to the overloaded print game over screen.
     */
    public static void printGameOverScreen(Player player)
    {
        printGameOverScreen(player, deathMessage);
    }

    /**
     * Prints the Game Over Screen on the CUI.
     *
     * @param player player object the user is currently playing as.
     * @param deathMessage death message of the specific stage.
     */
    public static void printGameOverScreen(Player player, String deathMessage)
    {
        boolean exit = false;
        Menus menu = new Menus();
        GameOverScreen.deathMessage = deathMessage;
        String border = "";
        for (int counter = 0; counter < deathMessage.length(); counter++)
        {
            border = border.concat("=");
        }

        String[] GameOver =
        {
            border + "\n" + deathMessage + "\n" + border + "\n",
            "Retry Stage",
            "Save Game",
            "Main Menu",
            "Exit",
            border
        };

        while (!exit)
        {
            switch (UtilityMethods.setChoices(GameOver))
            {
                // Retry Stage
                case 1:
                    System.out.println(border);
                    System.out.println("[Retrying Stage...]");
                    player.getCurrentStage().initiateStage(player);
                    exit = true;
                    break;

                // Save Game
                case 2:
                    System.out.println();
                    menu.saveCharacterMenu(player);
                    break;

                // Main Menu
                case 3:
                    System.out.println();
                    exit = true;
                    menu.initializeMenu();
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
}
