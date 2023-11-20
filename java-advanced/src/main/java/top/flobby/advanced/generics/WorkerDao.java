package top.flobby.advanced.generics;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-11-20 14:19
 **/

public class WorkerDao extends BaseDao<Worker>{

    private static final WorkerDao INSTANCE = new WorkerDao();

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.setId(1);
        worker.setName("Flobby");
        INSTANCE.save(worker);
    }
}
