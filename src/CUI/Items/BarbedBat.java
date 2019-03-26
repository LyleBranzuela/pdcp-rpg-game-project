/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Items;

import CUI.Entity_Package.Enemy;
import CUI.Entity_Package.HiddenMonster;
import CUI.Entity_Package.Monster;

/**
 * Item subclass for the Barbed Bat Weapon.
 *
 * @author lyleb and khoap
 */
public class BarbedBat extends Item implements Weapon
{
<<<<<<< HEAD
    int batDmg = 1;
    int batSeq = 1;
=======

    private final int weaponDamage = 0;

>>>>>>> 610054f11bb73899e9d7c2a74b04828ea0ab60b1
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
     * Attack an entity with a barbed bat.
     *
     * @param enemy what enemy is getting attacked.
     * @return the damage made.
     */
    @Override
    public int attackEnemy(Enemy enemy)
    {
<<<<<<< HEAD
        return batDmg; // Returns damage of the bat for use in damage calculation.
=======
        if (enemy instanceof Monster)
        {
            return 0;
        }
        else if (enemy instanceof HiddenMonster)
        {
            return 0;
        }
        else
        {
            return 0;
        }
>>>>>>> 610054f11bb73899e9d7c2a74b04828ea0ab60b1
    }

    /**
     * Parry the attack of the enemy monster with a barbed bat.
     *
     * @return the damage taken.
     */
    @Override
    public int parrySeq()
    {
<<<<<<< HEAD
        return batSeq; //Returns int to adjust parry difficulty
    }
    
    @Override
    public String printDescription() 
    {
        return "A light wooden barbed bat. Has plenty of maneuverability but lacks damage.";
=======
        return 0;
>>>>>>> 610054f11bb73899e9d7c2a74b04828ea0ab60b1
    }

}
