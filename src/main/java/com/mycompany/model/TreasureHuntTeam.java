package com.mycompany.model;

public class TreasureHuntTeam {
  private static final TreasureHuntTeam INSTANCE = new TreasureHuntTeam();
  private float positionX;
  private float positionY;

  private TreasureHuntTeam() {}

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

  public static final TreasureHuntTeam getInstance() {
    return INSTANCE;
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
