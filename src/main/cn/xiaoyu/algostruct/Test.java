package xiaoyu.algostruct;

import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(2,2);
        map.put(1,1);
        map.put(3,3);
        map.get(3);
        map.entrySet().forEach(t->{
            System.out.print(t.getValue());
        });
    }
}
