package ru.boshyn.idiot.controllers;

public class CurrentStep {

  public void firstMove(Game game) {
    //заход текущего игрока под кроющегося
  }

  public boolean throwUp(Game game) {
    // подкидывание карт под кроющегося
    return false;
  }

  public boolean cover(Game game) {
    // крыть карты
    return false;
  }

  public boolean getLose(Game game) {
    // забрать карты с кона если не может покрыть
    return false;
  }

  public void hangUp(Game game) {
    // отбой если отбился
  }

  public int changeCurrentPlayer(Game game) {
    return null;
  }
}
