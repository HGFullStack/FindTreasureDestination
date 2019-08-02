package com.mycompany.constants;

import java.util.Arrays;
import java.util.List;

public enum TravelDirection {
  NE("NE"),
  NW("NW"),
  SE("SE"),
  SW("SW"),
  N("N"),
  E("E"),
  W("W"),
  S("S");

  private final String travelDirection;

  private TravelDirection(final String travelDirection) {
    this.travelDirection = travelDirection;
  }

  public String getTravelDirection() {
    return travelDirection;
  }

  public static final List<TravelDirection> getValues() {
    return Arrays.asList(values());
  }
}
