package rabbitmq;

import vn.cs123.lib.mq.rabbitmq.RBConfiguration;
import vn.cs123.lib.mq.rabbitmq.RBProducerHandler;
import vn.cs123.lib.utils.common.config.ConfigCenter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static RBConfiguration _rbConfiguration;
    public static String CS123_DEMO_EXCHANGENAME = "123cs.datawarehouse";
    public static String CS123_DEMO_ROUTING_KEY = "";

    public static void main(String[] args) {
        init();
        String messageBody = "";

        try {
            RBProducerHandler.getInstance(_rbConfiguration).setMessage(CS123_DEMO_EXCHANGENAME, CS123_DEMO_ROUTING_KEY, messageBody);
        } catch (Exception e) {
            e.printStackTrace();
        }


        ExecutorService es = Executors.newFixedThreadPool(4);
        ProcessReceiveMessage processReceiveMessage = null;
        try {
            processReceiveMessage = new ProcessReceiveMessage(es);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != processReceiveMessage)
            processReceiveMessage.subscribeMessage();

    }

    private static void init() {
        String rabbitmqHost = ConfigCenter.getConfig("rabbitmq.123cs.cluster.host");
        String rabbitmqUsername = ConfigCenter.getConfig("rabbitmq.123cs.cluster.username");
        String rabbitmqPassword = ConfigCenter.getConfig("rabbitmq.123cs.cluster.password");
        String rabbitmqVirtualHost = ConfigCenter.getConfig("rabbitmq.123cs.cluster.virtual_host");
        _rbConfiguration = new RBConfiguration(rabbitmqHost, rabbitmqUsername, rabbitmqPassword, rabbitmqVirtualHost);

    }
}