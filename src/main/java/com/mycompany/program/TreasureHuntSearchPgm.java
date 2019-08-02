package com.mycompany.program;

import com.mycompany.constants.Constants;
import com.mycompany.process.TeamMovementProcess;

public class TreasureHuntSearchPgm {
  private static final String INPUT_FILE_PATH = Constants.INPUT_FILE_NAME_ONE;

  public static void main(final String[] args) {
    System.out.println(new TeamMovementProcess().process(INPUT_FILE_PATH));
  }
}
