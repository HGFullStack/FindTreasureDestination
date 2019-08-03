package com.mycompany.model;

public class TreasureHuntTeam {
  private float positionX;
  private float positionY;

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
