package inheritance2;

public class Shape {

  public void draw(int color) {}

}

// специализация класса-родителя посредством перегрузки родительского метода с новой
// функциональностью рисования исключительно окружностей
class Circle extends Shape {
  public void draw(int color, int radius) {}
}