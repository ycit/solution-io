package com.ycit.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * mmap zero copy  :  1 cpu copy 、 2 DMA copy 、4 context switch
 * @author chenxiaolei
 * @date 2020/9/1
 */
public class MemoryMapDemo {

    public static void mmap(String from, String to) {
        try (FileChannel source = new RandomAccessFile(from, "r").getChannel();
             FileChannel target = new RandomAccessFile(to, "rw").getChannel();
        ) {
            MappedByteBuffer in = source.map(FileChannel.MapMode.READ_ONLY, 0, source.size());
            target.write(in);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[]args) {
        String from = "D:\\测试.txt";
        String to = "D:\\test.txt";
        mmap(from, to);
    }

}
