package com.mycompany.constants;

import java.util.Arrays;
import java.util.List;

public enum TravelModesAndSpeeds {
  WALK("WALK", 3),
  RUN("RUN", 6),
  HORSE_TROT("HORSE_TROT", 4),
  HORSE_GALLOP("HORSE_GALLOP", 15),
  ELEPHANT_RIDE("ELEPHANT_RIDE", 6);

  private final String travelMode;
  private final int travelSpeed;

  private TravelModesAndSpeeds(final String travelMode, final int travelSpeed) {
    this.travelMode = travelMode;
    this.travelSpeed = travelSpeed;
  }

  public String getTravelMode() {
    return travelMode;
  }

  public int getTravelSpeed() {
    return travelSpeed;
  }

  public static final List<TravelModesAndSpeeds> getValues() {
    return Arrays.asList(values());
  }
}
