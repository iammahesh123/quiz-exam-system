package com.jntugv.exammanagement.mapper;

import com.jntugv.exammanagement.entity.User;
import com.jntugv.exammanagement.model.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

   public UserResponseDTO toDTO(User user) {
        UserResponseDTO userResponseDTO = modelMapper.map(user, UserResponseDTO.class);
        if(user.getDepartment() != null) {
            userResponseDTO.setDepartmentId(user.getDepartment().getId());
        }
        if(user.getBranch() != null) {
            userResponseDTO.setBranchId(user.getBranch().getId());
        }
        return userResponseDTO;
    }
}
