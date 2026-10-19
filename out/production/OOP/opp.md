### 1.为什么抽象类也要构造函数？
* 因为抽象类不能被 new，但它的属性仍然需要初始化，而初始化要靠子类调用它的构造方法完成。

~~~ 
abstract class Animal {
private String name;
    public Animal(String name) {  // 抽象类的构造方法
        this.name = name;
    }
}

class Dog extends Animal {
   public Dog(String name) {
   super(name);  // 子类构造方法第一行调用父类构造方法
   }
}
~~~

* 一句话：抽象类不能实例化 ≠ 抽象类不需要构造方法。构造方法是给子类初始化父类状态用的。

* 补充：即使你不写构造方法，编译器也会给抽象类加一个无参构造方法，供子类 super() 调用。

* ***super(name) = 子类构造方法先调用父类构造方法，完成父类那部分字段的初始化，然后回到子类构造方法继续初始化子类部分。
- 先调用父类，在调用子类

### 2.为什么抽象类也要get(读)/set（写）方法？
* 因为属性通常是 private，封装要求外部和子类只能通过方法访问。

~~~
abstract class Animal {
    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
~~~

* private的私有属性，只能在‘本’内中使用 ，使用get/set可以控制属性是读/写的状态，同时不让随意篡改父类属性。
* ***get/set 不是“不让你改”，而是“不让你绕过规则直接改”；修改必须经过方法，方法里可以加校验和业务逻辑。

### 3.为什么抽象方法前面要加修饰符？
* 抽象方法可以加 public、protected，不能加 private（方法子类看不见，不能重写）、static（属于类，不参与多态，不能被重写）、final（禁止重写）。
- 抽象方法的修饰符要保证“子类看得见、能重写、能多态调用”
* ***public 表示“公开可见”，任何包都能访问；它不是给对象临时加权限，而是在声明时把可见范围放到最大。

### 4.为什么构造方法里面要写this.name=name？
~~~ 
public Animal(String name) {
    this.name = name;
}
~~~

* 区分成员变量和参数
- 左边 this.name：当前对象的成员变量；
- 右边 name：构造方法的参数；
- this 表示“当前对象”。

如果不写 this：
~~~ 
public Animal(String name) {
    name = name;  // 两个 name 都是参数，自己赋值给自己，成员变量没变
}
~~~

### 5.this，static,
1. this当前对象的引用 
* 关键点：this 属于对象，静态方法里没有 this
2. static属于类，不属于对象
* static 修饰的成员在类加载时就存在，所有对象共享一份，用 类名.成员 访问。


|对比项|实例成员|静态成员|
| ---- | ---- | ---- |
|归属|对象|类|
|内存|每个对象一份|全类一份|
|访问方式|对象.成员|类名.成员|
|能否用 this|✅ 可以|❌ 不可以|
|生命周期|对象创建到销毁|类加载到程序结束|

关键规则：

1. 静态方法不能直接访问实例变量和实例方法（因为没有 this）；
2. 实例方法可以访问静态成员；
3. static 方法不能被重写，只能被隐藏；
4. 工具方法常用 static，如 Math.max()、Collections.sort()。



