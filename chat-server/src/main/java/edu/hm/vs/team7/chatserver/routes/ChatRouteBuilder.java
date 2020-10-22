package edu.hm.vs.team7.chatserver.routes;

import edu.hm.vs.team7.chatserver.model.Message;
import edu.hm.vs.team7.chatserver.routes.handler.ExampleHandler;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ChatRouteBuilder extends RouteBuilder {

    private static final String ROUTE_IN = "activemq:queue:chat-in";
    private static final String ROUTE_OUT = "activemq:topic:chat-out";

    private final ExampleHandler exampleHandler;

    public ChatRouteBuilder(ExampleHandler exampleHandler) {
        this.exampleHandler = exampleHandler;
    }

    @Override
    public void configure() {
        from(ROUTE_IN)
                .unmarshal().json(JsonLibrary.Jackson, Message.class)
                .log("Received message... - ${body.uuid}")
                .bean(exampleHandler)
                .log("sending message... - ${body.uuid}")
                .marshal().json(JsonLibrary.Jackson)
                .to(ROUTE_OUT)
                .end();
    }
}
