package classes;

import enums.Condition;
import enums.Movement;

/**
 * This class is an abstract class to be the base of all classes that will represent all kind of masterpieces
 * (paintings,sculptures and any other type of masterpieces).
 * Every implementing class will have a condition and a movement and needs to implement the evaluate method.
 * The value of the field movement will be set upon the initialization and never change (final) while the condition might change.
 *
 * @author V.Fotiadis
 */
public abstract class Masterpiece extends Artifact {
  protected Condition condition;
  protected final Movement movement;

  protected Masterpiece(int index,
                        String creator,
                        int year,
                        Condition condition,
                        Movement movement) {
    super(index, creator, year);
    this.condition = condition;
    this.movement = movement;
  }

  /**
   * Provides the info of the current masterpiece in order to be printed.
   * Will use the base method in order to print the artifact info
   * and additionally will print the current masterpiece condition and movement
   *
   * @return a string representing the log info of the current masterpiece
   */
  @Override
  public String getInfo() {
    return super.getInfo() + ", condition=" + condition + ", movement=" + movement;
  }

  /**
   * The condition of the masterpiece can be changed in time so we provide this setter to do so.
   *
   * @param condition the new value to set as the condition of the current masterpiece.
   */
  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  /**
   * This method checks if the current masterpiece matches the input criteria of {@code inMovement} and {@code inCondition}
   * in order to be included into the final list of the printable masterpieces.
   * The implementing class should provide its own business logic to decide whether the match is successful.
   *
   * @param inMovement  the input movement criteria to match the current masterpiece movement
   * @param inCondition the input condition criteria to match the current masterpiece condition
   * @return {@code true} if the input criteria matches the current masterpiece field values.
   */
  public abstract boolean evaluate(Movement inMovement,
                                   Condition inCondition);
}

