package classes;

import enums.Condition;
import enums.Movement;

/**
 * This class is the entry point of the project execution.
 * Its main method will execute the following steps.
 * <ul>
 *  <li>It will generate an array of N masterpieces with random values.</li>
 *  <li>In a loop for every element of the generated array it will print the index, info and the result of the evaluate method</li>
 * </ul>
 *
 * @author V.Fotiadis
 */
public class MainClass {

  /**
   * The main method of the class. It takes 2 or 3 arguments.
   * The first argument needs to be a valid number N of the elements of the masterpiece array
   * The second argument needs to be a valid value of the movement criteria (any of impressionism,expressionism,naturalism).
   * The third argument (if provided) needs to be a valid value of the condition criteria (any of bad, good, excellent).
   * It will execute the following steps.
   * <ul>
   *  <li>It will generate an array of N masterpieces with random values.</li>
   *  <li>In a loop for every element of the generated array it will print the index, info and the result of the evaluate method</li>
   * </ul>
   *
   * @param args the main method arguments
   */
  public static void main(String[] args) {
    System.out.println("Start generating masterpieces...");
    // check the input arguments are at least 2
    if (args == null || args.length < 2) {
      System.out.println("The input is not valid!! At least 2 arguments are expected!!");
      return;
    }
    // the first argument must be a valid N number of array elements
    int n = 0;
    try {
      n = Integer.parseInt(args[0]);
      if (n <= 0 || n > 100) {
        System.out.println("The input number N [" + n + "] is not valid!! It should be between [1 and 100]!!");
        return;
      }
    } catch (NumberFormatException e) {
      System.out.println("The input argument [" + args[0] + "] is an invalid number!!");
      return;
    }
    // second argument needs to be a valid value of the movement criteria (any of impressionism,expressionism,naturalism)
    String inMovementS = args[1];
    Movement movement = Movement.fromString(inMovementS);
    if (movement == null) {
      System.out.println("The input second argument [" + inMovementS + "] is not valid!!"
          + " It should be one of [impressionism,expressionism,naturalism]");
      return;
    }
    String inConditionS = null;
    Condition condition = null;
    if (args.length > 2) {
      inConditionS = args[2];
      condition = Condition.fromString(inConditionS);
      if (condition == null) {
        System.out.println("The input third argument [" + inConditionS + "] is not valid!!"
            + " It should be one of [bad, good, excellent]");
        return;
      }
    }
    // print the input arguments
    System.out.println("The input arguments are n=" + n + " , inMovementS=" + inMovementS + " , inConditionS=" + inConditionS);
    // generate the array of the masterpieces
    Masterpiece[] masterPieces = RandomGenerator.randomGenerate(n);
    // print an empty line for separation of messages
    System.out.println();
    // call the auction method
    new MainClass().auction(masterPieces, movement, condition);
  }

  /**
   * The method for every element of the input {@code masterpieces} array it will do the following.
   * <ul>
   *  <li>Prints the masterpiece index by calling the objects method {@link Masterpiece#getIndex()}.</li>
   *  <li>Prints the element info by calling the objects method {@link Masterpiece#getInfo()}</li>
   *  <li>Prints the result of the execution of the objects method {@link Masterpiece#evaluate(Movement, Condition)}</li>
   * </ul>
   *
   * @param masterpieces the input array of the masterpieces to print the info of the elements.
   * @param inMovement   the input movement argument to be used into the evaluate method of every element
   * @param inCondition  the input condition argument to be used into the evaluate method of every element
   */
  public void auction(Masterpiece[] masterpieces,
                      Movement inMovement,
                      Condition inCondition) {
    for (Masterpiece masterpiece : masterpieces) {
      System.out.println(masterpiece.getIndex());
      System.out.println(masterpiece.getInfo());
      System.out.println("evaluate=" + masterpiece.evaluate(inMovement, inCondition));
      // print an empty line for separation of elements
      System.out.println();
    }
  }
}

