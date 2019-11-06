package data.base.service;

import data.base.service.service.DataSourceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceApplicationTests {

    @Autowired
    private DataSourceService dataSourceService;

    @Test
    public void contextLoads() {
        System.out.println(dataSourceService.toString());
    }

}
