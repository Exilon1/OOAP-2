package inheritance13;

public class FourA {

  protected void method() {
    System.out.println("Protected method in class FourA");
  }
}

class FourB extends FourA {

  protected void method() {
    System.out.println("Protected method in class FourB");
  }
}