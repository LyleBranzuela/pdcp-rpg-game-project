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
    

}
