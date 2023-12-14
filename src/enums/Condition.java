package enums;

import java.util.Random;

/**
 * This enum holds the list of possible values for the masterpiece condition.
 *
 * @author V.Fotiadis
 */
public enum Condition {
  bad, good, excellent;

  /**
   * Generates a random value of all the possible {@link Condition} enum values.
   *
   * @return a random {@link Condition} enum value.
   */
  public static Condition random() {
    Condition[] allValues = Condition.values();
    int index = new Random().nextInt(allValues.length);
    return allValues[index];
  }

  /**
   * Converts the input {@code s} string to the corresponding {@link Condition} enum value.
   * If the input string does not belong into the list of possible values it will return null.
   *
   * @param s the input string to convert into an enum value.
   * @return the corresponding {@link Condition} enum value or null
   */
  public static Condition fromString(String s) {
    for (Condition condition : Condition.values()) {
      if (condition.name().equals(s)) {
        return condition;
      }
    }
    return null;
  }
}
