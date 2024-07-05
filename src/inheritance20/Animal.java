package inheritance20;

interface Breathable {

  void takeABreath();
}

public abstract class Animal implements Breathable {

  public abstract void sleep();

  public void makeSound(String sound) {
    System.out.println(sound);
  }

  // Метод, который будет переопределен (overridden) в подклассе
  public void eat() {
    System.out.println("Animal is eating");
  }
}

// Подкласс Dog, наследуется от Animal
class Dog extends Animal {

  // Вариация типа
  public void makeSound(int times) {
    for (int i = 0; i < times; i++) {
      System.out.println("Bark");
    }
  }

  // Функциональная вариация
  @Override
  public void eat() {
    System.out.println("Dog is eating");
  }

  // Наследование с конкретизацией
  public void sleep() {
    System.out.println("I'm sleeping");
  }

  // Структурное наследование
  @Override
  public void takeABreath() {
    System.out.println("Good oxygen!");
  }
}
