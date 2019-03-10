/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Items;

/**
 * Abstract parent class for the Items.
 * @author lyleb and khoap
 */
public abstract class Item
{
    public String name;
    
    /**
     * Constructor for the abstract Item class.
     * 
     * @param name name of the item.
     */
    public Item (String name) {
        this.name = name;
    }
    
    /**
     * Abstract class for children classes, to decide what the item does.
     */
    abstract public void itemUsage();
    
    /**
     * Returns the name of the item.
     * 
     * @return the item name.
     */
    public String getName() {
        return this.name;
    }
}
