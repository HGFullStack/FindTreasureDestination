package com.mycompany.process;

import com.mycompany.constants.Constants;
import com.mycompany.constants.TravelDirection;
import com.mycompany.model.TravelDurationInput;
import com.mycompany.model.TravelPreparationInfo;
import com.mycompany.model.TreasureHuntTeam;

public class TeamMovementProcess {
  private TeamMovementProcess() {}

  public static void advance(
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

  public static TravelPreparationInfo prepare(final String[] splitArr) {
    final String travelMode =
        splitArr[0].trim().replaceAll(Constants.SINGLE_SPACE, Constants.UNDERSCORE).toUpperCase();
    final TravelDurationInput travelDurationInput =
        DirectionsTravelDurationParseer.getTravelDurationParameters(
            splitArr[1].trim().replaceAll(Constants.SINGLE_SPACE, Constants.EMPTY).toLowerCase());
    String travelDuration = travelDurationInput.getTravelDuration().trim();
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

    return new TravelPreparationInfo(time_in_minutes, travelMode);
  }
}
