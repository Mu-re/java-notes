import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**创建一个泛型方法，接收一个List集合和一个元素，将元素插入到集合的指定位置。
*然后创建一个包含不同类型元素的List，使用该方法插入新元素并遍历打印。
*/

public class list{

    public static <T> void insert(List<T> list, int index, T element){
        if (index<0||index>list.size()){
            throw new IndexOutOfBoundsException( "索引越界: index=" + index + ", size=" + list.size());
        }
        list.add(index,element);
    }

    public static void prints(List<?> list){
        for(Object items:list){
            System.out.println(items);
        }
        System.out.println(list);
    }

    public static void main(String[] args){
        List<String> stringList=new ArrayList<>();
        List<Integer> integers=new ArrayList<>();
        List<Boolean> booleans=new ArrayList<>();

        //初始化
        Collections.addAll(stringList,"Java", "Python", "C++");
        Collections.addAll(integers,1,2,3,4,5,6);
        Collections.addAll(booleans,false,true,false,true);

        insert(stringList,2,"hello");
        insert(integers,3,1);
        insert(booleans,1,false);

        prints(stringList);
        prints(integers);
        prints(booleans);

    }
}