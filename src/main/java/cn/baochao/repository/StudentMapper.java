package cn.baochao.repository;

import cn.baochao.dto.StudentDto;
import org.springframework.stereotype.Repository;

/**
 * Created by huangbc on 2017/3/11.
 */
@Repository
public interface StudentMapper {

    int insertSelective(StudentDto record);

}
