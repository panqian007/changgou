package com.changgou.demo;

public class Thread1 implements Runnable{
    @Override
    public void run() {
        int count =0;
        for (int i =0;i<10;i++){
            count++;
            System.out.println("运行了"+i+"次");
        }
        System.out.println("count:"+count);
    }

}
