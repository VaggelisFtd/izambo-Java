package classes;

import enums.Condition;
import enums.Movement;
import enums.Technique;

/**
 * This class is a masterpiece of the type painting.
 * Holds all the information of the parent class masterpiece and additionally
 * contains the info about the dimensions of the painting and its technique.
 * The value of its fields (length, width, technique) will not be changed after the initialization.
 *
 * @author V.Fotiadis
 */
public class Painting extends Masterpiece {

    private final int length;
    private final int width;
    private final Technique technique;

    public Painting(int index,
                    String creator,
                    int year,
                    Condition condition,
                    Movement movement,
                    int length,
                    int width,
                    Technique technique) {
        super(index, creator, year, condition, movement);
        this.length = length;
        this.width = width;
        this.technique = technique;
    }

    /**
     * Provides the info of the current painting in order to be printed.
     * Will use the base method in order to print the masterpiece info
     * and additionally will print the current painting technique and surface.
     *
     * @return a string representing the log info of the current painting
     */
    @Override
    public String getInfo() {
        return super.getInfo() + ",technique= " + technique + ",surface= " + (length * width);
    }

    /**
     * This method checks if the current painting matches the input criteria of {@code inMovement} and {@code inCondition}
     * in order to be included into the final list of the printable masterpieces.
     * If the criteria {@code inCondition} has not been provided it will be considered to be good.
     * If the input criteria {@code inCondition} is excellent the method will return true if the current painting condition is good or excellent.
     *
     * @param inMovement  the input movement criteria to match the current masterpiece movement
     * @param inCondition the input condition criteria to match the current masterpiece condition
     * @return {@code true} if the input criteria matches the current painting field values.
     */
    @Override
    public boolean evaluate(Movement inMovement,
                            Condition inCondition) {
        // checks if the input criteria movement matches the current painting movement
        if (this.movement != inMovement) {
            return false;  // input criteria movement does not match with the current painting movement so return false
        }
        //otan den dinetai h katastash thewreitai san good
        if (inCondition == null) {
            inCondition = Condition.good;
        }
        // if the input criteria condition matches the current painting condition the methods returns true
        if (this.condition == inCondition) {
            return true;
        }
        //h katastash excellent einai accepted k sthn periptwsh pou dinetai good
        return inCondition == Condition.excellent && this.condition == Condition.good;
    }
}
