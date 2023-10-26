package xiaoyu.algostruct.tag.permutation;

import java.util.LinkedList;
import java.util.List;

public class SubSets {
    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> getAllSub(List<Integer> input) {
        dfs(input, 0, new LinkedList<>());
        return ret;
    }

    public void dfs(List<Integer> input, int step, List<Integer> cur) {
        if (step == input.size()) {
            ret.add(new LinkedList<>(cur));
            return;
        }
        dfs(input, step + 1, cur);

        cur.add(input.get(step));
        dfs(input, step + 1, cur);
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> input = new LinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<List<Integer>> ret = new SubSets().getAllSub(input);
        System.out.println(ret);
    }
}

