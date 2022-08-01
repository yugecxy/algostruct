package xiaoyu.algostruct.basic.拓扑排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

class Node {
    String code;

    public Node(String code) {
        this.code = code;
    }
}

class Edge {
    String prevCode;
    String nextCode;

    public Edge(String prevCode, String nextCode) {
        this.prevCode = prevCode;
        this.nextCode = nextCode;
    }
}

class ToPoSort {
    private List<Edge> edges;
    private List<Node> nodes;
    public HashMap<String, List<String>> dag = new HashMap<>();

    public ToPoSort(List<Edge> edges, List<Node> nodes) {
        this.edges = edges;
        this.nodes = nodes;
        //构建邻接表
        for (Edge edge : edges) {
            if (dag.containsKey(edge.prevCode)) {
                dag.get(edge.prevCode).add(edge.nextCode);
            } else {
                dag.put(edge.prevCode, new LinkedList<String>() {{
                    add(edge.nextCode);
                }});
            }
        }
    }

    public List<String> sort() {
        //初始化入度表
        HashMap<String, Long> degreeMap = new HashMap<>();
        nodes.forEach(node -> {
            long cnt = dag.values().stream().filter(c -> c.contains(node.code)).count();
            degreeMap.put(node.code, cnt);
        });

        List<String> ret = new LinkedList<>();
        Set<String> successNodes = new HashSet<>();
        int toShootSize;
        do {
            List<String> toShoot = degreeMap.entrySet().stream()
                    .filter(entry -> !successNodes.contains(entry.getKey()) && entry.getValue() == 0)
                    .map(Entry::getKey)
                    .collect(Collectors.toList());
            toShootSize = toShoot.size();
            toShoot.forEach(code -> {
                successNodes.add(code);
                ret.add(code);
                dag.getOrDefault(code, new ArrayList<>()).forEach(c -> {
                    degreeMap.put(c, degreeMap.get(c) - 1);
                });
            });
        } while (toShootSize != 0);


        return ret;
    }

}

public class Solution {
    public static void main(String[] args) {
        List<Edge> edges = new LinkedList<Edge>() {{
            add(new Edge("a", "b"));
            add(new Edge("b", "a"));
        }};
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        List<Node> nodes = new LinkedList<Node>() {{
            add(new Node("a"));
            add(new Node("b"));
            add(new Node("c"));
        }};
        ToPoSort toPoSort = new ToPoSort(edges, nodes);
        List<String> ret = toPoSort.sort();
        System.out.println(111);
    }
}

