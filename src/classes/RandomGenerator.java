package classes;

import java.util.Random;

import enums.Condition;
import enums.Material;
import enums.Movement;
import enums.Technique;

/**
 * <p>This class is a utility to generate an array of masterpieces.
 * Contains an array of artists for every type of masterpiece ( painting, sculpture ).
 * In a loop for the index I from 0 ... to the input N number the basic algorithm
 * for generating the masterpiece of the index I is as follows.
 *
 *  <ul>
 *  <li>Chose randomly the type of masterpiece (painting or sculpture)</li>
 *  <li>Chose randomly an {@code Artist} from the corresponding array of the artists</li>
 *  <li>Generates randomly the creation year from the artist info by choosing a random number between birth year + 20 and death year</li>
 *  <li>Generates randomly the masterpiece condition material and all enum values by using the corresponding class random() method</li>
 *  <li>Generates randomly the dimensions of the painting or the sculpture volume</li>
 * </ul>
 * </p>
 *
 * @author V.Fotiadis
 */
public class RandomGenerator {

  public static final Artist[] SCULPTURE_ARTISTS = {
      new Artist("Brunelleschi", 1377, 1446),
      new Artist("Ghiberti", 1378, 1455),
      new Artist("Nanni di Banco", 1384, 1421),
      new Artist("Donatello", 1386, 1466)
  };

  public static final Artist[] PAINTING_ARTISTS = {
      new Artist("Masolino da Panicale", 1383, 1447),
      new Artist("Fra Angelico", 1395, 1455),
      new Artist("Uccello", 1397, 1475),
      new Artist("Masaccio", 1401, 1428),
      new Artist("Filippo Lippi", 1406, 1469),
      new Artist("Piero della Francesca", 1412, 1492),
      new Artist("Andrea del Castagno", 1421, 1457),
      new Artist("Gentile Bellini", 1429, 1507),

      new Artist("Antonello da Messina", 1430, 1479),
      new Artist("Mantegna", 1431, 1506),
      new Artist("Verrocchio", 1435, 1488),
      new Artist("Botticelli", 1445, 1510),
      new Artist("Signorelli", 1445, 1523),
      new Artist("Perugino", 1446, 1524)
  };

  /**
   * Generates an array of masterpieces with the input {@code n} length.
   * It loops with an index from i to N and calls the method {@link #randomGenerateMasterpiece(int)}
   * to generate the element of the array for the index.
   *
   * @param n the input number of elements of the array to generate
   * @return the array of the randomly generated masterpieces
   */
  public static Masterpiece[] randomGenerate(int n) {
    Masterpiece[] masterPieces = new Masterpiece[n];
    for (int i = 0; i < n; i++) {
      masterPieces[i] = randomGenerateMasterpiece(i);
    }
    return masterPieces;
  }

  /**
   * Generates a masterpiece of random values to be placed into the index {@code index} of the final array.
   * It chooses randomly the type of the masterpiece to generate (painting or sculpture)
   * and calls respectively the method {@link #randomPainting(int)} or {@link #randomSculpture(int)}.
   *
   * @param index the index of the element of the array to create the masterpiece for
   * @return the generated masterpiece to put into the final array
   */
  private static Masterpiece randomGenerateMasterpiece(int index) {
    boolean isPainting = new Random().nextInt(100) % 2 == 1;
    if (isPainting) {
      return randomPainting(index);
    }
    return randomSculpture(index);
  }

  /**
   * Generates a painting of random values to be placed into the index {@code index} of the final array.
   * The methodology will be the following.
   * <ul>
   *  <li>Chose randomly an {@code Artist} from the {@code PAINTING_ARTISTS} array of the artists</li>
   *  <li>Generates randomly the creation year from the artist info by choosing a random number between birth year + 20 and death year</li>
   *  <li>Generates randomly the masterpiece condition material and all enum values by using the corresponding class random() method</li>
   *  <li>Generates randomly the dimensions of the painting</li>
   * </ul>
   *
   * @param index the index of the element of the array to create the masterpiece for
   * @return the generated masterpiece to put into the final array
   */
  private static Painting randomPainting(int index) {
    int artistIndex = new Random().nextInt(PAINTING_ARTISTS.length);
    Artist artist = PAINTING_ARTISTS[artistIndex];
    String creator = artist.getName();
    int year = randomInt(artist.getBirthYear() + 20, artist.getDeathYear());
    int length = randomInt(20, 120);
    int width = randomInt(20, 120);
    return new Painting(index, creator, year, Condition.random(), Movement.random(), length, width, Technique.random());
  }

  /**
   * Generates a sculpture of random values to be placed into the index {@code index} of the final array.
   * The methodology will be the following.
   * <ul>
   *  <li>Chose randomly an {@code Artist} from the {@code SCULPTURE_ARTISTS} array of the artists</li>
   *  <li>Generates randomly the creation year from the artist info by choosing a random number between birth year + 20 and death year</li>
   *  <li>Generates randomly the masterpiece condition material and all enum values by using the corresponding class random() method</li>
   *  <li>Generates randomly the sculpture volume</li>
   * </ul>
   *
   * @param index the index of the element of the array to create the masterpiece for
   * @return the generated masterpiece to put into the final array
   */
  private static Sculpture randomSculpture(int index) {
    int artistIndex = new Random().nextInt(SCULPTURE_ARTISTS.length);
    Artist artist = SCULPTURE_ARTISTS[artistIndex];
    String creator = artist.getName();
    int year = randomInt(artist.getBirthYear() + 20, artist.getDeathYear());
    int volume = randomInt(20, 120);
    return new Sculpture(index, creator, year, Condition.random(), Movement.random(), volume, Material.random());
  }

  /**
   * Generates a random number inside the input range of {@code min} inclusive and {@code max} exclusive.
   *
   * @param min the minimum value that the random value might have (inclusive)
   * @param max the maximum value that the random value might have (exclusive)
   * @return the randomly generated value
   */
  private static int randomInt(int min,
                               int max) {
    return (int) (Math.random() * (max - min + 1) + min);
  }
}

