package classes;

import enums.Condition;
import enums.Material;
import enums.Movement;

/**
 * This class is a masterpiece of the type sculpture.
 * Holds all the information of the parent class masterpiece and additionally
 * contains the info about the volume of the sculpture and its material.
 * The value of its fields (volume, material) will not be changed after the initialization.
 *
 * @author V.Fotiadis
 */
public class Sculpture extends Masterpiece {

  private final int volume;
  private final Material material;

  public Sculpture(int index,
                   String creator,
                   int year,
                   Condition condition,
                   Movement movement,
                   int volume,
                   Material material) {
    super(index, creator, year, condition, movement);
    this.volume = volume;
    this.material = material;
  }

  /**
   * Provides the info of the current sculpture in order to be printed.
   * Will use the base method in order to print the masterpiece info
   * and additionally will print the current sculpture volume and material.
   *
   * @return a string representing the log info of the current sculpture
   */
  @Override
  public String getInfo() {
    return super.getInfo() + ", volume=" + volume + ", material=" + material;
  }

  /**
   * This method checks if the current sculpture matches the input criteria of {@code inMovement} and {@code inCondition}
   * in order to be included into the final list of the printable masterpieces.
   * If the criteria {@code inCondition} has not been provided it will be considered to be excellent.
   * If the input criteria {@code inCondition} is good the method will not return true if the current sculpture condition is excellent.
   *
   * @param inMovement  the input movement criteria to match the current masterpiece movement
   * @param inCondition the input condition criteria to match the current masterpiece condition
   * @return {@code true} if the input criteria matches the current sculpture field values.
   */
  public boolean evaluate(Movement inMovement,
                          Condition inCondition) {
    // checks if the input criteria movement matches the current sculpture movement
    if (this.movement != inMovement) {
      return false; // input criteria movement does not match with the current sculpture movement so return false
    }
    //an den dinetai h katastash,thewreitai san excellent
    if (inCondition == null) {
      inCondition = Condition.excellent;
    }
    // returns true only if the condition matches exactly 
    return this.condition == inCondition;
  }
}
