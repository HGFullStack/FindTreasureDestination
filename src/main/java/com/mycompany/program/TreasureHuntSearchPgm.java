package com.mycompany.program;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mycompany.constants.Constants;
import com.mycompany.model.InputCommandsFileLoader;
import com.mycompany.model.TravelPreparationInfo;
import com.mycompany.model.TreasureHuntTeam;
import com.mycompany.process.DirectionsTravelSpeedParser;
import com.mycompany.process.TeamMovementProcess;

public class TreasureHuntSearchPgm {
  private static final Logger log = LogManager.getLogger(TreasureHuntSearchPgm.class);

  public static void main(final String[] args) {
    Scanner scanner = null;

    try {
      scanner = new Scanner(InputCommandsFileLoader.getReadingsInputFile());

      final TreasureHuntTeam instance = TreasureHuntTeam.getInstance();

      while (scanner.hasNextLine()) {
        try {
          final String[] splitArr = scanner.nextLine().split(Constants.COMMA);

          if (splitArr.length != 3) {
            continue;
          }

          if (splitArr.length == 3) {
            final TravelPreparationInfo travelPreparationInfo =
                TeamMovementProcess.prepare(splitArr);

            TeamMovementProcess.advance(
                instance,
                DirectionsTravelSpeedParser.getSpeedFromTravelMode(
                    travelPreparationInfo.getTravelMode()),
                splitArr[2].trim().toUpperCase(),
                travelPreparationInfo.getTimeInMinutes());
          }
        } catch (final Exception ex) {
          log.error("error in parsing the file", ex);
        }
      }

      System.out.println(instance);
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
  }
}
