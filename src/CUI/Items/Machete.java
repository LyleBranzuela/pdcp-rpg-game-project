/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Items;

<<<<<<< HEAD
=======
import CUI.Entity_Package.Enemy;
import CUI.Entity_Package.HiddenMonster;
>>>>>>> 610054f11bb73899e9d7c2a74b04828ea0ab60b1
import CUI.Entity_Package.Monster;

/**
 * Item subclass for the Machete Weapon.
 *
 * @author lyleb and khoap
 */
public class Machete extends Item implements Weapon
{
<<<<<<< HEAD
    int machDmg = 3;
    int machSeq = 3;
=======

    private final int weaponDamage = 0;

>>>>>>> 610054f11bb73899e9d7c2a74b04828ea0ab60b1
    public Machete()
    {
        super("Machete");
    }

    @Override
    public void useItem()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Attack an entity with a machete.
     *
     * @param enemy what enemy is getting attacked.
     * @return the damage made.
     */
    @Override
    public int attackEnemy(Enemy enemy)
    {
<<<<<<< HEAD
        return machDmg; //Returns machete damage for damage calculation
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
     * Parry the attack of the enemy monster with a machete.
     *
     * @return the damage taken.
     */
    @Override
    public int parrySeq()
    {
<<<<<<< HEAD
        return machSeq; //Returns int to adjust parry difficulty
    }

    @Override
    public String printDescription() {
        return "A hard-hitting weapon but lacks maneuverability due to its size and weight.";
=======
        return 0;
>>>>>>> 610054f11bb73899e9d7c2a74b04828ea0ab60b1
    }
}
