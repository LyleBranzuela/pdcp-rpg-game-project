/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Stages;

import CUI.Entity_Package.Player;
import java.io.Serializable;

/**
 * Abstract parent class for all the stages.
 *
 * @author lyleb and khoap
 */
public abstract class Stage implements Serializable
{
    protected int stageLevel;

    /**
     * Returns the stage level of the stage.
     *
     * @return the stage level of the current stage.
     */
    public int getStageLevel()
    {
        return this.stageLevel;
    }

    /**
     * Abstract function to be filled with to initiate the stage rooms.
     * 
     * @param player
     */
    abstract public void initiateStage(Player player);

    /**
     * Returns the current stage the game is in.
     *
     * @param currentStageLevel
     * @return
     */
    public Stage getStage(int currentStageLevel)
    {
        // Default Stage
        this.stageLevel = currentStageLevel;
        Stage tempStage = new Stage_1();
        
        switch (this.stageLevel)
        {
            case 1:
                tempStage = new Stage_1();
                break;

            case 2:
                tempStage = new Stage_2();
                break;

            case 3:
                tempStage = new Stage_3();
                break;

            case 4:
                tempStage = new Stage_4();
                break;

            default:
                System.out.println("Error finding the stage.");
                break;
        }
        
        return tempStage;
    }
}
