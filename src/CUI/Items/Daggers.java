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
    private final int weaponDamage = 0;
    
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
     * Attack an entity with two daggers.
     * 
     * @param enemy what enemy is getting attacked. 
     * @return the damage made.
     */
    @Override
    public int attackEnemy(Enemy enemy)
    {
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
    }
    
    /**
     * Parry the attack of the enemy monster with two daggers.
     * 
     * @return the damage taken.
     */
    @Override
    public int parryAttack()
    {
        return 0;
    }

}
