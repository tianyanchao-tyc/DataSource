package data.base.service.rest;

import data.base.service.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 *
 * @author tyc
 * date 2019-11-06
 */
@RestController
@RequestMapping("/dataSource")
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;

    @PostMapping("/insert1")
    public void insert() {
        dataSourceService.insert();
    }

    @PostMapping("insert2")
    public void insert2(){
        dataSourceService.insert2();
    }
}
