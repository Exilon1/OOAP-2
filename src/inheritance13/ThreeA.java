package inheritance13;

public class ThreeA {

  private void method() {
    System.out.println("Private method in class ThreeA");
  }
}

class ThreeB extends ThreeA {

  public void method() {
    System.out.println("Public method in class ThreeB");
  }
}
