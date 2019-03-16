/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Entity_Package;

/**
 * Abstract class for the Entity.
 *
 * @author lyleb and khoap
 */
public abstract class Entity
{

    public String name;
    protected int health;
    protected int x_coord, y_coord;

    /**
     * Constructor for the entity's name and health.
     *
     * @param name takes the name of the entity.
     * @param health takes the health of the entity.
     */
    public Entity(String name, int health)
    {
        this.name = name;
        this.health = health;
    }

    /**
     * Abstract function to be fulfilled by the entity for GUI.
     */
    //abstract protected void characterMovement();

    /**
     * Sets the name of the entity.
     * 
     * @param name specified name sent.
     */
    public void getName(String name)
    {
        this.name = name;
    }
    
    /**
     * Returns the name of the entity.
     * 
     * @return the entity's name.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Returns the health of the entity.
     * 
     * @return the entity's health.
     */
    public int getHealth()
    {
        return this.health;
    }
    
     /**
     * Sets the health of the entity.
     * 
     * @param health how much health they set.
     */
    protected void setHealth(int health)
    {
        this.health = health;
    }
}
