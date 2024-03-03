package inheritance;

// Пример композиции
public class CompositionAnimal {

  // Тип животного не может существовать отдельно от класса Животного
  AnimalType animalType;

}

class AnimalType {}

class CompositionCat extends AnimalType {}

class CompositionDog extends AnimalType {}