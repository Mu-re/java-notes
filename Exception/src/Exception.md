### Exception
* exception(异常相当于一个特殊的类)

#### 1.方法签名上的 throws 是固定这样写吗？它是什么意思？
~~~
public static void CheckAge(int age) throws InvalidAgeException
~~~
~~~
throws InvalidAgeException 读作："我这个方法在执行过程中，有可能抛出 InvalidAgeException 类型的异常，调用我的人请做好准备。"

它是方法签名的一部分，写在参数列表 ) 之后、方法体 { 之前。

它不产生异常，只是"声明/预告"。

真正抛异常的是方法体里的 throw new InvalidAgeException(age);。
~~~

#### 2.为什么定义了异常还要 try-catch，不直接抛出？
* 答案是：throw 和 catch 是两个不同角色的动作，不能互相替代。
* throw 是"扔"，catch 是"接"

##### 为什么不"直接抛出"就完事？
你问的"直接抛出"，其实已经发生了——throw 就是抛出。但抛出去之后总得有人接，否则程序就崩了。main 是程序的入口，是最后一站，所以它必须处理：

* 类比：throw 是"报警"，catch 是"出警处理"。只报警没人接，社会就乱了（程序崩）。所以两者配合使用。