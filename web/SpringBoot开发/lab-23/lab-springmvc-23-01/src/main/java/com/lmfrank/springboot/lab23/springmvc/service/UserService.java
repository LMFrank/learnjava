package com.lmfrank.springboot.lab23.springmvc.service;

import com.lmfrank.springboot.lab23.springmvc.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserVO get(Integer id) {
        return new UserVO().setId(id).setUsername("test");
    }
}
