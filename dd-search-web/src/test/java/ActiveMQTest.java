import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

public class ActiveMQTest {
 /*   @Test
    public void testProducer() throws Exception{
        //第一步：创建ConnectionFactory对象，需要制定服务器IP和端口号
        //brokerURL服务器的IP和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://119.23.223.202:8161");
        //第二步：创建Connection对象
        Connection connetion = connectionFactory.createConnection();
        //第三步：开启连接
        connetion.start();
        //第四步：使用连接对象创建会话对象
        //第一个参数：是否开启事务，true为开启，第二个参数忽略
        //第二个参数：当第一个参数为false才有意义。消息应答模式：1、自动应答 2、手动应答，一般为自动应答即可
        Session session = connetion.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //第五步：使用会话对象创建Destination对象（topic，queue），这里创建一个queue对象
        //参数: 队列名称
        Queue queue = session.createQueue("test-queue");
        //第六步：使用会话对象创建生产者对象
        MessageProducer producer = session.createProducer(queue);
        //第七步：创建TextMessage对象
        TextMessage textMessage = session.createTextMessage("hello activemq");
        //第八步：使用producer对象发送消息
        producer.send(textMessage);
        //第九步：关闭资源
        producer.close();
        session.close();
        connetion.close();
    }*/
}
