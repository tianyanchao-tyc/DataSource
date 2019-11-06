package data.base.service.annotation;

import data.base.service.config.DynamicDataSource;
import data.base.service.interfaces.DataSourceNames;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源切面处理类，实现数据库的选择
 *
 * @author tyc
 * date 2019-11-06
 */
@Aspect
@Component
@Slf4j
public class DataSourceAspect implements Ordered {

    @Pointcut("@annotation(data.base.service.annotation.DataSource)")
    public void dataSourcePointCut(){
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();

        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (dataSource == null) {
            DynamicDataSource.setDataSource(DataSourceNames.MASTER);
            log.debug("set datasource is  " + DataSourceNames.MASTER);
        } else {
            DynamicDataSource.setDataSource(dataSource.name());
            log.debug("set datasource is  "  + dataSource.name());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            log.debug("clear datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
