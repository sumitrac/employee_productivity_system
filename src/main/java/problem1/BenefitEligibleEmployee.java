package problem1;

import java.time.LocalDate;

/**
 * The type Benefit eligible employee.
 */
public class BenefitEligibleEmployee extends PartTimeEmployee {

  /**
   * Instantiates a new Benefit eligible employee.
   *
   * @param employeeID               the employee id as String
   * @param employmentDate           the employment date as LocalDate
   * @param lastYearEarning          the last year earning as Double
   * @param contactInfo              the contact info as ContactInfo
   * @param educationLevel           the education level as EducationLevel
   * @param employmentLevel          the employment level as EmploymentLevel
   * @param contractualHours         the contractual hours as Double
   * @param actualHours              the actual hours as Double
   * @param bonusAndOvertimeEarnings the bonus and overtime earnings as Double
   */
  public BenefitEligibleEmployee(final String employeeID, final LocalDate employmentDate,
      final Double lastYearEarning, final ContactInfo contactInfo,
      final EducationLevel educationLevel,
      final EmploymentLevel employmentLevel, final Double contractualHours,
      final Double actualHours,
      final Double bonusAndOvertimeEarnings) {
    super(employeeID, employmentDate, lastYearEarning, contactInfo, educationLevel, employmentLevel,
        contractualHours, actualHours, bonusAndOvertimeEarnings);
  }
}
