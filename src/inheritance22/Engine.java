package inheritance22;

// Здесь классы с отношением ia-a: Engine -> ElectricalEngine, Vehicle -> Car, ElectricalCar
// классы с отношением has-a: Vehicle -> Engine
// Классы Engine и Vehicle являются фундаментальными, подразумевается из активное комбинирование,
// Vehicle точно нельзя наследовать от Engine, потому что, кроме Engine, Vehicle содержит другие
// немаловажные свойства.

public class Engine {

  public void start() {
    System.out.println("Engine started");
  }

  public void stop() {
    System.out.println("Engine stopped");
  }
}

class ElectricalEngine extends Engine {
  public void start() {
    System.out.println("Power supply on");
  }

  public void stop() {
    System.out.println("Power supply off");
  }
}

class Vehicle {
  private Engine engine;

  public Vehicle(Engine engine) {
    this.engine = engine;
  }

  public void startEngine() {
    engine.start();
  }

  public void stopEngine() {
    engine.stop();
  }

  public Engine getEngine() {
    return engine;
  }

  public void displayInfo() {
    System.out.println("Vehicle with engine type: " + engine.toString());
  }
}

class Car extends Vehicle {

  public Car(Engine engine) {
    super(engine);
  }
}

class ElectricalCar extends Vehicle {

  public ElectricalCar(Engine engine) {
    super(engine);
  }
}

class Main {
  public static void main(String[] args) {
    Engine carEngine = new Engine();
    Engine electricalEngine = new ElectricalEngine();

    Car car = new Car(carEngine);
    ElectricalCar electricalCar = new ElectricalCar(electricalEngine);

    car.startEngine();
    car.displayInfo();
    car.stopEngine();

    System.out.println();

    electricalCar.startEngine();
    electricalCar.displayInfo();
    electricalCar.stopEngine();
  }
}