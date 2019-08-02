package com.mycompany.process;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.constants.Constants;

public class TeamMovementProcessTest {
  private static final String INPUT_FILE_PATH_ONE = Constants.INPUT_FILE_NAME_ONE;
  private static final String INPUT_FILE_PATH_TWO = Constants.INPUT_FILE_NAME_TWO;
  private static final String OUTPUT_ONE =
      "1.4748731 miles to the South, 2.2868857 miles to the East";
  private static final String OUTPUT_TWO = "";

  @AfterEach
  void tearDown() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @Test
  void testProcess_one() {
    final TeamMovementProcess teamMovementProcess = new TeamMovementProcess();

    assertEquals(OUTPUT_ONE, teamMovementProcess.process(INPUT_FILE_PATH_ONE));
  }

  @Test
  void testProcess_two() {
    final TeamMovementProcess teamMovementProcess = new TeamMovementProcess();

    assertEquals(OUTPUT_TWO, teamMovementProcess.process(INPUT_FILE_PATH_TWO));
  }

  @BeforeEach
  void setUp() throws Exception {}

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}
}
