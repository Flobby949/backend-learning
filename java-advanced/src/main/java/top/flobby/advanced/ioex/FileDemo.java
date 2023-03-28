package top.flobby.advanced.ioex;

import java.io.File;
import java.io.IOException;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 文件操作 练习
 * @create : 2023-03-28 23:27
 **/

public class FileDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("------------------- 绝对路径 -------------------");
        FileDemo.absolutePath();
        System.out.println("------------------- 相对路径 -------------------");
        FileDemo.relativePath();
        System.out.println("------------------- 判断对象是文件还是目录 -------------------");
        // 传入目录绝对路径
        File dir = new File("E:\\java-projects\\backend-learning\\java-advanced\\geek\\images");
        // 传入文件绝对路径
        File file = new File("E:\\java-projects\\backend-learning\\java-advanced\\geek\\Hello.txt");
        FileDemo.printResult(dir);
        FileDemo.printResult(file);
        System.out.println("------------------- 创建 & 删除目录 -------------------");
        FileDemo.createDir();
        FileDemo.deleteDir();
    }

    /**
     * 绝对路径
     */
    public static void absolutePath() {
        // 传入目录绝对路径
        File dir = new File("E:\\java-projects\\backend-learning\\java-advanced\\geek\\images");
        // 传入文件绝对路径
        File file = new File("E:\\java-projects\\backend-learning\\java-advanced\\geek\\Hello.txt");
        // 打印两个File对象
        System.out.println(dir);
        System.out.println(file);
    }

    /**
     * 相对路径
     *
     * @throws IOException ioexception
     */
    public static void relativePath() throws IOException {
        // 传入目录相对路径
        File imageDir = new File(".\\geek\\images");
        File geekDir = new File(".\\geek");
        // 传入文件相对路径
        File file = new File(".\\geek\\Hello.txt");

        System.out.println("-- imagesDir ---");
        // 抽象路径名转换为路径名字符串
        System.out.println(imageDir.getPath());
        // 此抽象路径名的绝对路径名字符串
        System.out.println(imageDir.getAbsolutePath());
        // 抽象路径名的规范路径名字符串
        System.out.println(imageDir.getCanonicalPath());

        System.out.println("-- geekDir ---");
        System.out.println(geekDir.getPath());
        System.out.println(geekDir.getAbsolutePath());
        System.out.println(geekDir.getCanonicalPath());

        System.out.println("-- file ---");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }

    /**
     * 判断对象是文件还是目录
     * @param file file
     */
    public static void printResult(File file) {
        // 调用isFile()方法并接收布尔类型结果
        boolean isFile = file.isFile();
        String result1 = isFile ? "是已存在文件" : "不是已存在文件";
        // 掉用isDirectory()方法并接收布尔类型而己过
        boolean directory = file.isDirectory();
        String result2 = directory ? "是已存在目录" : "不是已存在目录";
        // 打印该file对象是否是已存在文件/目录的字符串结果
        System.out.print(file);
        System.out.print('\t' + result1 + '\t');
        System.out.println(result2);
    }

    /**
     * 创建dir
     */
    public static void createDir() {
        // 传入目录绝对路径
        File dir = new File("E:\\java-projects\\backend-learning\\java-advanced\\geek\\codes");
        if (!dir.exists()) {
            // 调用 mkdir() 方法
            boolean result = dir.mkdir();
            if (result) {
                System.out.println("目录创建成功");
            }
        }
    }

    /**
     * 删除dir
     */
    public static void deleteDir() {
        // 传入目录绝对路径
        File dir = new File("E:\\java-projects\\backend-learning\\java-advanced\\geek\\codes");
        if (dir.exists()) {
            // 调用 delete() 方法
            boolean deleted = dir.delete();
            if (deleted) {
                System.out.println("删除目录成功");
            }
        }
    }


}
