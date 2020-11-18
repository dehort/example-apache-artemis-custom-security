package com.redhat.example.mqtt;

import io.netty.handler.codec.mqtt.MqttMessage;
import org.apache.activemq.artemis.core.protocol.mqtt.MQTTInterceptor;
import org.apache.activemq.artemis.spi.core.protocol.RemotingConnection;
import org.apache.activemq.artemis.api.core.ActiveMQException;


public class CustomMQTTInterceptor implements MQTTInterceptor {
    public boolean intercept(MqttMessage message, RemotingConnection connection) throws ActiveMQException {
        System.out.print("*** CustomMQTTInterceptor.intercept()\n");
        return true;
    }
}

