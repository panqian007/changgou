package com.changgou.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        // TODO 自动生成的方法存根

        String readline = null;
        String inTemp = null;
        //String outTemp = null;
        String turnLine = "\n";
        final String client = "Client:";
        final String server = "Server:";

        int port = 4000;
        //byte ipAddressTemp[] = {127, 0, 0, 1};
        //InetAddress ipAddress = InetAddress.getByAddress(ipAddressTemp);
        //首先直接创建serversocket
//        InetAddress addr = InetAddress.getByName("172.16.8.8");
        ServerSocket serverSocket = new ServerSocket(port,5);
        //调用服务器的accept（）进行阻塞（程序会在这等待），当有申请连接时会打开阻塞并返回一个socket
        Socket socket = serverSocket.accept();
//        ServerSocketThread serverSocketThread = new ServerSocketThread(socket);
//        serverSocketThread.start();

        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
//        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        InputStream is =socket.getInputStream();
//        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
        System.out.println(socket.getInetAddress().getHostAddress());
//        String IP = socket.getInetAddress().getHostAddress();

        byte[] buf = new byte[1024]; //数据中转站 临时缓冲区
        int length = 0;
        //循环读取文件内容，输入流中将最多buf.length个字节的数据读入一个buf数组中,返回类型是读取到的字节数。
        //当文件读取到结尾时返回 -1,循环结束。

        while(readline!="bye"){

        //            inTemp = socketIn.readLine();

//            while((length = is.read(buf)) != -1) {
//                System.out.println(new String(buf, 0, length));
//            }
            inTemp = new String(buf, 0, length,"UTF-8");
//            System.out.println(IP + ":" + turnLine + inTemp);
//            System.out.println(server);
//            readline = systemIn.readLine();
//            socketOut.print(readline);
//            socketOut.flush();    //赶快刷新使Client收到，也可以换成socketOut.println(readline, ture)

            //outTemp = readline;

            //System.out.println(server);

        }

//        systemIn.close();
//        socketIn.close();
//        socketOut.close();
//        is.close();
//        socket.close();
//        serverSocket.close();

    }

}
