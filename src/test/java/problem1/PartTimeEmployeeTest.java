package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class PartTimeEmployeeTest {

  private BenefitEligibleEmployee testPartTimer;
  private ContactInfo contact;

  @BeforeEach
  void setUp() {
    Name name = new Name("Jane", "Doe");
    Name emergency = new Name("John", "Doe");
    contact = new ContactInfo(name, "123 St", "555", "j@j.com", emergency);

    // Using 40 contractual hours and 20 actual hours (easy math!)
    testPartTimer = new BenefitEligibleEmployee(
        "P123",
        LocalDate.now(),
        30000.0,
        contact,
        EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.INTERMEDIATE_LEVEL, // Bonus is 1.4
        40.0,  // Contractual Hours
        20.0,  // Actual Hours
        500.0  // Bonus/Overtime Earnings
    );
  }

  @Test
  void estimateProductivity() {
    // Math Breakdown:
    // 1. Ratio: 20.0 (Actual) / 40.0 (Contractual) = 0.5
    // 2. Multiplier: 0.5 * 3.7 = 1.85
    // 3. Level Bonus: INTERMEDIATE_LEVEL = 1.4
    // Total: 1.85 + 1.4 = 3.25
    assertEquals(3.25, testPartTimer.estimateProductivity(), 0.01);
  }

  @Test
  void getContractualHours() {
    assertEquals(40.0, testPartTimer.getContractualHours(), 0.01);
  }

  @Test
  void getActualHours() {
    assertEquals(20.0, testPartTimer.getActualHours(), 0.01);
  }

  @Test
  void getBonusAndOvertimeEarnings() {
    assertEquals(500.0, testPartTimer.getBonusAndOvertimeEarnings(), 0.01);
  }
}