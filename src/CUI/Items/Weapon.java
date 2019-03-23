/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Items;

import CUI.Entity_Package.Enemy;

/**
 * An interface for items that are weapons.
 * @author lyleb and khoap
 */
public interface Weapon
{
    public int attackEnemy(Enemy enemy);
    public int parryAttack();
}
