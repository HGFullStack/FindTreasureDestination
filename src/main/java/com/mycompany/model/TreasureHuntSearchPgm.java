package com.mycompany.model;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mycompany.constants.Constants;
import com.mycompany.constants.TravelModesAndSpeeds;
import com.mycompany.process.TeamMovementProcess;

public class TreasureHuntSearchPgm {
  private static final Logger log = LogManager.getLogger(TreasureHuntSearchPgm.class);

  public static void main(final String[] args) {
    Scanner scanner = null;

    try {
      scanner = new Scanner(InputCommandsFileLoader.getReadingsInputFile());

      final TreasureHuntTeam instance = TreasureHuntTeam.getInstance();

      while (scanner.hasNextLine()) {
        try {
          final String line = scanner.nextLine();
          final String[] splitArr = line.split(Constants.COMMA);
          int speed = 0;
          final String travelMode =
              splitArr[0]
                  .trim()
                  .replaceAll(Constants.SINGLE_SPACE, Constants.UNDERSCORE)
                  .toUpperCase();
          String travelDuration =
              splitArr[1].trim().replaceAll(Constants.SINGLE_SPACE, Constants.EMPTY).toLowerCase();
          final String travelDirection = splitArr[2].trim().toUpperCase();

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

          boolean hour_present = false;

          if (travelDuration.contains(Constants.HOUR_LOWER_CASE_KEYWORD_PLURAL)) {
            travelDuration =
                travelDuration.replaceAll(
                    Constants.HOUR_LOWER_CASE_KEYWORD_PLURAL, Constants.COMMA);
            hour_present = true;
          }

          if (travelDuration.contains(Constants.HOUR_LOWER_CASE_KEYWORD_SINGULAR)) {
            travelDuration =
                travelDuration.replaceAll(
                    Constants.HOUR_LOWER_CASE_KEYWORD_SINGULAR, Constants.COMMA);
            hour_present = true;
          }

          boolean min_present = false;

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

          travelDuration = travelDuration.trim();

          int time_in_minutes = 0;

          if (!hour_present) {
            time_in_minutes = Integer.parseInt(travelDuration);
          } else {
            if (!min_present) {
              travelDuration = travelDuration.concat(Constants.APPENDING_ZERO);
            }

            final String[] splitTime = travelDuration.split(Constants.COMMA);

            time_in_minutes = Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
          }

          TeamMovementProcess.advance(instance, speed, travelDirection, time_in_minutes);
        } catch (final Exception ex) {
          log.error("error in parsing the file", ex);
        }
      }

      System.out.println("instance" + instance);
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
  }
}
