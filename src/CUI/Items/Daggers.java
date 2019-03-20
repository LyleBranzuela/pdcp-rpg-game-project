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
    /**
     * Constructor for the Daggers Weapon Item.
     */
    public Daggers()
    {
        super("Daggers");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public int parryAttack()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
