package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class IndividualContributorTest {

  private IndividualContributor highAchiever;
  private IndividualContributor averageAchiever;
  private ContactInfo contact;
  private LocalDate recentDate;

  @BeforeEach
  void setUp() {
    recentDate = LocalDate.now().minusYears(1); // No promotion penalty
    Name name = new Name("Jane", "Doe");
    Name emergency = new Name("John", "Doe");
    contact = new ContactInfo(name, "123 St", "555", "j@j.com", emergency);

    // Achiever 1: 5 Publications (Should get +1.3 bonus)
    highAchiever = new IndividualContributor(
        "IC1", recentDate, 120000.0, contact, EducationLevel.MASTERS_DEGREE,
        EmploymentLevel.INTERMEDIATE_LEVEL, 100000.0, 0.0, 0.0, recentDate,
        0, // 0 projects (No project bonus)
        2, 5, 10
    );

    // Achiever 2: 2 Publications (Should NOT get bonus)
    averageAchiever = new IndividualContributor(
        "IC2", recentDate, 100000.0, contact, EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.ENTRY_LEVEL, 100000.0, 0.0, 0.0, recentDate,
        0, // 0 projects
        1, 2, 5
    );
  }

  @Test
  void estimateProductivityWithPublicationBonus() {
    // 1. Ratio: 1.2
    // 2. Publication Bonus: 1.3
    // 3. Employment Level Bonus: 1.4 (Inherited from Employee)
    // Total: 1.2 + 1.3 + 1.4 = 3.9
    assertEquals(3.9, highAchiever.estimateProductivity(), 0.01);
  }

  @Test
  void estimateProductivityWithoutPublicationBonus() {
    // 1. FullTime Ratio: 100k / 100k = 1.0
    // 2. Publication Bonus: 2 is NOT > 4, so +0.0
    // Total: 1.0
    assertEquals(1.0, averageAchiever.estimateProductivity(), 0.01);
  }

  @Test
  void getIndividualFields() {
    assertEquals(2, highAchiever.getNumOfPatents());
    assertEquals(5, highAchiever.getNumOfPublications());
    assertEquals(10, highAchiever.getNumOfExternalCollab());
  }
}