package problem1;

import java.time.LocalDate;

/**
 * The type Individual contributor.
 */
public class IndividualContributor extends FullTimeEmployee{
  public static final Double PUBLICATION_NUMBER = 4.0;
  public static final Double PUBLICATION_BONUS = 1.3;

  private final Integer numOfPatents;
  private final Integer numOfPublications;
  private final Integer numOfExternalCollab;

  /**
   * Instantiates a new Individual contributor.
   *
   * @param employeeID          the employee id as String
   * @param employmentDate      the employment date as LocalDate
   * @param lastYearEarning     the last year earning as Double
   * @param contactInfo         the contact info
   * @param educationLevel      the education level
   * @param employmentLevel     the employment level
   * @param basePay             the base pay as Double
   * @param bonuses             the bonuses as Double
   * @param overtime            the overtime as Double
   * @param lastPromotionDate   the last promotion date as LocalDate
   * @param numOfProjects       the num of projects as Integer
   * @param numOfPatents        the num of patents as Integer
   * @param numOfPublications   the num of publications as Integer
   * @param numOfExternalCollab the num of external collab as Integer
   */
  public IndividualContributor(final String employeeID, final LocalDate employmentDate,
      final Double lastYearEarning, final ContactInfo contactInfo, final EducationLevel educationLevel,
      final EmploymentLevel employmentLevel, final Double basePay, final Double bonuses, final Double overtime,
      final LocalDate lastPromotionDate, final Integer numOfProjects, final Integer numOfPatents,
      final Integer numOfPublications, final Integer numOfExternalCollab) {
    super(employeeID, employmentDate, lastYearEarning, contactInfo, educationLevel, employmentLevel,
        basePay, bonuses, overtime, lastPromotionDate, numOfProjects);
    this.numOfPatents = numOfPatents;
    this.numOfPublications = numOfPublications;
    this.numOfExternalCollab = numOfExternalCollab;
  }

  /**
   * Calculates the total productivity estimate for an Individual contributor.
   * @return the total estimated productivity as a Double
   **/
  @Override
  public Double estimateProductivity() {
    // Pulls the Earnings/BasePay ratio and Project Bonus from FullTimeEmployee
    double currentEstimate = super.estimateProductivity();

    if (numOfPublications > PUBLICATION_NUMBER) {
      currentEstimate += PUBLICATION_BONUS;
    }
    return currentEstimate;
  }

  /**
   * Gets num of patents as Integer
   * @return the num of patents
   */
  public Integer getNumOfPatents() {
    return numOfPatents;
  }

  /**
   * Gets num of publications as Integer
   * @return the num of publications
   */
  public Integer getNumOfPublications() {
    return numOfPublications;
  }

  /**
   * Gets num of external collab as Integer
   * @return the num of external collab
   */
  public Integer getNumOfExternalCollab() {
    return numOfExternalCollab;
  }
}
