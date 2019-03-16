/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Items;

/**
 *
 * @author lyleb
 */
public class Blindfold extends Item
{

    public boolean worn;

    public Blindfold()
    {
        super("Blindfold");
        this.worn = false;
    }

    @Override
    public void useItem()
    {
        if (this.worn == false)
        {
            this.worn = true;
            System.out.println("You wear the blindfold.");
        }
        else
        {
            removeBlindfold();
        }

    }

    public void removeBlindfold()
    {
        System.out.println("You remove the blindfold.");
        this.worn = false;
    }
}