package inheritance9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.Set;

public class General implements Serializable {

  public <T extends General> void deepCopy(T target, T source) {
    Class<?> sourceClass = source.getClass();
    Class<?> targetClass = target.getClass();
    Field[] sourceFields = sourceClass.getDeclaredFields();

    for (Field sourceField : sourceFields) {
      sourceField.setAccessible(true);
      try {
        Field targetField = targetClass.getDeclaredField(sourceField.getName());
        targetField.setAccessible(true);

        try {
          General targetValue = (General) targetField.get(target);
          deepCopy(targetValue, (General) sourceField.get(source));
        } catch (NullPointerException np) {
          targetField.set(target, sourceField.get(source));
        }
      } catch (Exception e) {
        throw new RuntimeException("Deep copy failed by reason: " + e.getMessage());
      }
    }
  }

  public <T extends General> T deepClone() {
    try (ByteArrayOutputStream baOS = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baOS);
        ObjectInputStream ois = new ObjectInputStream(
            new ByteArrayInputStream(baOS.toByteArray()))) {

      oos.writeObject(this);

      @SuppressWarnings("unchecked")
      T copy = (T) ois.readObject();

      return copy;
    } catch (Exception e) {
      throw new RuntimeException("Deep clone failed by reason: " + e.getMessage());
    }
  }

  public boolean equals(General obj) {
    if (super.equals(obj)) {
      return true;
    }

    Class<?> firstClass = this.getClass();
    Class<?> secondClass = obj.getClass();
    Field[] firstClassFields = firstClass.getDeclaredFields();
    Field[] secondClassFields = secondClass.getDeclaredFields();

    if (!Set.of(firstClassFields).equals(Set.of(secondClassFields))) {
      return false;
    }

    for (Field firstClassField : firstClassFields) {
      firstClassField.setAccessible(true);
      try {
        Field secondClassField = secondClass.getDeclaredField(firstClassField.getName());
        secondClassField.setAccessible(true);

        General firstClassValue = (General) firstClassField.get(this);
        General secondClassValue = (General) firstClassField.get(obj);

        if (!firstClassValue.equals(secondClassValue)) {
          return false;
        }
      } catch (NoSuchFieldException | IllegalAccessException e) {
        throw new RuntimeException("Equals method failed by reason: " + e.getMessage());
      }
    }

    return true;
  }

  @Override
  public String toString() {
    return super.toString();
  }

  public String serializeToString() {
    try (ByteArrayOutputStream baOS = new ByteArrayOutputStream();
        ObjectOutputStream oOS = new ObjectOutputStream(baOS)) {

      oOS.writeObject(this);
      return Base64.getEncoder().encodeToString(baOS.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("Serialization failed by reason: " + e.getMessage());
    }
  }

  public static General deserializeFromString(String str) {
    byte[] data = Base64.getDecoder().decode(str);

    try (ObjectInputStream oIS = new ObjectInputStream(new ByteArrayInputStream(data))) {
      return (General) oIS.readObject();
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException("Deserialization failed by reason: " + e.getMessage());
    }
  }

  public boolean isInstance(Class<?> clazz) {
    return clazz.isInstance(this);
  }

  public Class<?> getGenelalClass() {
    return super.getClass();
  }
}
