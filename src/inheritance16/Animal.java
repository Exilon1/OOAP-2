package inheritance16;

public class Animal {

  public void makeSound() {
    System.out.println("Animal makes a sound");
  }

  public Animal getAnimal() {
    return new Animal();
  }
}

class Dog extends Animal {

  @Override
  public void makeSound() {
    System.out.println("Dog barks");
  }

  @Override
  public Dog getAnimal() {
    return new Dog();
  }
}

class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();
    Animal myDog = new Dog();

    // Полиморфный вызов метода makeSound()
    myAnimal.makeSound(); // Output: Animal makes a sound
    myDog.makeSound();    // Output: Dog barks

    // Ковариантный вызов метода getAnimal()
    Dog newDod = new Dog();
    Animal newAnimal = newDod.getAnimal();

    System.out.println(newAnimal instanceof Dog); // Output: true
  }
}
