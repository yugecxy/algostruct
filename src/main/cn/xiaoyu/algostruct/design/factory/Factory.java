package xiaoyu.algostruct.design.factory;

interface BaseTask {
    void execute();
}

class SqlTask implements BaseTask {
    @Override
    public void execute() {
        System.out.println("sql");
    }
}

class PythonTask implements BaseTask {
    @Override
    public void execute() {

    }
}

public class Factory {
    public static BaseTask getTaskImpl(String type) {
        BaseTask task = null;
        switch (type) {
            case "sql": {
                task = new SqlTask();
                break;
            }
            case "python": {
                task = new PythonTask();
                break;
            }
        }
        return task;
    }

    public static void main(String[] args) {
        BaseTask task = getTaskImpl("kkkk");
        System.out.println(11);
    }
}
