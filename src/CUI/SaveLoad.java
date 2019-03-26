/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI;

import CUI.Entity_Package.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author lyleb and khoap
 */
public class SaveLoad
{

    private static ArrayList<Player> characterSaveList = new ArrayList<>(3);
    private static File f = new File("SaveFiles.txt");

    /**
     * Saves the current character selected.
     *
     * @param character what character is getting saved.
     * @param index which index to save in the list.
     * @throws java.io.IOException
     */
    public static void saveCharacter(int index, Player character) throws IOException
    {
        // Replace the character file into the save file
        characterSaveList.set(index, character);
        // Put Character Save List into the Save File
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeInt(characterSaveList.size());
        for (Player player : characterSaveList)
        {
            oos.writeObject(player);
        }
        oos.flush();
        oos.close();
    }

    /**
     * Loads a character from the save list.
     *
     * @param index which character to load in the list.
     * @return the character selected from the save list.
     */
    public static Player loadCharacter(int index)
    {
        return characterSaveList.get(index);
    }

    /**
     * Returns the list of the save list of the program.
     *
     * @throws java.io.FileNotFoundException when a file is not found.
     * @throws java.lang.ClassNotFoundException when a class is not found.
     */
    public static void initializeSaveList() throws IOException, ClassNotFoundException
    {
        // Load the Save List from the SaveFile to characterSaveList ArrayList
        ArrayList<Player> list = new ArrayList();
        Player tempPlayer = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        int size = ois.readInt();
        for (int counter = 0; counter < size; counter++)
        {
            tempPlayer = (Player) ois.readObject();
            list.add(tempPlayer);
        }
        ois.close();
            
        characterSaveList = list;
    }
    
    /**
     * Turns the save list into a string for printing.
     * 
     * @return the string version of the save list.
     */
    public static String[] getSaveList() 
    {
        // Retrieving all Save Files
        String[] saveList = new String[3];
        for (int counter = 0; counter < 3; counter++)
        {
            if(SaveLoad.loadCharacter(counter) != null)
            {
                saveList[counter] = loadCharacter(counter).getName();
            }
            else
            {
                saveList[counter] = "Empty";
            }
        }
        return saveList;
    }
    
    /**
     * Reset The Save File.
     * @throws java.io.IOException if there's an error in the File IO.
     */
    public static void resetSaveFile() throws IOException 
    {
        System.out.println("[Resetting Saves...]");
        characterSaveList.removeAll(characterSaveList);
        characterSaveList.add(null);
        characterSaveList.add(null);
        characterSaveList.add(null);
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeInt(characterSaveList.size());
        for (Player player : characterSaveList)
        {
            oos.writeObject(player);
        }
        oos.flush();
        oos.close();
    }
}
