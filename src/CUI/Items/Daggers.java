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
 * Item subclass for the Daggers Weapon.
 * @author lyleb and khoap
 */
public class Daggers extends Item implements Weapon
{
<<<<<<< HEAD
    int dagDmg = 2;
    int dagSeq = 2;
=======
    private final int weaponDamage = 0;
    
>>>>>>> 610054f11bb73899e9d7c2a74b04828ea0ab60b1
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
     * Attack an entity with two daggers.
     * 
     * @param enemy what enemy is getting attacked. 
     * @return the damage made.
     */
    @Override
    public int attackEnemy(Enemy enemy)
    {
<<<<<<< HEAD
        return dagDmg; //Returns damage of the dagger for use in damage calculation
=======
         if (enemy instanceof Monster)
        {
            return 0;
        }
        else if (enemy instanceof HiddenMonster)
        {
            return 0;
        }
        else {
            return 0;
        }
>>>>>>> 610054f11bb73899e9d7c2a74b04828ea0ab60b1
    }
    
    /**
     * Parry the attack of the enemy monster with two daggers.
     * 
     * @return the damage taken.
     */
    @Override
    public int parrySeq()
    {
<<<<<<< HEAD
        return dagSeq; //Returns int to adjust parry difficulty
    }
    
    @Override
    public String printDescription() 
    {
        return "A deadly pair of kukris. Medium damage and maneuverability.";
=======
        return 0;
>>>>>>> 610054f11bb73899e9d7c2a74b04828ea0ab60b1
    }

}
