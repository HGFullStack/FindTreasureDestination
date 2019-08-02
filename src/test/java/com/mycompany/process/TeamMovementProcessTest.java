package com.mycompany.process;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.constants.Constants;

public class TeamMovementProcessTest {
  private static final String INPUT_FILE_PATH = Constants.INPUT_FILE_NAME;
  private static final String OUTPUT_ONE =
      "1.4748731 miles to the South, 2.2868857 miles to the East";

  @AfterEach
  void tearDown() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @Test
  void testProcess() {
    final TeamMovementProcess teamMovementProcess = new TeamMovementProcess();
    assertEquals(OUTPUT_ONE, teamMovementProcess.process(INPUT_FILE_PATH));
  }

  @BeforeEach
  void setUp() throws Exception {}

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}
}
