package inheritance21;

public class Vehicle {
  private String make;
  private String model;
  private int year;

  public Vehicle(String make, String model, int year) {
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public void startEngine() {
    System.out.println("Engine started");
  }

  public void stopEngine() {
    System.out.println("Engine stopped");
  }

  public void displayInfo() {
    System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
  }
}

// Класс-наследник
class Car extends Vehicle {
  private int numberOfDoors;

  public Car(String make, String model, int year, int numberOfDoors) {
    super(make, model, year);
    this.numberOfDoors = numberOfDoors;
  }

  public void honk() {
    System.out.println("Honking the car horn");
  }

  @Override
  public void displayInfo() {
    // использование реализации предка
    super.displayInfo();
    System.out.println("Number of doors: " + numberOfDoors);
  }
}