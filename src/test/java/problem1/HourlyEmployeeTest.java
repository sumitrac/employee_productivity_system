package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class HourlyEmployeeTest {

  private HourlyEmployee lowPayEmployee;
  private HourlyEmployee highPayEmployee;
  private ContactInfo contact;

  @BeforeEach
  void setUp() {
    Name name = new Name("Jane", "Doe");
    Name emergency = new Name("John", "Doe");
    contact = new ContactInfo(name, "123 St", "555", "j@j.com", emergency);

    // Employee 1: Makes $10/hour (Should get the +3.0 bonus)
    lowPayEmployee = new HourlyEmployee(
        "H1", LocalDate.now(), 20000.0, contact, EducationLevel.HIGH_SCHOOL_DIPLOMA,
        EmploymentLevel.ENTRY_LEVEL, 40.0, 20.0, 0.0, 10.0
    );

    // Employee 2: Makes $20/hour (Should NOT get the bonus)
    highPayEmployee = new HourlyEmployee(
        "H2", LocalDate.now(), 40000.0, contact, EducationLevel.HIGH_SCHOOL_DIPLOMA,
        EmploymentLevel.ENTRY_LEVEL, 40.0, 20.0, 0.0, 20.0
    );
  }

  @Test
  void estimateProductivityWithBonus() {
    // 1. PartTime Logic: (20/40) * 3.7 = 1.85
    // 2. Hourly Logic: $10 < $14, so add +3.0
    // Total: 1.85 + 3.0 = 4.85
    assertEquals(4.85, lowPayEmployee.estimateProductivity(), 0.01);
  }

  @Test
  void estimateProductivityWithoutBonus() {
    // 1. PartTime Logic: (20/40) * 3.7 = 1.85
    // 2. Hourly Logic: $20 is NOT < $14, so +0.0
    // Total: 1.85
    assertEquals(1.85, highPayEmployee.estimateProductivity(), 0.01);
  }

  @Test
  void getHourlyEarnings() {
    assertEquals(10.0, lowPayEmployee.getHourlyEarnings(), 0.01);
  }
}