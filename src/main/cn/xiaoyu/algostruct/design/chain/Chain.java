package xiaoyu.algostruct.design.chain;

import java.util.LinkedList;
import java.util.List;

interface Handler {
    void deal();
}

class HandlerA implements Handler {
    @Override
    public void deal() {

    }
}

class HandlerB implements Handler {
    @Override
    public void deal() {

    }
}

public class Chain {
    private final List<Handler> handlers = new LinkedList<>();

    public void add(Handler handler) {
        handlers.add(handler);
    }

    public void deal() {
        handlers.forEach(Handler::deal);
    }

    public static void main(String[] args) {
        Chain chain = new Chain();
        chain.add(new HandlerA());
        chain.add(new HandlerB());
        chain.deal();
    }
}
