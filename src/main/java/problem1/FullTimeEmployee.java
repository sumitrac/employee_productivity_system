package problem1;

import java.time.LocalDate;

/**
 * The type Full time employee.
 */
public abstract class FullTimeEmployee extends Employee {

  private static final Double PENALTY_NUMBER = 0.8;
  private static final Double PROJECT_NUMBER = 2.0;
  private static final Double PROJECT_BONUS_BOOST = 1.5;

  private final Double basePay;
  private final Double bonuses;
  private final Double overTime;
  private final LocalDate lastPromotionDate;
  private final Integer numOfProjects;

  /**
   * Instantiates a new Full time employee.
   *
   * @param employeeID        the employee id as String
   * @param employmentDate    the employment date as LocalDate
   * @param lastYearEarning   the last year earning as Double
   * @param contactInfo       the contact info
   * @param educationLevel    the education level
   * @param employmentLevel   the employment level
   * @param basePay           the base pay as Double
   * @param bonuses           the bonuses as Double
   * @param overTime          the over time as Double
   * @param lastPromotionDate the last promotion date as LocalDate
   * @param numOfProjects     the num of projects as Integer
   */
  public FullTimeEmployee(final String employeeID, final LocalDate employmentDate, final Double lastYearEarning,
      final ContactInfo contactInfo, final EducationLevel educationLevel, final EmploymentLevel employmentLevel,
      final Double basePay, final Double bonuses, final Double overTime, final LocalDate lastPromotionDate,
      final Integer numOfProjects) {
    super(employeeID, employmentDate, lastYearEarning, contactInfo, educationLevel,
        employmentLevel);
    this.basePay = basePay;
    this.bonuses = bonuses;
    this.overTime = overTime;
    this.lastPromotionDate = lastPromotionDate;
    this.numOfProjects = numOfProjects;
  }

  // Helper method to calculate promotional penalty
  protected Double getPromotionPenalty() {
    // Determine the date 3 years ago from today
    final LocalDate threeYearsAgo = LocalDate.now().minusYears(3);

    // If the promotion date is BEFORE that cutoff, it's been more than 3 years
    if (this.lastPromotionDate.isBefore(threeYearsAgo)) {
      return PENALTY_NUMBER;
    }
    return 0.0;
  }

  /**
   * Estimates the productivity for a full-time employee based on earnings,
   * project load, and promotion history.
   * @return the total estimated productivity as a Double.
   **/
  @Override
  public Double estimateProductivity() {
    // Base productivity estimate
    double currentEstimate = this.lastYearEarning / this.basePay;

    // Project bonus for employees with more than 2 projects
    if (this.numOfProjects > PROJECT_NUMBER) {
        currentEstimate += PROJECT_BONUS_BOOST;
    }
    currentEstimate -= getPromotionPenalty();
    currentEstimate += getEmploymentLevelBonus();

    return currentEstimate;
  }

  /**
   * Gets base pay as Double
   * @return the base pay
   */
  public Double getBasePay() {
    return basePay;
  }

  /**
   * Gets bonuses as Double
   * @return the bonuses
   */
  public Double getBonuses() {
    return bonuses;
  }

  /**
   * Gets over time as Double
   * @return the over time
   */
  public Double getOverTime() {
    return overTime;
  }

  /**
   * Gets last promotion date
   * @return the last promotion date
   */
  public LocalDate getLastPromotionDate() {
    return lastPromotionDate;
  }

  /**
   * Gets num of projects as Integer
   * @return the num of projects
   */
  public Integer getNumOfProjects() {
    return numOfProjects;
  }
}
