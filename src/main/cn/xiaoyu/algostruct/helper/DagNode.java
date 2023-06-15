package xiaoyu.algostruct.helper;

import java.util.LinkedList;
import java.util.List;

public class DagNode {
    private String name;
    private final int value;
    private final List<DagNode> childNodes = new LinkedList<>();

    public DagNode(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void addChildEle(DagNode node) {
        childNodes.add(node);
    }

    public List<DagNode> getChildNodes() {
        return this.childNodes;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
