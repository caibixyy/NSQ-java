package com.example.demo.test;

import com.sproutsocial.nsq.Publisher;

public class Test1 {
    public static void main(String[] args) {
        //发布消息
        Publisher publisher = new Publisher("127.0.0.1");//你的nsq服务器ip地址，如果是分布式，可以是多个地址，如new Publisher("192.168.138.128","192.168.138.x")
        for(int i=0;i<100000;i++){
            byte[] data = ("Hello_nsq"+i).getBytes();//要发送的消息
            publisher.publish("test1", data);//test1为主体topic
        }
    }
}
