import java.util.Scanner;

/**
 * 	创建一个自定义异常类"InvalidAgeException"，当年龄不在0-120范围内时抛出该异常。
 * 	编写一个方法验证年龄，并在main方法中进行测试。
 */

public class Exceptiondemo {
     public static void CheckAge(int age) throws InvalidAgeException {
         if (age<0||age>120){
             throw new InvalidAgeException(age);
         }
         System.out.println("年龄合法"+age);
     }

     public static void main(String[] args){
         System.out.println("请输入你的年龄：");
         Scanner sc=new Scanner(System.in);
         int testage=sc.nextInt();
         try{
             CheckAge(testage);
         }catch (InvalidAgeException e){
             System.out.println("捕获：" + e.getMessage());
         }
     }

}
