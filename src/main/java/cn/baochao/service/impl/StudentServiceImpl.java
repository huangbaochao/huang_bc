package cn.baochao.service.impl;


import cn.baochao.dto.StudentDto;
import cn.baochao.repository.StudentMapper;
import cn.baochao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangbc on 2017/3/11.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Map<String, Object> insertSelective(StudentDto dto) {
        Map<String, Object> map = new HashMap<String, Object>();
        int num = studentMapper.insertSelective(dto);
        if (num > 0) {
            map.put("code", "0000");
        }
        return map;
    }
}
