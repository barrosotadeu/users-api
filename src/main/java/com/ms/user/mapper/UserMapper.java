package com.ms.user.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.ms.user.dto.UserRecordDto;
import com.ms.user.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel userRecordDtoToUSerModel(UserRecordDto dto);

}
