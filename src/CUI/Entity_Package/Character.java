/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Entity_Package;

import CUI.Items.Item;
import CUI.Stages.Stage;
import java.util.ArrayList;

/**
 * Class for the main character of the game.
 * @author lyleb and khoap
 */
public class Character extends Entity
{
    public ArrayList<Item> itemsHeld;
    public int stageLevel;

    /**
     * Constructor for the game character.
     * 
     * @param name name of the character chosen by the user.
     */
    public Character(String name)
    {
        super(name, 10);
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
        this.itemsHeld.get(index).itemUsage();
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
    public void setStageLevel(Stage stage) {
        this.stageLevel = stage.getStageLevel();
    }
}
