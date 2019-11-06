package data.base.service.config;

import com.alibaba.druid.pool.DruidDataSource;
import data.base.service.interfaces.DataSourceNames;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * dataSource数据源配置
 *
 * @author tyc
 * date 2019-11-06
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        Map<Object,Object> map = new HashMap<>();
        map.put(DataSourceNames.MASTER,masterDataSource);
        map.put(DataSourceNames.SLAVE,slaveDataSource);
        return new DynamicDataSource(masterDataSource,map);
    }
}
