package com.changgou.demo;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @org.junit.Test
    public void  contextloads(){};

    @org.junit.Test
    public void threadTest(){
        for (int i = 0; i < 20; i++) {
            asyncTaskService.executeAsyncTask(i);
        }

    }
    @org.junit.Test
    public void threadTest1(){
    Thread2 thread2 = new Thread2();
    taskExecutor.execute(thread2);
    }
//    @org.junit.Test
//    public void threadScoket(){
//        String readline = null;
//        String inTemp = null;
//        //String outTemp = null;
//        String turnLine = "\n";
//        final String client = "Client:";
//        final String server = "Server:";
//        int port = 4000;
//        ServerSocket serverSocket = null;
//        try {
//            serverSocket = new ServerSocket(port,5);
//            //调用服务器的accept（）进行阻塞（程序会在这等待），当有申请连接时会打开阻塞并返回一个socket
////            while(true){
//                Socket socket = serverSocket.accept();
//            System.out.println(socket.getInetAddress().getHostAddress());
//                asyncTaskService.ScoketServer(socket);
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//    }
}
