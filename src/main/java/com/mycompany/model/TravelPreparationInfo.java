package com.mycompany.model;

public class TravelPreparationInfo {
  private int timeInMinutes;
  private String travelMode;

  private TravelPreparationInfo() {}

  public TravelPreparationInfo(final int timeInMinutes, final String travelMode) {
    this();
    this.timeInMinutes = timeInMinutes;
    this.travelMode = travelMode;
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();

    builder.append("TravelPreparationInfo [timeInMinutes=");
    builder.append(timeInMinutes);
    builder.append(", ");

    if (travelMode != null) {
      builder.append("travelMode=");
      builder.append(travelMode);
    }

    builder.append("]");

    return builder.toString();
  }

  public int getTimeInMinutes() {
    return timeInMinutes;
  }

  public String getTravelMode() {
    return travelMode;
  }
}
