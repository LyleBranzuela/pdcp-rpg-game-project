/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CUI.Stages;

/**
 * Abstract parent class for all the stages.
 * @author lyleb and khoap
 */
public abstract class Stage
{

    protected int stageLevel;

    /**
     * 
     * 
     * @param stageLevel 
     */
    public Stage(int stageLevel)
    {
        this.stageLevel = stageLevel;
    }

    /**
     * Returns the stage level of the stage.
     * 
     * @return the stage level of the current stage.
     */
    public int getStageLevel()
    {
        return stageLevel;
    }

    /**
     * Abstract function to be filled with the stage rooms.
     */
    abstract public void setRoom();
}
