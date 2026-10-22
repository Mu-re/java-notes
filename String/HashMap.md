### HashMap
##### 创建
~~~ 
Map<Character, Integer> map = new HashMap<>();
~~~

* 泛型 <Character, Integer>：key 是字符，value 是次数。

##### 改
~~~
map.put('a', 1);   // 新增
map.put('a', 5);   // key 已存在 → 覆盖旧值，返回旧值 1
~~~

##### 查
~~~
map.get('a');                    // 有则返回值，没有返回 null
map.getOrDefault('a', 0);        // 没有则返回默认值 0（题目可替换）
~~~
* 为什么用 getOrDefault？ 因为 get 返回 Integer（包装类），如果是 null 直接做 +1 会 NullPointerException。getOrDefault 完美规避。

##### 判断
~~~ 
map.containsKey('a');      // 是否包含 key（最常用）
map.containsValue(3);      // 是否包含 value（很少用，O(n)）
~~~

##### 删除
~~~
map.remove('a');           // 按 key 删除，返回被删的 value
~~~

##### 大小
~~~
map.size();                // 键值对个数
map.isEmpty();             // 是否为空
~~~

##### 遍历
~~~
// 方式1：entrySet —— 最常用，一次拿到 key 和 value
for (Map.Entry<Character, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// 方式2：keySet —— 只要 key，再 get value（效率略低，get 要再查一次）
for (Character key : map.keySet()) {
    System.out.println(key + " = " + map.get(key));
}

// 方式3：values —— 只要所有 value
for (Integer v : map.values()) {
    System.out.println(v);
}
~~~

* "Map.Entry<Character,Integer> 是声明 List 里装的是『字符→次数』的键值对类型；
* CountMap.entrySet() 从 Map 里取出所有键值对组成一个 Set；new ArrayList<>(...) 再把这个 Set 转成 List，这样才能调用 sort() 排序。"
* Map.Entry是类型的意思