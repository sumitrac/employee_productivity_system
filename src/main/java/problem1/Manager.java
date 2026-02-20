package problem1;

import java.time.LocalDate;

/**
 * The type Manager.
 */
public class Manager extends FullTimeEmployee {
  private final Integer managedNumOfEmployees;
  private static final Double EMPLOYEE_NUMBER = 8.0;
  private static final Double BONUS_BOOST = 1.8;


  /**
   * Instantiates a new Manager.
   *
   * @param employeeID            the employee id as String
   * @param employmentDate        the employment date as LocalDate
   * @param lastYearEarning       the last year earning as Double
   * @param contactInfo           the contact info
   * @param educationLevel        the education level
   * @param employmentLevel       the employment level
   * @param basePay               the base pay as Double
   * @param bonuses               the bonuses as Double
   * @param overtime              the overtime as Double
   * @param lastPromotionDate     the last promotion date as LocalDate
   * @param numOfProjects         the num of projects as Integer
   * @param managedNumOfEmployees the managed num of employees an Integer
   */
  public Manager(final String employeeID, final LocalDate employmentDate, final Double lastYearEarning,
      final ContactInfo contactInfo, final EducationLevel educationLevel, final EmploymentLevel employmentLevel,
      final Double basePay, final Double bonuses, final Double overtime, final LocalDate lastPromotionDate,
      final Integer numOfProjects, final Integer managedNumOfEmployees) {
    super(employeeID, employmentDate, lastYearEarning, contactInfo, educationLevel, employmentLevel,
        basePay, bonuses, overtime, lastPromotionDate, numOfProjects);
    this.managedNumOfEmployees = managedNumOfEmployees;
  }

  /**
   * Calculates the total productivity estimate for a Manager.
   * @return the total estimated productivity as a Double
   **/
  @Override
  public Double estimateProductivity() {
    double currentEstimate = super.estimateProductivity();

    if (managedNumOfEmployees > EMPLOYEE_NUMBER) {
      currentEstimate += BONUS_BOOST; // Manager specific bonus
    }
    return currentEstimate;
  }

  /**
   * Gets managed num of employees as Integer
   * @return the managed num of employees
   */
  public Integer getManagedNumOfEmployees() {
    return managedNumOfEmployees;
  }
}
