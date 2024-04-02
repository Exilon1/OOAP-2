package inheritance2;

public class Square {

  public boolean hasRightAngles() {
    return true;
  }
}

// Расширение класса родителя посредством добавления функциональности изменения размера квадрата
class AdjustableScaleSquare extends Square {

  public void changeScale(int scale) {}
}
