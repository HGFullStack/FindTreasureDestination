package com.mycompany.program;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mycompany.constants.Constants;
import com.mycompany.exception.AppException;
import com.mycompany.model.TravelPreparationInfo;
import com.mycompany.model.TreasureHuntTeam;
import com.mycompany.process.TeamMovementProcess;
import com.mycompany.util.DirectionsTravelSpeedParser;
import com.mycompany.util.InputCommandsFileLoader;

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

          if (splitArr.length != 3) throw new AppException("invalid input");

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
          log.error("error in pgm", ex);
        }
      }

      System.out.println(instance);
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
  }
}
