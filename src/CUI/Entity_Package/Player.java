/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Entity_Package;

import CUI.Items.*;
import CUI.Stages.*;
import java.util.ArrayList;

/**
 * Class for the main character of the game.
 *
 * @author lyleb and khoap
 */
public class Player extends Entity
{

    public ArrayList<Item> itemsHeld  = new ArrayList();
    public int stageLevel;
    public Stage playerStage;

    /**
     * Override Constructor for the game player.
     *
     * @param name name of the player chosen by the user.
     */
    public Player(String name)
    {
        super(name, 1);
        this.playerStage = new Stage_1();
        this.stageLevel = 1;
    }

    /**
     * Picks up the selected item from the parameter.
     *
     * @param item item to be picked up.
     */
    public void pickupItem(Item item)
    {
        System.out.println("You picked up " + item.getName());
        this.itemsHeld.add(item);
    }
    
    /**
     * Uses the specified item in the inventory.
     *
     * @param index what item from the list.
     */
    public void useItem(int index)
    {
        this.itemsHeld.get(index).useItem();
        this.itemsHeld.remove(index);
        this.itemsHeld.trimToSize();
    }

    /**
     * Opens the character's inventory if there's something in.
     *
     * @return gives back the inventory.
     */
    public ArrayList<Item> openCharacterInventory()
    {
        if (this.itemsHeld.isEmpty())
        {
            System.out.println("Your inventory is empty.");
            return null;
        }
        else
        {
            System.out.println("1) Yeet");
            return this.itemsHeld;
        }
    }

    /**
     * Sets the stage level the character is in.
     *
     * @param stage
     */
    public void setCurrentStageLevel(Stage stage)
    {
        this.stageLevel = stage.getStageLevel();
        this.playerStage = stage;
    }

    /**
     * Returns the current stage of the player.
     *
     * @return stage of the player object.
     */
    public Stage getCurrentStage()
    {
        return this.playerStage;
    }
}
