### 集合泛型
* 泛型把类型也当作参数传递
~~~
// 普通方法：参数是值
void method(String name) { }

// 泛型方法：参数是类型
<T> void method(T name) { }
~~~

* 泛型方法
~~~ 
public static <T> void insert(List<T> list, int index, T element) {
    list.add(index, element);
}
~~~

*  \<T>只是"声明要用 T"，真正调用时 T 会被替换成具体类型。
- 调用 insert(stringList, ...) 时，编译器自动把 T 推断为 String；调用 insert(intList, ...) 时推断为 Integer。

#### \<T> 和 <?> 的区别（重点！）
|写法|含义| 适用场景       |
|----|----|------------|
|List<T>	|明确的类型参数，可读可写	| 要往集合里放元素时用 |
|List<?>|	未知类型，只能读不能写	| 只读遍历时用     |

* 要往里放元素 → 用 <T>；只读遍历 → 用 <?>

#### 初始化集合

|建列表的同时就想填好	|new ArrayList<>(Arrays.asList(...))|
|----|----|
|列表已建好（new 完了），再填内容|	Collections.addAll(list, ...) 或 list.addAll(...)|
|快速造列表|Arrays.asList(...)|

* Arrays.asList 后直接 add 报错。Arrays.asList 返回的是长度固定的列表，不能增删。
