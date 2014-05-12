package com.agmlab.sat.service;

import com.agmlab.sat.persist.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alparslan on 09.05.2014.
 */
@Service
public class TestService {
    @Autowired
    private TestDao testDao;

    public String testService(String id){
        return testDao.test(id);
    }

    public int testInsert(String test) {
        return testDao.testInsert(test);
    }
}
