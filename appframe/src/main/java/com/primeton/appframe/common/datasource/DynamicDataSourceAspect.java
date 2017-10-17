package com.primeton.appframe.common.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * 
 * ClassName: DynamicDataSourceAspect <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年10月17日 下午12:16:06 <br/>
 * 切换数据源
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

	/**
	 * 根据@TargetDataSource的属性值设置不同的dataSourceKey,以供DynamicDataSource
	 * @param point
	 * @param ds
	 * @throws Throwable
	 */
    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, TargetDataSource ds) throws Throwable {
        DynamicDataSource.setDataSourceType(ds.value());
    }

    /**
     * 方法执行完毕后清除数据源
     * @param point
     * @param ds
     */
    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, TargetDataSource ds) {
        DynamicDataSource.clearDataSourceType();
    }

}
