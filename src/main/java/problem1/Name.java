package problem1;

/**
 * The type Name.
 */
public class Name {
  private final String firstName;
  private final String lastName;

  /**
   * Instantiates a new Name.
   *
   * @param firstName the first name
   * @param lastName  the last name
   */
  public Name(final String firstName, final String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets first name as String
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets last name as String
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }
}
