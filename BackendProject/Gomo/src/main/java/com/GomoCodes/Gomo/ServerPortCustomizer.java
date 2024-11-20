package com.GomoCodes.Gomo;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

public class ServerPortCustomizer implements WebServerFactoryCustomizer <ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        String  port=System.getenv("X_ZOHO_CATALYST_LISTEN_PORT"); // getenv = Catalyst function
        // when we use this [X_ZOHO_CATALYST_LISTEN_PORT]the generated jar file is directed from the environment and reach the port number X_ZOHO_CATALYST_LISTEN_PORT
        // if the port is present they assign to the listenPort else 9000
        int listenPort;
        if(port != null && !port.isEmpty()){
            listenPort=Integer.parseInt(System.getenv("X_ZOHO_CATALYST_LISTEN_PORT"));
        }
        else{
            listenPort=9000;
        }

        factory.setPort(listenPort);
    }
}
