package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class FullTimeEmployeeTest {

  private Manager testFullTimer;
  private LocalDate oldPromotionDate;
  private ContactInfo contact;

  @BeforeEach
  void setUp() {
    // 5 years ago triggers the 0.8 penalty
    oldPromotionDate = LocalDate.now().minusYears(5);

    Name name = new Name("Jane", "Doe");
    Name emergency = new Name("John", "Doe");
    contact = new ContactInfo(name, "123 St", "555", "j@j.com", emergency);

    // Using 120,000 for earnings and 100,000 for base pay
    testFullTimer = new Manager(
        "F123",
        LocalDate.now(),
        120000.0,      // lastYearEarning
        contact,
        EducationLevel.MASTERS_DEGREE,
        EmploymentLevel.ENTRY_LEVEL,
        100000.0,      // basePay
        5000.0,        // bonuses
        2000.0,        // overTime
        oldPromotionDate,
        3,             // numOfProjects (triggers 1.5 bonus)
        5              // managedEmployees
    );
  }

  @Test
  void estimateProductivity() {
    // Math Breakdown:
    // 1. Ratio: 120,000 / 100,000 = 1.2
    // 2. Project Bonus: 3 projects (> 2) = +1.5
    // 3. Penalty: It's been 5 years = -0.8
    // 4. Level Bonus: ENTRY = +0.0
    // Total: 1.2 + 1.5 - 0.8 = 1.9
    assertEquals(1.9, testFullTimer.estimateProductivity(), 0.01);
  }

  @Test
  void getBasePay() {
    assertEquals(100000.0, testFullTimer.getBasePay(), 0.01);
  }

  @Test
  void getLastYearEarning() {
    // Testing the value inherited from Employee
    assertEquals(120000.0, testFullTimer.getLastYearEarning(), 0.01);
  }

  @Test
  void getPromotionPenalty() {
    assertEquals(0.8, testFullTimer.getPromotionPenalty(), 0.01);
  }

  @Test
  void getNumOfProjects() {
    assertEquals(3, testFullTimer.getNumOfProjects());
  }

  @Test
  void getLastPromotionDate() {
    assertEquals(oldPromotionDate, testFullTimer.getLastPromotionDate());
  }
}