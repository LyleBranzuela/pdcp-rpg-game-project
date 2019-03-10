/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Items;

/**
 * An interface for items that are consumable.
 * @author lyleb and khoap
 */
public interface Consumables
{
    public int setAmountOfUses();
    public int getAmountOfUses();
    public void interactItem();
}
