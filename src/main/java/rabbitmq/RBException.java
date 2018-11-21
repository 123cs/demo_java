package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.TopologyRecoveryException;
import vn.cs123.lib.mq.rabbitmq.RBExceptionHandler;

public class RBException extends RBExceptionHandler {
    @Override
    public void handleUnexpectedConnectionDriverException(Connection connection, Throwable throwable) {

    }

    @Override
    public void handleReturnListenerException(Channel channel, Throwable throwable) {

    }

    @Override
    public void handleConfirmListenerException(Channel channel, Throwable throwable) {

    }

    @Override
    public void handleBlockedListenerException(Connection connection, Throwable throwable) {

    }

    @Override
    public void handleConsumerException(Channel channel, Throwable throwable, Consumer consumer, String s, String s1) {

    }

    @Override
    public void handleConnectionRecoveryException(Connection connection, Throwable throwable) {

    }

    @Override
    public void handleChannelRecoveryException(Channel channel, Throwable throwable) {

    }

    @Override
    public void handleTopologyRecoveryException(Connection connection, Channel channel, TopologyRecoveryException e) {

    }
}
