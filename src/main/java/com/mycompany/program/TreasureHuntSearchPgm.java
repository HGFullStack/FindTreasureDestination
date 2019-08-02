package com.mycompany.program;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mycompany.constants.Constants;
import com.mycompany.model.InputCommandsFileLoader;
import com.mycompany.model.TravelDurationInput;
import com.mycompany.model.TreasureHuntTeam;
import com.mycompany.process.DirectionsTravelDurationParseer;
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
          final String travelMode =
              splitArr[0]
                  .trim()
                  .replaceAll(Constants.SINGLE_SPACE, Constants.UNDERSCORE)
                  .toUpperCase();
          String travelDuration =
              splitArr[1].trim().replaceAll(Constants.SINGLE_SPACE, Constants.EMPTY).toLowerCase();
          final String travelDirection = splitArr[2].trim().toUpperCase();
          final int speed = DirectionsTravelSpeedParser.getSpeedFromTravelMode(travelMode);
          final TravelDurationInput travelDurationInput =
              DirectionsTravelDurationParseer.getTravelDurationParameters(travelDuration);

          travelDuration = travelDurationInput.getTravelDuration().trim();

          int time_in_minutes = 0;

          if (!travelDurationInput.isHour_present()) {
            time_in_minutes = Integer.parseInt(travelDuration);
          } else {
            if (!travelDurationInput.isMin_present()) {
              travelDuration = travelDuration.concat(Constants.APPENDING_ZERO);
            }

            final String[] splitTime = travelDuration.split(Constants.COMMA);

            time_in_minutes = Integer.parseInt(splitTime[1]) + Integer.parseInt(splitTime[0]) * 60;
          }

          TeamMovementProcess.advance(instance, speed, travelDirection, time_in_minutes);
          System.out.println("instance" + instance);
        } catch (final Exception ex) {
          log.error("error in parsing the file", ex);
        }
      }

      System.out.println("final position is " + instance);
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
  }
}
