package cn.baochao.controller;

import cn.baochao.dto.StudentDto;
import cn.baochao.exception.BEX;
import cn.baochao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by huangbc on 2017/3/11.
 */
@RestController
@RequestMapping("student")
public class StudentController {


    @Autowired
    StudentService studentService;


    @RequestMapping(value = "test1")
    public ModelAndView student01(){
        ModelAndView mode = new ModelAndView("02");
        return mode;
    }

    @RequestMapping(value = "test2",method = RequestMethod.POST)
    public Map<String, Object> fuyouDict(@Valid StudentDto dto, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new BEX("1002", "参数异常");
        }
        return studentService.insertSelective(dto);
    }



}
