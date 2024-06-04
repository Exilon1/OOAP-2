package inheritance13;

public class OneA {

  public void method() {
    System.out.println("Public method in class OneA");
  }
}

class OneB extends OneA {

  @Override
  public void method() {
    System.out.println("Public method in class OneB");
  }
}