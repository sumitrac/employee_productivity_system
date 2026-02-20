package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class ManagerTest {

  private Manager highCapacityManager;
  private Manager standardManager;
  private ContactInfo contact;
  private LocalDate recentDate;

  @BeforeEach
  void setUp() {
    recentDate = LocalDate.now().minusYears(1); // Avoids the 0.8 promotion penalty
    Name name = new Name("Bruce", "Wayne");
    Name emergency = new Name("Alfred", "Pennyworth");
    contact = new ContactInfo(name, "Gotham Manor", "555-0100", "bruce@wayne.com", emergency);

    // Manager 1: Manages 10 people (Bonus!) + 3 Projects (Bonus!)
    highCapacityManager = new Manager(
        "M1", recentDate, 120000.0, contact, EducationLevel.MASTERS_DEGREE,
        EmploymentLevel.EXECUTIVE_LEVEL, 100000.0, 0.0, 0.0, recentDate,
        3,  // numOfProjects > 2 (triggers +1.5 boost)
        10  // managedEmployees > 8 (triggers +1.8 boost)
    );

    // Manager 2: Manages 5 people (No bonus) + 0 Projects (No bonus)
    standardManager = new Manager(
        "M2", recentDate, 100000.0, contact, EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.INTERMEDIATE_LEVEL, 100000.0, 0.0, 0.0, recentDate,
        0, 5
    );
  }

  @Test
  void estimateProductivityWithAllBonuses() {
    // 1. Ratio: 1.2 (120k/100k)
    // 2. Project Bonus: 1.5 (3 projects)
    // 3. Manager Bonus: 1.8 (10 employees)
    // 4. Level/Edu Bonus: 0.0
    assertEquals(4.5, highCapacityManager.estimateProductivity(), 0.01);
  }

  @Test
  void estimateProductivityStandard() {
    // Math Breakdown:
    // 1. Ratio: 100k / 100k = 1.0
    // 2. Project Bonus: 0.0
    // 3. Manager Bonus: 0.0
    // 4. Level/Edu Bonus: +1.4
    // Total: 1.0 + 1.4 = 2.4

    assertEquals(2.4, standardManager.estimateProductivity(), 0.01);
  }

  @Test
  void getManagedNumOfEmployees() {
    assertEquals(10, highCapacityManager.getManagedNumOfEmployees());
  }
}