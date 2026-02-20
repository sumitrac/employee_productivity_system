package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * Test Employee abstract class using a concrete subclass.
 */
class EmployeeTest {

  private BenefitEligibleEmployee testEmployee;
  private LocalDate date;
  private ContactInfo contact;
  private Name name;

  @BeforeEach
  void setUp() {
    date = LocalDate.of(2020, 1, 1);
    name = new Name("Jane", "Doe");
    Name emergencyName = new Name("John", "Doe");
    contact = new ContactInfo(name, "123 Seattle St", "555-1234", "jane@doe.com", emergencyName);

    // We use BenefitEligibleEmployee because we cannot instantiate Employee directly.
    testEmployee = new BenefitEligibleEmployee(
        "E123",
        date,
        50000.0,
        contact,
        EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.INTERMEDIATE_LEVEL,
        40.0,
        40.0,
        0.0
    );
  }

  @Test
  void getEmployeeID() {
    assertEquals("E123", testEmployee.getEmployeeID());
  }

  @Test
  void getEmploymentDate() {
    assertEquals(date, testEmployee.getEmploymentDate());
  }

  @Test
  void getLastYearEarning() {
    assertEquals(50000.0, testEmployee.getLastYearEarning(), 0.01);
  }

  @Test
  void getEducationLevel() {
    assertEquals(EducationLevel.BACHELORS_DEGREE, testEmployee.getEducationLevel());
  }

  @Test
  void getContactInfo() {
    assertEquals(contact, testEmployee.getContactInfo());
  }

  @Test
  void getEmploymentLevel() {
    assertEquals(EmploymentLevel.INTERMEDIATE_LEVEL, testEmployee.getEmploymentLevel());
  }

  @Test
  void getEmploymentLevelBonus() {
    // Verifies the 1.4 bonus for INTERMEDIATE_LEVEL
    assertEquals(1.4, testEmployee.getEmploymentLevelBonus(), 0.01);
  }

  @Test
  void testEquals() {
    // Identical object
    BenefitEligibleEmployee same = new BenefitEligibleEmployee(
        "E123", date, 50000.0, contact, EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.INTERMEDIATE_LEVEL, 40.0, 40.0, 0.0);

    // Different ID
    BenefitEligibleEmployee different = new BenefitEligibleEmployee(
        "E999", date, 50000.0, contact, EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.INTERMEDIATE_LEVEL, 40.0, 40.0, 0.0);

    assertEquals(testEmployee, same);
    assertNotEquals(testEmployee, different);
    assertNotEquals(testEmployee, null);
    assertNotEquals(testEmployee, "Not an Employee");
  }

  @Test
  void testHashCode() {
    BenefitEligibleEmployee same = new BenefitEligibleEmployee(
        "E123", date, 50000.0, contact, EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.INTERMEDIATE_LEVEL, 40.0, 40.0, 0.0);

    assertEquals(testEmployee.hashCode(), same.hashCode());
  }

  @Test
  void testToString() {
    String result = testEmployee.toString();
    // Ensures the string contains key identifying info from the Employee parent class
    assertTrue(result.contains("E123"));
    assertTrue(result.contains("INTERMEDIATE_LEVEL"));
  }
}
