package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {

  private Name testName;
  private String first = "Sumi";
  private String last = "Karki";

  @BeforeEach
  void setUp() {
    testName = new Name(first, last);
  }

  @Test
  void getFirstName() {
    assertEquals(first, testName.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals(last, testName.getLastName());
  }
}