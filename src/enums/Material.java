package enums;

import java.util.Random;

/**
 * This enum holds the list of possible values for the sculpture material.
 *
 * @author V.Fotiadis
 */
public enum Material {
  iron, stone, wood;

  /**
   * Generates a random value of all the possible {@link Material} enum values.
   *
   * @return a random {@link Material} enum value.
   */
  public static Material random() {
    Material[] allValues = Material.values();
    int index = new Random().nextInt(allValues.length);
    return allValues[index];
  }
}
