package problem1;

import java.time.LocalDate;

/**
 * The type Part time employee.
 */
public abstract class PartTimeEmployee extends Employee {
  private static final Double ESTIMATE_PRODUCTIVITY = 3.7;

  private final Double contractualHours;
  private final Double actualHours;
  private final Double bonusAndOvertimeEarnings;


  /**
   * Instantiates a new Part time employee.
   *
   * @param employeeID               the employee id as String
   * @param employmentDate           the employment date as LocalDate
   * @param lastYearEarning          the last year earning as Double
   * @param contactInfo              the contact info
   * @param educationLevel           the education level
   * @param employmentLevel          the employment level
   * @param contractualHours         the contractual hours as Double
   * @param actualHours              the actual hours as Double
   * @param bonusAndOvertimeEarnings the bonus and overtime earnings
   */
  public PartTimeEmployee(final String employeeID, final LocalDate employmentDate, final Double lastYearEarning,
      final ContactInfo contactInfo, final EducationLevel educationLevel, final EmploymentLevel employmentLevel,
      final Double contractualHours, final Double actualHours, final Double bonusAndOvertimeEarnings) {
    super(employeeID, employmentDate, lastYearEarning, contactInfo, educationLevel,
        employmentLevel);
    this.contractualHours = contractualHours;
    this.actualHours = actualHours;
    this.bonusAndOvertimeEarnings = bonusAndOvertimeEarnings;
  }

  /**
   * Estimates the productivity for a part-time employee.
   * @return the total estimated productivity for the part-time employee as a Double.
   **/
  @Override
  public Double estimateProductivity() {
    double currentEstimate = this.actualHours / this.contractualHours * ESTIMATE_PRODUCTIVITY;
    currentEstimate += getEmploymentLevelBonus();

    return currentEstimate;
  }

  /**
   * Gets contractual hours as Double
   * @return the contractual hours
   */
  public Double getContractualHours() {
    return contractualHours;
  }

  /**
   * Gets actual hours as Double
   * @return the actual hours
   */
  public Double getActualHours() {
    return actualHours;
  }

  /**
   * Gets bonus and overtime earnings Double
   * @return the bonus and overtime earnings
   */
  public Double getBonusAndOvertimeEarnings() {
    return bonusAndOvertimeEarnings;
  }
}
