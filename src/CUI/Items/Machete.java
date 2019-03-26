/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Items;

import CUI.Entity_Package.Monster;

/**
 * Item subclass for the Machete Weapon.
 * @author lyleb and khoap
 */
public class Machete extends Item implements Weapon
{
    int machDmg = 3;
    int machSeq = 3;
    public Machete()
    {
        super("Machete");
    }

    @Override
    public void useItem()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int attackEntity()
    {
        return machDmg; //Returns machete damage for damage calculation
    }

    @Override
    public int parrySeq()
    {
        return machSeq; //Returns int to adjust parry difficulty
    }

    @Override
    public String printDescription() {
        return "A hard-hitting weapon but lacks maneuverability due to its size and weight.";
    }

}
