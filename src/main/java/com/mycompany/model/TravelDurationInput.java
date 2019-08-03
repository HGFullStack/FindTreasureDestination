package com.mycompany.model;

public class TravelDurationInput {
  private boolean hourPresent;
  private boolean minPresent;
  private String travelDuration;

  private TravelDurationInput() {}

  public TravelDurationInput(
      final boolean hour_present, final boolean min_present, final String travelDuration) {
    this();
    hourPresent = hour_present;
    minPresent = min_present;
    this.travelDuration = travelDuration;
  }

  public boolean isHourPresent() {
    return hourPresent;
  }

  public boolean isMinPresent() {
    return minPresent;
  }

  public String getTravelDuration() {
    return travelDuration;
  }

  public void setTravelDuration(final String travelDuration) {
    this.travelDuration = travelDuration;
  }
}
