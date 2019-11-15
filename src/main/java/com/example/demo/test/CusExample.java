package com.example.demo.test;

import com.sproutsocial.nsq.Message;
import com.sproutsocial.nsq.MessageHandler;
import com.sproutsocial.nsq.Subscriber;


public class CusExample implements MessageHandler {
    @Override
    public void accept(Message paramMessage) {
        //接收到的消息
        System.out.println("Received:" + new String(paramMessage.getData()));
        paramMessage.finish();//标记已消费

    }
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber("127.0.0.1");//nsq服务器ip，也可以配置多个
        CusExample data=new CusExample();//实现MessageHandler接口的accept方法的类
        subscriber.subscribe("test1", "nsq_to_file1", data);
        //对应上面一行的代码：订阅消息，test1是主体topic，与发布的主体要对应，
        //nsq_to_file1是通道channel，自定义，如果nsq服务器上没有该通道，会自动创建此通道
    }
}
