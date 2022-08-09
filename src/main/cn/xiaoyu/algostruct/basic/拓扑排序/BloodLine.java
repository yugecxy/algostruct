package xiaoyu.algostruct.basic.拓扑排序;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class TreeNode {
    String code;
    List<TreeNode> prevs;

    public TreeNode(String code, List<TreeNode> prevs) {
        this.code = code;
        this.prevs = prevs;
    }
}

public class BloodLine {
    private List<Edge> edges;
    private List<Node> nodes;
    public HashMap<String, List<String>> reverseDag = new HashMap<>();
    public Set<String> noLeafs = new HashSet<>();

    public BloodLine(List<Edge> edges, List<Node> nodes) {
        this.edges = edges;
        this.nodes = nodes;
        //构建邻接表
        for (Edge edge : edges) {
            if (reverseDag.containsKey(edge.nextCode)) {
                reverseDag.get(edge.nextCode).add(edge.prevCode);
            } else {
                reverseDag.put(edge.nextCode, new LinkedList<String>() {{
                    add(edge.prevCode);
                }});
            }
            noLeafs.add(edge.prevCode);
        }
    }

    public List<TreeNode> buildLine() {
        //找到出度为0的节点
        List<String> leafs = nodes.stream().map(n -> n.code).filter(code -> !noLeafs.contains(code)).collect(Collectors.toList());
        return leafs.stream().map(this::dfs).collect(Collectors.toList());
    }

    public TreeNode dfs(String leafCode) {
        if (!reverseDag.containsKey(leafCode)) {
            return new TreeNode(leafCode, null);
        }
        List<TreeNode> prevs = reverseDag.get(leafCode).stream().map(this::dfs).collect(Collectors.toList());
        return new TreeNode(leafCode, prevs);
    }

    public static void main(String[] args) {
        List<Edge> edges = new LinkedList<Edge>() {{
            add(new Edge("a", "c"));
            add(new Edge("b", "c"));
            add(new Edge("c", "d"));
            add(new Edge("e", "f"));
        }};
        List<Node> nodes = new LinkedList<Node>() {{
            add(new Node("a"));
            add(new Node("b"));
            add(new Node("c"));
            add(new Node("d"));
            add(new Node("e"));
            add(new Node("f"));
        }};
        BloodLine line = new BloodLine(edges, nodes);
        List<TreeNode> leafs = line.buildLine();
        System.out.println(111);
    }
}
