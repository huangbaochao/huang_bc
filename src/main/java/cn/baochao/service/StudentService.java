package cn.baochao.service;

import cn.baochao.dto.StudentDto;

import java.util.Map;

/**
 * Created by huangbc on 2017/3/11.
 */
public interface StudentService {

    public Map<String, Object> insertSelective(StudentDto dto);

}
