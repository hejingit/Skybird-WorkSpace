package org.skybird.example.springboot.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * ClassName: JpaTestTablePO.java <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年9月15日下午3:36:33 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version 
 * @since 
 */
@Entity
@Table(name = "spring_jpa_test_table")
public class JpaTestTablePO {

    private int id;

    private String message;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
