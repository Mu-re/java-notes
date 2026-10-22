import java.util.*;



/**
 * 编写一个程序，接收用户输入的字符串，统计其中每个字符出现的次数，并按照出现频率从高到低排序输出结果。
 */


public class StringBuilderDemo {
       public static String StringCount(String str){
           Map<Character,Integer> CountMap=new HashMap<>();
           for(int i=0;i<str.length();i++){
               char s=str.charAt(i);
               if(CountMap.containsKey(s)){
                   CountMap.put(s,CountMap.get(s)+1);
               }else{
                 CountMap.put(s,1);
               }
           }
           //把MAP对象换成LIST方便排序
           List<Map.Entry<Character,Integer>> list=new ArrayList<>(CountMap.entrySet());
           list.sort((e1,e2)-> e2.getValue()- e1.getValue());//降序

           //用StringBulider拼接
           StringBuilder sb=new StringBuilder();
           for(Map.Entry<Character,Integer> entry:list){
               sb.append("'")
                       .append(entry.getKey())
                       .append("' 出现了 ")
                       .append(entry.getValue())
                       .append(" 次\n");
           }

           return sb.toString();

       }

       public static void main(String[] args){
           Scanner sc=new Scanner(System.in);
           System.out.println("请输入字符串");
           String str=sc.nextLine();
           String result=StringCount(str);
           System.out.println("结果如下");
           System.out.println(result);
           sc.close();
       }


}
