/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Items;

/**
 * Item subclass for the Daggers Weapon.
 * @author lyleb and khoap
 */
public class Daggers extends Item implements Weapon
{
    int dagDmg = 2;
    int dagSeq = 2;
    /**
     * Constructor for the Daggers Weapon Item.
     */
    public Daggers()
    {
        super("Dual Daggers");
    }

    /**
     * 
     */
    @Override
    public void useItem()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public int attackEntity()
    {
        return dagDmg; //Returns damage of the dagger for use in damage calculation
    }

    /**
     * 
     * @return 
     */
    @Override
    public int parrySeq()
    {
        return dagSeq; //Returns int to adjust parry difficulty
    }
    
    @Override
    public String printDescription() 
    {
        return "A deadly pair of kukris. Medium damage and maneuverability.";
    }

}
