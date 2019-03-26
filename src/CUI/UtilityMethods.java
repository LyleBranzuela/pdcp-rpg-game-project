/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author lyleb and khoap
 */
public class UtilityMethods
{

    /**
     * Clears the console screen.
     */
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int setChoices(String[] event)
    {
        Scanner reader = new Scanner(System.in);
        int selector = 0;
        boolean scanCheck = false;

        if (event.length > 6 || event.length < 6)
        {
            System.out.println("ERROR, EVENT PARAMETER IS WRONG. (No. of Events:" + event.length + ")");
        }
        System.out.print(event[0]);
        System.out.println("[1]" + event[1]);
        System.out.println("[2]" + event[2]);
        System.out.println("[3]" + event[3]);
        System.out.println("[4]" + event[4]);
        System.out.println(event[5]);
        System.out.print("Action: ");

        while (!scanCheck)
        {
            try
            {
                selector = reader.nextInt();
                switch (selector)
                {
                    case 1:
                        return 1;

                    case 2:
                        return 2;

                    case 3:
                        return 3;

                    case 4:
                        return 4;

                    default:
                        System.out.print("[Choose a choice ranging from 1-4!]\n\n");
                        scanCheck = true;
                        UtilityMethods.clearScreen();
                        return 0;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.print("[Please only input a number ranging 1-4!]\n\n");
                scanCheck = true;
            }
        }
        return 0;
    }

}
