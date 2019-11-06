package data.base.service.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 数据层
 *
 * @author tyc
 * date 2019-11-06
 */
@Repository
@Mapper
public interface DataSourceDao {
    int insert( String id);

    @Insert("insert into test1(id) values (#{id})")
    void insert2(String id);
}
