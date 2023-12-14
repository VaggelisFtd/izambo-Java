package enums;

import java.util.Random;

/**
 * This enum holds the list of possible values for the painting technique.
 *
 * @author V.Fotiadis
 */
public enum Technique {
  oil, aquarelle, tempera;

  /**
   * Generates a random value of all the possible {@link Technique} enum values.
   *
   * @return a random {@link Technique} enum value.
   */
  public static Technique random() {
    Technique[] allValues = Technique.values();
    int index = new Random().nextInt(allValues.length);
    return allValues[index];
  }
}
