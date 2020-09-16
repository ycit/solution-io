package com.ycit.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * sendfile  zero copy :  0 cpu copy 、2 DMA copy 、2 context switch
 *
 * @author chenxiaolei
 * @date 2020/9/1
 */
public class SendFileDemo {

    public static void sendfile(String from, String to) {
        try (
                FileChannel source = new FileInputStream(from).getChannel();
                FileChannel destination = new FileInputStream(to).getChannel();
        ) {
            source.transferTo(0, source.size(), destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[]args) {
        String from = "D:\\测试.txt";
        String to = "D:\\test.txt";
        sendfile(from, to);
    }

}
