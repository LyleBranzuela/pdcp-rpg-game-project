/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Entity_Package;

/**
 * 
 * @author lyleb
 */
public class Monster extends Entity implements Enemy
{
    public Monster(String name)
    {
        super(name, 3);
    }

    @Override
    public void attackPlayer(Player player)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attackedByPlayer(int damage)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
