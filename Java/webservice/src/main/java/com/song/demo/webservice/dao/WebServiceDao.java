package com.song.demo.webservice.dao;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Song.X
 * Date: 2020/11/23
 * Description:
 */

@WebService(targetNamespace = "http://webservice.demo.song.com")
public interface WebServiceDao {

    @WebMethod(operationName = "getValueFromWebService")
    String getValue(@WebParam(name = "param") String param);
}
