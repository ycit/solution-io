package com.ycit.message.nio;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

/**
 * Created by xlch on 2017/2/23.
 */
public class UDPNIo {

    public static void main(String [] args)throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.configureBlocking(false);
        DatagramSocket socket = channel.socket();
        socket.bind(new InetSocketAddress(5000));
    }

}
