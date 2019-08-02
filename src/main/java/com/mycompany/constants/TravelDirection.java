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

  private final String direction;

  private TravelDirection(final String direction) {
    this.direction = direction;
  }

  public String getDirection() {
    return direction;
  }

  public static final List<TravelDirection> getValues() {
    return Arrays.asList(values());
  }
}
