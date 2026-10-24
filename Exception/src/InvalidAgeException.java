public class InvalidAgeException extends Exception {
     public InvalidAgeException(int age){
         super("年龄不合法"+age);
     }
}

