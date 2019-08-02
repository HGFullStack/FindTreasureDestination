package com.mycompany.model;

public class TravelDurationInput {
  private boolean hour_present;
  private boolean min_present;
  private String travelDuration;

  private TravelDurationInput() {}

  public TravelDurationInput(
      final boolean hour_present, final boolean min_present, final String travelDuration) {
    this();
    this.hour_present = hour_present;
    this.min_present = min_present;
    this.travelDuration = travelDuration;
  }

  public boolean isHour_present() {
    return hour_present;
  }

  public void setHour_present(final boolean hour_present) {
    this.hour_present = hour_present;
  }

  public boolean isMin_present() {
    return min_present;
  }

  public void setMin_present(final boolean min_present) {
    this.min_present = min_present;
  }

  public String getTravelDuration() {
    return travelDuration;
  }

  public void setTravelDuration(final String travelDuration) {
    this.travelDuration = travelDuration;
  }
}
