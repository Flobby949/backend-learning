package top.flobby.advanced.ioex;

import java.io.*;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 文件输入输出流练习
 * @create : 2023-03-28 23:45
 **/

public class FileInputOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputOutputStreamDemo.writeContentInFile();
        FileInputOutputStreamDemo.readFileContent();
    }

    /**
     * 阅读文件内容
     *
     * @throws IOException ioexception
     */
    public static void readFileContent() throws IOException {
        // 实例化文件流
        InputStream fileInputStream = new FileInputStream("E:\\java-projects\\backend-learning\\java-advanced\\geek\\Hello.txt");
        for (;;) {
            int n = fileInputStream.read();
            if (n == -1) {
                // read() 方法返回-1 则跳出循环
                break;
            }
            // 将n强制转换为 char 类型
            System.out.print((char) n);
        }
        // 关闭文件流
        fileInputStream.close();
    }

    public static void writeContentInFile() throws IOException {
        OutputStream fileOutputStream =
                new FileOutputStream("E:\\java-projects\\backend-learning\\java-advanced\\geek\\Hello.txt",true);
        // 写入 3 个字符
        fileOutputStream.write(72);
        fileOutputStream.write(73);
        fileOutputStream.write(74);
        fileOutputStream.close();
    }
}
