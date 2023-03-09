package top.flobby.advanced.exception;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 异常测试
 * @create : 2023-03-09 21:20
 **/

public class ExceptionTest {
    private boolean test01() {
        boolean ret = true;
        try {
            ret = test02();
        } catch (Exception e) {
            System.out.println("test01 error:" + e.getMessage());
            ret = false;
        } finally {
            System.out.println("test01,finally, return -> " + ret);
            return ret;
        }
    }


    private boolean test02() {
        boolean ret = true;
        try {
            // test03 发生异常了，虽然 try catch 了，但调用的地方没有接收
            test03();
            System.out.println("因为test03报错，我不应该执行。");
            return ret;
        } catch (Exception e) {
            System.out.println("test02 error:" + e.getMessage());
            ret = false;
            throw e;
        } finally {
            System.out.println("test02 finally, return -> " + ret);
            return ret;
        }
    }

    private boolean test03() throws Exception {
        boolean ret = true;
        try {
            System.out.println("即将发生异常");
            int a = 1 / 0;
            System.out.println("发生异常后，还会执行我吗？");
            return true;
        } catch (Exception e) {
            System.out.println("test03 error:" + e.getMessage());
            ret = false;
            throw e;
        } finally {
            System.out.println("test03 finally, return -> " + ret);
            return ret;
        }
    }

    public static void main(String[] args) {
        ExceptionTest main = new ExceptionTest();
        try {
            boolean b = main.test01();
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
