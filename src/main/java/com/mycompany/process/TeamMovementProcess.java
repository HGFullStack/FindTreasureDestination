package com.mycompany.process;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mycompany.constants.Constants;
import com.mycompany.constants.TravelDirection;
import com.mycompany.exception.AppException;
import com.mycompany.model.TravelDurationInput;
import com.mycompany.model.TravelPreparationInfo;
import com.mycompany.model.TreasureHuntTeam;
import com.mycompany.util.DirectionsTravelDurationParseer;
import com.mycompany.util.DirectionsTravelSpeedParser;
import com.mycompany.util.InputCommandsFileLoader;

public class TeamMovementProcess {
  private static final Logger log = LogManager.getLogger(TeamMovementProcess.class);

  private TeamMovementProcess() {}

  private static void advance(
      final TreasureHuntTeam treasureHuntTeam,
      final int speedInMilesPerHour,
      final String travelDirection,
      final int time_in_minutes) {
    final float milesPerMinute = (float) speedInMilesPerHour / 60;
    final float distance = milesPerMinute * time_in_minutes;
    float x = treasureHuntTeam.getPositionX();
    float y = treasureHuntTeam.getPositionY();

    switch (TravelDirection.valueOf(travelDirection)) {
      case NE:
        y = (float) (y + distance / Math.sqrt(2));
        x = (float) (x + distance / Math.sqrt(2));

        break;

      case NW:
        y = (float) (y + distance / Math.sqrt(2));
        x = (float) (x - distance / Math.sqrt(2));

        break;

      case SE:
        y = (float) (y - distance / Math.sqrt(2));
        x = (float) (x + distance / Math.sqrt(2));

        break;

      case SW:
        y = (float) (y - distance / Math.sqrt(2));
        x = (float) (x - distance / Math.sqrt(2));

        break;

      case N:
        y = y + distance;

        break;

      case E:
        x = x + distance;

        break;

      case W:
        x = x - distance;

        break;

      case S:
        y = y - distance;

        break;

      default:
        x = x + 0;
        y = y + 0;

        break;
    }

    treasureHuntTeam.setPositionX(x);
    treasureHuntTeam.setPositionY(y);
  }

  public static void checkEachLine(final TreasureHuntTeam instance, final Scanner scanner) {
    try {
      final String[] splitArr = scanner.nextLine().split(Constants.COMMA);

      if (splitArr.length != 3) throw new AppException("invalid input");

      if (splitArr.length == 3) {
        final TravelPreparationInfo travelPreparationInfo = prepare(splitArr);

        advance(
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

  private static String displayResult(final TreasureHuntTeam instance) {
    String result = "";

    if (instance.getPositionY() != 0) {
      if (instance.getPositionY() < 0) {
        result = result + Math.abs(instance.getPositionY());
        result = result.concat(Constants.MILES_TO_THE).concat(Constants.SOUTH_DISPLAY);
      } else {
        result = result + instance.getPositionY();
        result = result.concat(Constants.MILES_TO_THE).concat(Constants.NORTH_DISPLAY);
      }

      result = result + Constants.COMMA_WITH_SPACE_AT_END;
    }

    if (instance.getPositionX() != 0) {
      if (instance.getPositionX() < 0) {
        result = result + Math.abs(instance.getPositionX());
        result = result.concat(Constants.MILES_TO_THE).concat(Constants.WEST_DISPLAY);
      } else {
        result = result + instance.getPositionX();
        result = result.concat(Constants.MILES_TO_THE).concat(Constants.EAST_DISPLAY);
      }
    }

    return result;
  }

  private static TravelPreparationInfo prepare(final String[] splitArr) {
    final String travelMode =
        splitArr[0].trim().replaceAll(Constants.SINGLE_SPACE, Constants.UNDERSCORE).toUpperCase();
    final TravelDurationInput travelDurationInput =
        DirectionsTravelDurationParseer.getTravelDurationParameters(
            splitArr[1].trim().replaceAll(Constants.SINGLE_SPACE, Constants.EMPTY).toLowerCase());
    String travelDuration = travelDurationInput.getTravelDuration().trim();
    int timeInMinutes = 0;

    if (!travelDurationInput.isHour_present()) {
      timeInMinutes = Integer.parseInt(travelDuration);
    } else {
      if (!travelDurationInput.isMin_present()) {
        travelDuration = travelDuration.concat(Constants.APPENDING_ZERO);
      }

      final String[] splitTime = travelDuration.split(Constants.COMMA);

      timeInMinutes = Integer.parseInt(splitTime[1]) + Integer.parseInt(splitTime[0]) * 60;
    }

    return new TravelPreparationInfo(timeInMinutes, travelMode);
  }

  public static String process(final String inputFileName) {
    final TreasureHuntTeam instance = TreasureHuntTeam.getInstance();

    try (Scanner scanner =
        new Scanner(InputCommandsFileLoader.getReadingsInputFile(inputFileName))) {
      while (scanner.hasNextLine()) {
        checkEachLine(instance, scanner);
      }
    } catch (final Exception ex) {
      log.error("error in accessing the file ", ex);
    }

    return displayResult(instance);
  }
}
