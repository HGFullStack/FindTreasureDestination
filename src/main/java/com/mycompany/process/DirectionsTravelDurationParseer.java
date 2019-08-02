package com.mycompany.process;

import com.mycompany.constants.Constants;
import com.mycompany.model.TravelDurationInput;

public class DirectionsTravelDurationParseer {
  private DirectionsTravelDurationParseer() {}

  public static TravelDurationInput getTravelDurationParameters(String travelDuration) {
    boolean hour_present = false;
    boolean min_present = false;

    if (travelDuration.contains(Constants.HOUR_LOWER_CASE_KEYWORD_PLURAL)) {
      travelDuration =
          travelDuration.replaceAll(Constants.HOUR_LOWER_CASE_KEYWORD_PLURAL, Constants.COMMA);
      hour_present = true;
    }

    if (travelDuration.contains(Constants.HOUR_LOWER_CASE_KEYWORD_SINGULAR)) {
      travelDuration =
          travelDuration.replaceAll(Constants.HOUR_LOWER_CASE_KEYWORD_SINGULAR, Constants.COMMA);
      hour_present = true;
    }

    if (travelDuration.contains(Constants.MINUTES_LOWER_CASE_KEYWORD_PLURAL)) {
      travelDuration =
          travelDuration.replaceAll(
              Constants.MINUTES_LOWER_CASE_KEYWORD_PLURAL, Constants.SINGLE_SPACE);
      min_present = true;
    }

    if (travelDuration.contains(Constants.MINUTES_LOWER_CASE_KEYWORD_SINGULAR)) {
      travelDuration =
          travelDuration.replaceAll(
              Constants.MINUTES_LOWER_CASE_KEYWORD_SINGULAR, Constants.SINGLE_SPACE);
      min_present = true;
    }

    return new TravelDurationInput(hour_present, min_present, travelDuration);
  }
}
