package org.skybird.example.springboot.dao;

import java.io.Serializable;
import java.util.List;

import org.skybird.example.springboot.vo.JpaTestTablePO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * ClassName: JpaTestTableDao.java <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年9月15日下午3:37:52 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version 
 * @since 
 */
public interface JpaTestTableDao extends JpaRepository<JpaTestTablePO, Serializable> {

	public List<JpaTestTablePO> findByMessageContaining(String message);

}
