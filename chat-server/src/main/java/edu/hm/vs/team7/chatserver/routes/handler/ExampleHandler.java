package edu.hm.vs.team7.chatserver.routes.handler;

import edu.hm.vs.team7.chatserver.model.Message;
import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ExampleHandler {

    @Handler
    @Transactional
    public Message handle(@Body Message message) {
        // just some code to do something
        return Message.from(message);
    }
}
