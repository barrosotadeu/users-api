package com.ms.user.controller;

import com.ms.user.dto.UserRecordDto;
import com.ms.user.mapper.UserMapper;
import com.ms.user.model.UserModel;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    final UserService userService;


    final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }


    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){

        //var userModel = new UserModel();

        //BeanUtils.copyProperties(userRecordDto, userModel);
        var userModel = mapper.userRecordDtoToUSerModel(userRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}
