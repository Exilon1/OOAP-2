package inheritance;

// Пример полиморфизма
public class PolymorphismAnimal {

  void makeSound() {
    // PolymorphismAnimal implementation
  }
}

class PolymorphismCat extends PolymorphismAnimal {

  // Замещает звук животного звуком, присущим Кошке
  void makeSound() {
    // PolymorphismCat implementation
  }
}

class PolymorphismDog extends PolymorphismAnimal {

  // Замещает звук животного звуком, присущим Собаке
  void makeSound() {
    // PolymorphismDog implementation
  }
}