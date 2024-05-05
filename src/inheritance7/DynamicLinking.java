package inheritance7;

// Класс-родитель
class Animal {

  // Метод, который будет переопределен в подклассах
  void makeSound() {
    System.out.println("Животное издает звук");
  }
}

// Потомок-собака
class Dog extends Animal {

  // Переопределение метода makeSound() для собаки
  @Override
  void makeSound() {
    System.out.println("Собака лает: Гав-гав!");
  }
}

// Потомок-кот
class Cat extends Animal {

  // Переопределение метода makeSound() для кота
  @Override
  void makeSound() {
    System.out.println("Кошка мяукает: Мяу-мяу!");
  }
}

public class DynamicLinking {

  public static void main(String[] args) {
    // Создаем объекты потомков с типом родителя
    Animal dog = new Dog();
    Animal cat = new Cat();

    // Динамическое связывание:
    dog.makeSound(); // Вызов метод makeSound() класса Dog у типа Animal

    // Динамическое связывание:
    cat.makeSound(); // Вызов метод makeSound() класса Cat у типа Animal
  }
}
