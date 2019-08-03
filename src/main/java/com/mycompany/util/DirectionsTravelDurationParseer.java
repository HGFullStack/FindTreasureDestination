package com.mycompany.util;

import com.mycompany.constants.Constants;
import com.mycompany.model.TravelDurationInput;

public class DirectionsTravelDurationParseer {
  private DirectionsTravelDurationParseer() {}

  public static TravelDurationInput getTravelDurationParameters(String travelDuration) {
    boolean hourPresent = false;
    boolean minPresent = false;

    if (travelDuration.contains(Constants.HOUR_LOWER_CASE_KEYWORD_PLURAL)) {
      travelDuration =
          travelDuration.replaceAll(Constants.HOUR_LOWER_CASE_KEYWORD_PLURAL, Constants.COMMA);
      hourPresent = true;
    }

    if (travelDuration.contains(Constants.HOUR_LOWER_CASE_KEYWORD_SINGULAR)) {
      travelDuration =
          travelDuration.replaceAll(Constants.HOUR_LOWER_CASE_KEYWORD_SINGULAR, Constants.COMMA);
      hourPresent = true;
    }

    if (travelDuration.contains(Constants.MINUTES_LOWER_CASE_KEYWORD_PLURAL)) {
      travelDuration =
          travelDuration.replaceAll(
              Constants.MINUTES_LOWER_CASE_KEYWORD_PLURAL, Constants.SINGLE_SPACE);
      minPresent = true;
    }

    if (travelDuration.contains(Constants.MINUTES_LOWER_CASE_KEYWORD_SINGULAR)) {
      travelDuration =
          travelDuration.replaceAll(
              Constants.MINUTES_LOWER_CASE_KEYWORD_SINGULAR, Constants.SINGLE_SPACE);
      minPresent = true;
    }

    return new TravelDurationInput(hourPresent, minPresent, travelDuration);
  }
}
