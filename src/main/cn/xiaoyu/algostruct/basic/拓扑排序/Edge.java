package xiaoyu.algostruct.basic.拓扑排序;

class Edge {
    String prevCode;
    String nextCode;

    public Edge(String prevCode, String nextCode) {
        this.prevCode = prevCode;
        this.nextCode = nextCode;
    }
}
