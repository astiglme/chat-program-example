# Spring ActiveMQ Camel Example

## How to use:
* Start the ActiveMQ docker instance:
```bash
docker-compose -f .\infrastructure\docker-compose.yml up -d
```

* Start the Chatserver
* Start as many ChatClients as you like with the gradle task found in the gradle ui of IntelliJ:
```
chat-client/Tasks/application/bootRun
```