package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactInfoTest {

  private ContactInfo testContact;
  private Name myName;
  private Name emergencyName;
  private String address = "123 Seattle St";
  private String phone = "555-1234";
  private String email = "jane@doe.com";

  @BeforeEach
  void setUp() {
    myName = new Name("Jane", "Doe");
    emergencyName = new Name("John", "Doe");

    testContact = new ContactInfo(
        myName,
        address,
        phone,
        email,
        emergencyName
    );
  }

  @Test
  void getName() {
    assertEquals(myName, testContact.getName());
  }

  @Test
  void getAddress() {
    assertEquals(address, testContact.getAddress());
  }

  @Test
  void getPhoneNumber() {
    assertEquals(phone, testContact.getPhoneNumber());
  }

  @Test
  void getEmail() {
    assertEquals(email, testContact.getEmail());
  }

  @Test
  void getEmergencyContact() {
    assertEquals(emergencyName, testContact.getEmergencyContact());
  }
}