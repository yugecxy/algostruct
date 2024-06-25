package xiaoyu.algostruct.practice;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 8 7 5
 * 8 5 3
 * 7 6 3
 * 7 5 2
 * 7 4 1
 */
public class MockMulti {
    public void t() {
        //主键、唯一、普通、联合
        List<String> strings = new LinkedList<>();
        strings.add("7 6");
        strings.add("8 7");
        strings.add("6 7");
        strings.add("7 8");
        strings.add("5 8");
        strings.add("8 5");
        strings.add("7 4");
        strings.add("4 7");
        Collections.shuffle(strings);
        System.out.println(String.join("\n", strings));
    }

    public static void main(String[] args) {
        new MockMulti().t();
    }
}
