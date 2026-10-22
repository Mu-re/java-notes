### Sttring/StringBulider

#### String和StringBuilder拼接区别

* String
~~~
String s = "";
s += "a";   // 实际发生：s = new String("") + "a" → 创建新对象
s += "b";   // 又创建新对象
s += "c";   // 又创建新对象
~~~
* 每次 += 编译器会转成 StringBuilder 或 String.concat，但循环里每次都新建对象，旧对象变垃圾。

~~~
第1次："" → "a"        （新建1个对象，旧的""变垃圾）
第2次："a" → "ab"      （新建1个对象，"a"变垃圾）
第3次："ab" → "abc"    （新建1个对象，"ab"变垃圾）
总共创建 4 个对象，3 个变垃圾
~~~

* StringBuilder

~~~
StringBuilder sb = new StringBuilder();
sb.append("a");   // 原地追加，返回自己
sb.append("b");   // 原地追加
sb.append("c");   // 原地追加
String s = sb.toString();   // 最后才转成 String
~~~

~~~
创建 1 个 StringBuilder，内部维护一个可变 char 数组
每次 append 往数组里塞字符，不够就扩容（数组翻倍）
全程只有 1 个对象，最后 toString 才生成 String
~~~

#### List排序方法
~~~
List<Map.Entry<Character,Integer>> list = new ArrayList<>(CountMap.entrySet());
list.sort((e1, e2) -> e2.getValue() - e1.getValue());   // 降序
~~~

* e1-e2升序，e2-e1降序