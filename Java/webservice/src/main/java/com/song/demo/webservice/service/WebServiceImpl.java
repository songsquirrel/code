package com.song.demo.webservice.service;

import com.song.demo.webservice.dao.WebServiceDao;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * @author Song.X
 * Date: 2020/11/23
 * Description:
 */
@Service
@WebService(name = "TestWebService",
        targetNamespace = "http://webservice.demo.song.com",
        endpointInterface = "com.song.demo.webservice.dao.WebServiceDao")
public class WebServiceImpl implements WebServiceDao {
    @Override
    public String getValue(String param) {
        return param;
    }
}
