package problem1;

import java.time.LocalDate;

/**
 * The type Hourly employee.
 */
public class HourlyEmployee extends PartTimeEmployee {
  private final Double hourlyEarnings;
  private static final Double HOURLY_EARNING = 14.0;
  private static final Double HOURLY_BONUS = 3.0;

  /**
   * Instantiates a new Hourly employee.
   *
   * @param employeeID               the employee id
   * @param employmentDate           the employment date
   * @param lastYearEarning          the last year earning
   * @param contactInfo              the contact info
   * @param educationLevel           the education level
   * @param employmentLevel          the employment level
   * @param contractualHours         the contractual hours
   * @param actualHours              the actual hours
   * @param bonusAndOvertimeEarnings the bonus and overtime earnings
   * @param hourlyEarnings           the hourly earnings
   */
  public HourlyEmployee(final String employeeID, final LocalDate employmentDate, final Double lastYearEarning,
      final ContactInfo contactInfo, final EducationLevel educationLevel, final EmploymentLevel employmentLevel,
      final Double contractualHours, final Double actualHours, final Double bonusAndOvertimeEarnings,
      final Double hourlyEarnings) {
    super(employeeID, employmentDate, lastYearEarning, contactInfo, educationLevel, employmentLevel,
        contractualHours, actualHours, bonusAndOvertimeEarnings);
    this.hourlyEarnings = hourlyEarnings;
  }

  /**
   * Estimates the productivity for an Hourly Employee by extending
   * the part-time base calculation.
   * @return the total estimated productivity as a Double
   * */
  @Override
  public Double estimateProductivity() {
    double currentEstimate = super.estimateProductivity();
    if (hourlyEarnings < HOURLY_EARNING) {
      currentEstimate += HOURLY_BONUS;
    }
    return currentEstimate;
  }

  /**
   * Gets hourly earnings as Double
   * @return the hourly earnings
   */
  public Double getHourlyEarnings() {
    return hourlyEarnings;
  }
}
