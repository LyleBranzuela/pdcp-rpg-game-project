/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Items;

/**
 * An interface for items that are combinable.
 * @author lyleb and khoap
 */
public interface Combinables
{
    /**
     * 
     * @param item
     * @param otherItem 
     */
    public void combineItems(Item item, Item otherItem);
}
