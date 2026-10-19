public class text {
    public static void main(String[] args) {
        animal dog=new Dog("旺财",2);
        animal cat=new Cat("小欢",3);

        dog.makeSound();
        cat.makeSound();

        if (dog instanceof Dog d){
            d.findball();
        }
        if (cat instanceof Cat c){
            c.catchfish();
        }
    }
}
