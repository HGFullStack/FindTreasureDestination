package com.mycompany.util;

import com.mycompany.constants.TravelModesAndSpeeds;

public class DirectionsTravelSpeedParser {
  private DirectionsTravelSpeedParser() {}

  public static int getSpeedFromTravelMode(final String travelMode) {
    int speed = 0;

    switch (TravelModesAndSpeeds.valueOf(travelMode)) {
      case WALK:
        speed = TravelModesAndSpeeds.WALK.getTravelSpeed();

        break;

      case RUN:
        speed = TravelModesAndSpeeds.RUN.getTravelSpeed();

        break;

      case HORSE_TROT:
        speed = TravelModesAndSpeeds.HORSE_TROT.getTravelSpeed();

        break;

      case HORSE_GALLOP:
        speed = TravelModesAndSpeeds.HORSE_GALLOP.getTravelSpeed();

        break;

      case ELEPHANT_RIDE:
        speed = TravelModesAndSpeeds.ELEPHANT_RIDE.getTravelSpeed();

        break;

      default:
        speed = TravelModesAndSpeeds.WALK.getTravelSpeed();

        break;
    }

    return speed;
  }
}
