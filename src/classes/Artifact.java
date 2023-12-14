package classes;

/**
 * This class is the base class that holds the info of a particular artifact.
 * The class will be immutable (with final fields) since its fields will not be changed after the initialization.
 *
 * @author V.Fotiadis
 */
public class Artifact {
  private final int index;
  private final String creator;
  private final int year;

  public Artifact(int index,
                  String creator,
                  int year) {
    System.out.println("Creating an instance of ("+getClass().getSimpleName()+")....");
    this.index = index;
    this.creator = creator;
    this.year = year;
  }

  /**
   * Returns the index of the current artifact.
   *
   * @return the value of the index field
   */
  public int getIndex() {
    return index;
  }

  /**
   * Provides the info of the current artifact in order to be printed.
   *
   * @return a string representing the log info of the current artifact
   */
  public String getInfo() {
    return creator + " " + year;
  }

}

