package edu.hm.vs.team7.chatclient.routes;

import edu.hm.vs.team7.chatclient.routes.handler.MessageGeneratorHandler;
import org.apache.camel.builder.RouteBuilder;
import edu.hm.vs.team7.chatclient.model.Message;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ClientRouteBuilder extends RouteBuilder {

    private static final String ROUTE_IN = "activemq:queue:chat-in";
    private static final String ROUTE_OUT = "activemq:topic:chat-out";

    private final MessageGeneratorHandler messageGeneratorHandler;

    public ClientRouteBuilder(MessageGeneratorHandler messageGeneratorHandler) {
        this.messageGeneratorHandler = messageGeneratorHandler;
    }

    @Override
    public void configure() {
        from(ROUTE_OUT)
                .unmarshal().json(JsonLibrary.Jackson, Message.class)
                .log("${body.sender}: ${body.content}").end();

        from("timer:chatmessagetrigger?period=1000")
                .bean(messageGeneratorHandler)
                .marshal().json(JsonLibrary.Jackson)
                .to(ROUTE_IN);

    }
}
