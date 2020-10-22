package edu.hm.vs.team7.chatclient.routes.handler;

import edu.hm.vs.team7.chatclient.model.Message;
import edu.hm.vs.team7.chatclient.util.NameGenerator;
import org.apache.camel.Handler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MessageGeneratorHandler {

    private final String name;

    public MessageGeneratorHandler() {
        name = new NameGenerator(8).getName();
    }

    @Handler
    @Transactional
    public Message handle() {
        return new Message("Hallo ich bin der Client " + name, name);
    }
}
