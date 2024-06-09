package inheritance14;

import java.util.Arrays;

// Базовый класс General, от которого будут наследоваться все типы T
public abstract class General<T> {

  public abstract T add(T other);
}

// Наследник от General
class IntegerGeneral extends General<IntegerGeneral> {
  private final int value;

  public IntegerGeneral(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public IntegerGeneral add(IntegerGeneral other) {
    return new IntegerGeneral(this.value + other.value);
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}

// Класс Vector<T>
class Vector<T extends General<T>> extends General<Vector<T>> {
  private final T[] elements;

  @SuppressWarnings("unchecked")
  public Vector(T... elements) {
    this.elements = elements;
  }

  public T[] getElements() {
    return elements;
  }

  // Метод для сложения двух векторов
  @Override
  public Vector<T> add(Vector<T> other) {
    if (this.elements.length != other.elements.length) {
      return null;
    }

    T[] result = Arrays.copyOf(this.elements, this.elements.length);

    for (int i = 0; i < this.elements.length; i++) {
      result[i] = this.elements[i].add(other.elements[i]);
    }

    return new Vector<>(result);
  }

  @Override
  public String toString() {
    return Arrays.toString(elements);
  }

  // Тестовый метод main
  public static void main(String[] args) {
    // Пример работы с вложенными векторами

    // Создаем вектора с IntegerGeneral
    IntegerGeneral ig1 = new IntegerGeneral(1);
    IntegerGeneral ig2 = new IntegerGeneral(2);
    IntegerGeneral ig3 = new IntegerGeneral(3);
    IntegerGeneral ig4 = new IntegerGeneral(4);
    IntegerGeneral ig5 = new IntegerGeneral(5);
    IntegerGeneral ig6 = new IntegerGeneral(6);

    // Векторы первого уровня
    Vector<IntegerGeneral> v1 = new Vector<>(ig1, ig2);
    Vector<IntegerGeneral> v2 = new Vector<>(ig3, ig4);
    Vector<IntegerGeneral> v3 = new Vector<>(ig5, ig6);

    // Векторы второго уровня
    Vector<Vector<IntegerGeneral>> vv1 = new Vector<>(v1, v2);
    Vector<Vector<IntegerGeneral>> vv2 = new Vector<>(v2, v3);

    // Вектор третьего уровня
    Vector<Vector<Vector<IntegerGeneral>>> vvv1 = new Vector<>(vv1);
    Vector<Vector<Vector<IntegerGeneral>>> vvv2 = new Vector<>(vv2);

    // Складываем векторы третьего уровня
    Vector<Vector<Vector<IntegerGeneral>>> result = vvv1.add(vvv2);

    if (result != null) {
      System.out.println("Result vector: " + result);
    } else {
      System.out.println("Vectors have different lengths.");
    }
  }
}