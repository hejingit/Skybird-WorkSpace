package org.skybird.example.springboot.service;

import java.util.List;

import org.skybird.example.springboot.dao.JpaTestTableDao;
import org.skybird.example.springboot.vo.JpaTestTablePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * ClassName: TestService.java <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年9月15日下午3:51:35 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version 
 * @since 
 */
@Service
public class TestService {

    @Autowired
    JpaTestTableDao jpaTestTableDao;

    // SpringBoot JPA 默认CRUD实现
    public void save(JpaTestTablePO po) {
        jpaTestTableDao.save(po);
    }

    public List<JpaTestTablePO> list() {
        return jpaTestTableDao.findAll();
    }

    public void delete(int id) {
        jpaTestTableDao.delete(id);
    }

    // SpringBoot JPA 简单查询
    public List<JpaTestTablePO> findByMessageContaining(String message) {
        return jpaTestTableDao.findByMessageContaining(message);
    }

}
