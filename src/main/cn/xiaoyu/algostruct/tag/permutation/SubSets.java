package xiaoyu.algostruct.tag.permutation;

import java.util.LinkedList;
import java.util.List;

public class SubSets {
    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> getAllSub(List<Integer> input) {
        dfs(input, new LinkedList<>(), 0);
        return ret;
    }

    public void dfs(List<Integer> input, List<Integer> trace, int step) {
        if (step == input.size()) {
            ret.add(trace);
            return;
        }
        for (int i = step; i < input.size(); i++) {
            trace.add(input.get(i));
            dfs(input, trace, i + 1);
            trace.remove(trace.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> input = new LinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<List<Integer>> ret = new SubSets().getAllSub(input);
        System.out.println(111);
    }
}

