package com.changgou.demo;

import java.io.*;
import java.net.Socket;
public class ServerSocketThread extends Thread{
    private Socket socket = null;
    private BufferedReader br = null;
    private PrintWriter pw = null;
    BufferedReader systemIn =null;
    //声明构造函数,接收客户端请求socket
    public ServerSocketThread(Socket s)
    {
        this.socket=s;
    }
    @Override
    public void run() {

        //while(true){
        try {
            //注意此处得到的socket的输入流为socket的输入流即上方的(private Socket socket = null; )
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            systemIn = new BufferedReader(new InputStreamReader(System.in));
            //向客户端返回消息的PrintWriter对象
            pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            InputStream is = socket.getInputStream();
            byte[] buf = new byte[1024]; //数据中转站 临时缓冲区
            int length = 0;
//            String str = br.readLine();
            String str = null;
            while((length = is.read(buf)) != -1) {
                System.out.println(new String(buf, 0, length));
                str = new String(buf,0,length,"UTF-8");
            }

            /* if(str.equals("END")){
     br.close();
     pw.close();
     socket.close();
     break;
    } */
            System.out.println(socket.getInetAddress().getHostAddress()+":"+str);
            System.out.println("server:");
            pw.print(systemIn.readLine());
            pw.flush();
        }
        catch (Exception e) {
            System.out.println("yichang");
            try {
                systemIn.close();
                br.close();
                pw.close();
                socket.close();
            }
            catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        // }
    }
}
