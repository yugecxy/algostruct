package xiaoyu.algostruct;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
        Collections.shuffle(list);
        System.out.println(list);
    }
}
