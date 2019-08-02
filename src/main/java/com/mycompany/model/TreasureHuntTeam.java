package com.mycompany.model;

import java.util.Objects;

public class TreasureHuntTeam {
  private float positionX;
  private float positionY;

  public TreasureHuntTeam() {}

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;

    if (!(obj instanceof TreasureHuntTeam)) return false;

    final TreasureHuntTeam other = (TreasureHuntTeam) obj;

    return Float.floatToIntBits(positionX) == Float.floatToIntBits(other.positionX)
        && Float.floatToIntBits(positionY) == Float.floatToIntBits(other.positionY);
  }

  @Override
  public int hashCode() {
    return Objects.hash(positionX, positionY);
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();

    builder.append("TreasureHuntTeam [positionX=");
    builder.append(positionX);
    builder.append(", positionY=");
    builder.append(positionY);
    builder.append("]");

    return builder.toString();
  }

  public float getPositionX() {
    return positionX;
  }

  public void setPositionX(final float positionX) {
    this.positionX = positionX;
  }

  public float getPositionY() {
    return positionY;
  }

  public void setPositionY(final float positionY) {
    this.positionY = positionY;
  }
}
