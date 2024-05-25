package inheritance9;

public class AnyLogic extends Any {

  @Override
  public String toString() {
    return "AnyLogic.class";
  }
}

// Отсутствует множественное наследование, но можно финализировать любого потомка, сделав конечным
// в иерархии.
final class None extends AnyLogic {

  @Override
  public String toString() {
    return "None.class";
  }
}

class UseAnyLogic {

  public static void main(String[] args) {
    General anyLogic = new AnyLogic();
    General none = new None();

    General general = none;

    System.out.println("AnyLogic.toString() = " + anyLogic);
    System.out.println("None.toString() = " + none);
    System.out.println("Some general is instanceof AnyLogic = " + (general instanceof AnyLogic));
    System.out.println("Some general is instanceof None = " + (general instanceof None));
  }
}
