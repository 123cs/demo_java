package rabbitmq;

import vn.cs123.lib.mq.rabbitmq.RBConfiguration;
import vn.cs123.lib.mq.rabbitmq.RBConsumerHandler;
import vn.cs123.lib.mq.rabbitmq.RBMessageHandler;
import vn.cs123.lib.utils.common.config.ConfigCenter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;

public class ProcessReceiveMessage {

    private final RBConsumerHandler _client;

    public ProcessReceiveMessage(ExecutorService es) throws IOException, TimeoutException {
        RBConfiguration rbConfiguration = new RBConfiguration();
        rbConfiguration.setListhost(ConfigCenter.getConfig("rabbitmq.123cs.cluster.host"));
        rbConfiguration.setVirtualhost(ConfigCenter.getConfig("rabbitmq.123cs.cluster.virtual_host"));
        rbConfiguration.setUsername(ConfigCenter.getConfig("rabbitmq.123cs.cluster.username"));
        rbConfiguration.setPassword(ConfigCenter.getConfig("rabbitmq.123cs.cluster.password"));
        this._client = RBConsumerHandler.connect(rbConfiguration, new RBException(), es);
    }


    public void subscribeMessage() {
        this._client.handleConsumer(Main.CS123_DEMO_EXCHANGENAME, Main.CS123_DEMO_ROUTING_KEY, "java_demo", new RBMessageHandler() {

            @Override
            public void handleSuccess(String messageQueue) {
                System.out.println(messageQueue);
            }

            @Override
            public void handleError(String message) {
                System.out.println("handleError message:" + message);
            }
        });
    }
}
