package quenue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author abelski
 */
public class TestProducer {
    private static final String QUEUE_NAME = "testQ";

    public static void main(String[] args) throws IOException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("testQ", "fanout");

        Integer i =0;
        while (true) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("testQ", "testS", null, i.toString().getBytes());
            System.out.println(" [x] Шлем '" + i++ + "'");
            Thread.sleep(1000);
        }

//        channel.close();
//        connection.close();
    }
}
