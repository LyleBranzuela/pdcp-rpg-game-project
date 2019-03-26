/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Items;

/**
 * Item subclass for the Barbed Bat Weapon.
 * @author lyleb and khoap
 */
public class BarbedBat extends Item implements Weapon
{
    int batDmg = 1;
    int batSeq = 1;
    /**
     * Constructor for the Barbed Bat Weapon Item.
     */
    public BarbedBat()
    {
        super("Barbed Bat");
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
        return batDmg; // Returns damage of the bat for use in damage calculation.
    }

    /**
     *
     * @return
     */
    @Override
    public int parrySeq()
    {
        return batSeq; //Returns int to adjust parry difficulty
    }
    
    @Override
    public String printDescription() 
    {
        return "A light wooden barbed bat. Has plenty of maneuverability but lacks damage.";
    }

}
