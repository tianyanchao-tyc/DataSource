package data.base.service.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;


/**
 * DynamicDataSource的申明，其作为工程全局的datasource使用
 *
 * @author
 * date 2019-11-06
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public DynamicDataSource (DataSource defaultDataSource, Map<Object, Object> dataSource) {
        super.setDefaultTargetDataSource(defaultDataSource);
        super.setTargetDataSources(dataSource);
        super.afterPropertiesSet();
    }


    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}
