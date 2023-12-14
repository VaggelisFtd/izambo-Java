package enums;

import java.util.Random;

/**
 * This enum holds the list of possible values for the masterpiece movement.
 *
 * @author V.Fotiadis
 */
public enum Movement {
  impressionism,
  expressionism,
  naturalism;

  /**
   * Generates a random value of all the possible {@link Movement} enum values.
   *
   * @return a random {@link Movement} enum value.
   */
  public static Movement random() {
    Movement[] allValues = Movement.values();
    int index = new Random().nextInt(allValues.length);
    return allValues[index];
  }

  /**
   * Converts the input {@code s} string to the corresponding {@link Movement} enum value.
   * If the input string does not belong into the list of possible values it will return null.
   *
   * @param s the input string to convert into an enum value.
   * @return the corresponding {@link Movement} enum value or null
   */
  public static Movement fromString(String s) {
    for (Movement movement : Movement.values()) {
      if (movement.name().equals(s)) {
        return movement;
      }
    }
    return null;
  }

}
