package problem1;

/**
 * The type Contact info.
 */
public class ContactInfo {
  private final Name name;
  private final String address;
  private final String phoneNumber;
  private final String email;
  private final Name emergencyContact;

  /**
   * Instantiates a new Contact info.
   *
   * @param name             the name as String
   * @param address          the address as String
   * @param phoneNumber      the phone number as String
   * @param email            the email as String
   * @param emergencyContact the emergency contact as Name
   */
  public ContactInfo(final Name name, final String address, final String phoneNumber, final String email,
      final Name emergencyContact) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.emergencyContact = emergencyContact;
  }

  /**
   * @return the name as String
   */
  public Name getName() {
    return name;
  }

  /**
   * @return the address as String
   */
  public String getAddress() {
    return address;
  }

  /**
   * @return the email as String
   */
  public String getEmail() {
    return email;
  }

  /**
   * @return the phone number as String
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @return the emergency contact as String
   */
  public Name getEmergencyContact() {
    return emergencyContact;
  }
}
