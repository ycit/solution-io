package com.ycit.io;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 文件测试
 * <p>
 * Created by xlch at 2018/6/21
 */
public class FileTest {


    @Test
    public void common() throws IOException {
        String path = "d://file.txt";
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.canRead());
        try(
                 BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        ) {
            InputStream console = System.in;
            Scanner scanner = new Scanner(console);
            System.out.println("请输入：");
            while (scanner.hasNext()) {
                String result = scanner.nextLine();
                System.out.println(result);
//                if (!"bye".equals(result)) {
//                    out.write(result);
//                } else {
//                    break;
//                }
            }
        }
    }

    public void consoleTest() {

    }

    public static void main(String[] args)throws IOException {

        String path = "d:\\io\\test\\file.txt";
        File file = new File(path);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.canRead());
        try(
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        ) {
            InputStream console = System.in;
            Scanner scanner = new Scanner(console);
            System.out.println("请输入：");
            while (scanner.hasNext()) {
                String result = scanner.nextLine();
                System.out.println(result);
                if (!"bye".equals(result)) {
                    out.write(result);
                } else {
                    break;
                }
            }
        }
    }

}

