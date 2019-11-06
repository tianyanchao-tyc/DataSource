package data.base.service.service;

import data.base.service.annotation.DataSource;
import data.base.service.dao.DataSourceDao;
import data.base.service.interfaces.DataSourceNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 服务层
 *
 * @author tyc
 * date 2019-11-06
 */

@Service
public class DataSourceService {

    @Autowired
    private DataSourceDao dataSourceDao;

    @DataSource(name = DataSourceNames.MASTER)
    public void insert() {
        String id = "123456";
        dataSourceDao.insert(id);
    }

    @DataSource(name = DataSourceNames.SLAVE)
    public void insert2() {
        String id = "234567";
        dataSourceDao.insert2(id);
    }
}
