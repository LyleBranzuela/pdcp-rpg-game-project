/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI;

import CUI.Entity_Package.Player;
import java.util.ArrayList;

/**
 * 
 * @author lyleb and khoap
 */
public class SaveLoad
{

    private static ArrayList<Player> characterSaveList;

    /**
     * Saves the current character selected.
     *
     * @param character what character is getting saved.
     * @param index which index to save in the list.
     */
    public static void saveCharacter(Player character, int index)
    {

    }

    /**
     * Loads a character from the save list.
     *
     * @param index which character to load in the list.
     * @return the character selected from the save list.
     */
    public static Player loadCharacter(int index)
    {
        Player loadedCharacter = null;
        
        return loadedCharacter;
    }

    /**
     * Returns the list of the save list of the program.
     *
     * @return the save list.
     */
    public static ArrayList<Player> getSaveList()
    {
        
        return null;
    }
}
