package xiaoyu.algostruct.design.observer;

import java.util.List;

interface BaseObserver {
    void afterLogin();

    void afterRegister();
}

class Observer1 implements BaseObserver {
    @Override
    public void afterRegister() {

    }

    @Override
    public void afterLogin() {

    }
}

class Observer2 implements BaseObserver {
    @Override
    public void afterRegister() {

    }

    @Override
    public void afterLogin() {

    }
}

class Subscribe {
    List<BaseObserver> observers;

    public void register() {
        observers.forEach(BaseObserver::afterRegister);
    }

    public void login() {
        observers.forEach(BaseObserver::afterLogin);
    }

    public void addObservers(BaseObserver observer) {
        observers.add(observer);
    }

}

public class Solution {
    public static void main(String[] args) {
        Subscribe subscribe = new Subscribe();
        subscribe.addObservers(new Observer1());
        subscribe.addObservers(new Observer2());

        //login事件
        subscribe.login();

        //register事件
        subscribe.register();
    }
}
