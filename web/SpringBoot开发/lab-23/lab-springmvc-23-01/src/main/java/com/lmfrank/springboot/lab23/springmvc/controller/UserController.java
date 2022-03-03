package com.lmfrank.springboot.lab23.springmvc.controller;

import com.lmfrank.springboot.lab23.springmvc.dto.UserAddDTO;
import com.lmfrank.springboot.lab23.springmvc.dto.UserUpdateDTO;
import com.lmfrank.springboot.lab23.springmvc.service.UserService;
import com.lmfrank.springboot.lab23.springmvc.vo.UserVO;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<UserVO> list() {
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("aa"));
        result.add(new UserVO().setId(2).setUsername("bb"));
        result.add(new UserVO().setId(3).setUsername("cc"));
        return result;
    }

    @GetMapping("/{id}")
    public UserVO get(@PathVariable("id") Integer id) {
        return new UserVO().setId(id).setUsername("username:" + id);
    }

    @GetMapping("/v2/{id}")
    public UserVO get2(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @PostMapping("")
    public Integer add(UserAddDTO addDTO) {
        Integer returnId = 1;
        return returnId;
    }

    @PutMapping("/{id}")
    public Boolean update(@PathVariable("id") Integer id, UserUpdateDTO updateDTO) {
        updateDTO.setId(id);
        Boolean success = true;
        return success;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        Boolean success = false;
        return success;
    }
}
