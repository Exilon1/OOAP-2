package inheritance21;

public class CustomException extends Exception {
  public CustomException(String message) {
    super(message);
  }
}

// Конкретный подкласс для обработки исключения базы данных
class DatabaseException extends CustomException {
  public DatabaseException(String message) {
    super(message);
  }

  public void logError() {
    System.out.println("Logging database error: " + getMessage());
  }
}

// Еще один конкретный подкласс для обработки сетевого исключения
class NetworkException extends CustomException {
  public NetworkException(String message) {
    super(message);
  }

  public void notifyAdmin() {
    System.out.println("Notifying admin about network error: " + getMessage());
  }
}
