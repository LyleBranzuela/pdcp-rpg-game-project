/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Entity_Package;

/**
 *
 * @author lyleb and khoap
 */
public class HiddenMonster extends Entity implements Enemy
{
    public HiddenMonster(String name, int health)
    {
        super(name, health);
    }

    @Override
    public void attackPlayer(Player player)
    {
        player.setHealth(health);
    }

    @Override
    public void attackedByPlayer(int damage)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
