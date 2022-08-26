package xiaoyu.algostruct.basic.dag;

class Edge {
    String prevCode;
    String nextCode;

    public Edge(String prevCode, String nextCode) {
        this.prevCode = prevCode;
        this.nextCode = nextCode;
    }
}
