package com.song.demo.webservice.publish;

import com.song.demo.webservice.dao.WebServiceDao;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

/**
 * @author Song.X
 * Date: 2020/11/23
 * Description: publish web service
 */
@Configuration
public class Publish {
    @Autowired
    Bus bus;

    @Resource
    private WebServiceDao webServiceDao;

    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, webServiceDao);
        endpoint.publish("/testWebService");
        return endpoint;
    }


}
