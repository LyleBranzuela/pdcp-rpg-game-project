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
    private static File f;

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
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void initializeSaveList() throws IOException, ClassNotFoundException
    {
        // Initialize the Attributes
        f = new File("SaveFile");

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
}
