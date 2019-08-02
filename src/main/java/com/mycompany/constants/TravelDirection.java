package com.mycompany.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public static final Set<String> getNames() {
    final Set<String> names = new HashSet<>(getValues().size());

    getValues().forEach(str -> names.add(str.name()));

    return names;
  }

  public String getTravelDirection() {
    return travelDirection;
  }

  public static final List<TravelDirection> getValues() {
    return Arrays.asList(values());
  }
}
