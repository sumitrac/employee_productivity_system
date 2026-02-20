package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The type Employee.
 */
public abstract class Employee implements EmployeeInterface {

  private static final double INTERMEDIATE_BONUS = 1.4;
  private static final double ZERO_BONUS = 0.0;

  private final String employeeID;
  private final LocalDate employmentDate;
  protected Double lastYearEarning;
  private final ContactInfo contactInfo;
  private final EducationLevel educationLevel;
  private final EmploymentLevel employmentLevel;

  /**
   * Instantiates a new Employee.
   *
   * @param employeeID      the employee id as String
   * @param employmentDate  the employment date as LocalDate
   * @param lastYearEarning the last year earning as Double
   * @param contactInfo     the contact info as ContactInfo
   * @param educationLevel  the education level as enum
   * @param employmentLevel the employment level as enum
   */
  public Employee(final String employeeID, final LocalDate employmentDate,
      final Double lastYearEarning,
      final ContactInfo contactInfo, final EducationLevel educationLevel,
      final EmploymentLevel employmentLevel) {
    this.employeeID = employeeID;
    this.employmentDate = employmentDate;
    this.lastYearEarning = lastYearEarning;
    this.contactInfo = contactInfo;
    this.educationLevel = educationLevel;
    this.employmentLevel = employmentLevel;
  }

  @Override
  public abstract Double estimateProductivity();

  /**
   * Calculates the bonus boost based on the employee's level of employment.
   *  @return as Double (1.4 if Intermediate, 0.0 otherwise).
   **/
  protected Double getEmploymentLevelBonus() {
    double bonus = ZERO_BONUS;
    if (this.employmentLevel == EmploymentLevel.INTERMEDIATE_LEVEL) {
      bonus = INTERMEDIATE_BONUS;
    }
    return bonus;
  }

  /**
   * Gets employee id.
   * @return the employee id as String
   */
  public String getEmployeeID() {
    return employeeID;
  }

  /**
   * Gets employment date as LocalDate
   * @return the employment date
   */
  public LocalDate getEmploymentDate() {
    return employmentDate;
  }

  /**
   * Gets last year earning as Double
   * @return the last year earning
   */
  public Double getLastYearEarning() {
    return lastYearEarning;
  }

  /**
   * Gets education level
   * @return the education level
   */
  public EducationLevel getEducationLevel() {
    return educationLevel;
  }

  /**
   * Gets contact info
   * @return the contact info
   */
  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  /**
   * Gets employment level
   * @return the employment level
   */
  public EmploymentLevel getEmploymentLevel() {
    return employmentLevel;
  }

  /**
   * Compares this employee with another object for equality.
   * @return true if equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Employee employee = (Employee) o;
    return Objects.equals(employeeID, employee.employeeID) && Objects.equals(
        employmentDate, employee.employmentDate) && Objects.equals(lastYearEarning,
        employee.lastYearEarning) && Objects.equals(contactInfo, employee.contactInfo)
        && Objects.equals(educationLevel, employee.educationLevel)
        && Objects.equals(employmentLevel, employee.employmentLevel);
  }

  /**
   * @return A unique hash code for this employee.
   */
  @Override
  public int hashCode() {
    return Objects.hash(employeeID, employmentDate, lastYearEarning, contactInfo, educationLevel,
        employmentLevel);
  }

  /**
   * @return A string containing the employee's details.
   */
  @Override
  public String toString() {
    return "Employee{" +
        "employeeID='" + employeeID + '\'' +
        ", employmentDate=" + employmentDate +
        ", lastYearEarning=" + lastYearEarning +
        ", contactInfo=" + contactInfo +
        ", educationLevel=" + educationLevel +
        ", employmentLevel=" + employmentLevel +
        '}';
  }
}
