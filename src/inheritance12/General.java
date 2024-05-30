package inheritance12;

import java.io.Serializable;

class General implements Serializable {

  public General tryAssign(General source) {
    if (this.getClass().isAssignableFrom(source.getClass())) {
      return source;
    } else {
      return new None();
    }
  }
}

class Any extends General {

  @Override
  public Any tryAssign(General source) {
    if (source instanceof Any) {
      return (Any) source;
    } else {
      return new None();
    }
  }
}

final class None extends Any {
}

class Main {
  public static void main(String[] args) {
    General general = new General();
    Any any = new Any();
    None none = new None();

    // Примеры использования tryAssign
    General result1 = general.tryAssign(any);  // Вернет Any, так как Any является потомком General
    General result2 = general.tryAssign(none); // Вернет None, так как None является потомком General

    Any result3 = any.tryAssign(general); // Вернет None, так как General не является потомком Any
    Any result4 = any.tryAssign(any);     // Вернет Any, так как Any является потомком Any
    Any result5 = any.tryAssign(none);    // Вернет None, так как None является потомком Any

    System.out.println(result1.getClass().getSimpleName());
    System.out.println(result2.getClass().getSimpleName());
    System.out.println(result3.getClass().getSimpleName());
    System.out.println(result4.getClass().getSimpleName());
    System.out.println(result5.getClass().getSimpleName());
  }
}