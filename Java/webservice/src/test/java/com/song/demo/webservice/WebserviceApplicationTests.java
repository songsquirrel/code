package com.song.demo.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebserviceApplicationTests {

    @Test
    void contextLoads() throws Exception {
//        // 接口地址
//        String address = "http://127.0.0.1:17888/services/testWebService?wsdl";
//        // 代理工厂
//        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
//        // 设置代理地址
//        jaxWsProxyFactoryBean.setAddress(address);
//        // 设置接口类型
//        jaxWsProxyFactoryBean.setServiceClass(String.class);
//        // 创建一个代理接口实现
//        String us = (String) jaxWsProxyFactoryBean.create();
//        System.out.println(us);
        // 创建动态客户端
        // 注意: 动态客户端会从wsdl返回的地址去调用webservice, 如wsdl地址使用网关访问, 则可能出现网络不通的问题.
        // 解决方法, 考虑修改wsdl,地址指定为网关访问地址, 放到本地目录下, wsdlurl指定本地目录
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:17888/services/testWebService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] getValueFromWebServices = client.invoke("getValueFromWebService","test");
        System.out.println(getValueFromWebServices[0]);
    }

}
