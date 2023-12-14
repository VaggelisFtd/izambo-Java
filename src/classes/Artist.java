package classes;

/**
 * This class holds the info of the masterpiece creator artist.
 * Will be used to help the random generation of the masterpieces.
 * The class will be immutable (with final fields) since its fields will not be changed after the initialization.
 *
 * @author V.Fotiadis
 */
public class Artist {

  private final String name;
  private final int birthYear;
  private final int deathYear;

  public Artist(String name,
                int birthYear,
                int deathYear) {
    this.name = name;
    this.birthYear = birthYear;
    this.deathYear = deathYear;
  }

  // ########## GETTERS OF THE CLASS FIELDS ########################
  public String getName() {
    return name;
  }

  public int getBirthYear() {
    return birthYear;
  }

  public int getDeathYear() {
    return deathYear;
  }

}
