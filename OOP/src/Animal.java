/**设计一个"动物"抽象类，包含名称和年龄属性，以及一个抽象方法"makeSound"。
 * 创建"狗"和"猫"两个具体子类，分别实现"makeSound"方法，并添加各自特有的方法。
 * 最后创建测试类，创建不同动物对象并调用方法。
 */

abstract class animal{
     private String name;
     private int age;

     public abstract void makeSound();

    public animal(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class Dog extends animal{
    public Dog(String name,int age){
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(this.getName()+"汪汪");
    }

    public void findball(){
        System.out.println(this.getName()+"正在找球");
    }
}


class Cat extends animal{
    public Cat(String name,int age){
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(this.getName()+"喵喵");
    }

    public void catchfish(){
        System.out.println(this.getName()+"正在抓鱼");
    }
}

