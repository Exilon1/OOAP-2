package inheritance;

// Пример множественного наследования (is a)
public class InheritanceAnimal {}

class InheritanceCat extends InheritanceAnimal implements FourLegged, OxygenBreather {

  // Содержит поведение, присущее четырёхлапым
  @Override
  public void run(int miles) {
    // implementation
  }

  // Содержит поведение, присущее дышащим кислородом
  @Override
  public void breath() {
    // implementation
  }
}

interface FourLegged {

  void run(int miles);
}

interface OxygenBreather {

  void breath();
}
