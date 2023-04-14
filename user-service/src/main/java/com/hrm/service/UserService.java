package com.hrm.service;


import com.hrm.dto.request.NewCreateUserRequestDto;
import com.hrm.dto.request.UserUpdateRequestDto;
import com.hrm.exception.ErrorType;
import com.hrm.exception.UserServiceException;
import com.hrm.mapper.IUserMapper;
import com.hrm.repository.IUserRepository;
import com.hrm.repository.entity.User;
import com.hrm.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends ServiceManager<User,String> {

    private final IUserRepository userRepository;


    public UserService(IUserRepository userRepository) {
       super(userRepository);
        this.userRepository = userRepository;
    }


    public Boolean createUser(NewCreateUserRequestDto dto) {
      if (userRepository.findOptionalByIdentificationNumber(dto.getIdentificationNumber())
                .isPresent())
          throw new UserServiceException(ErrorType.IDENTIFICATIONNUMBER_DUPLICATE);
      save(IUserMapper.INSTANCE.toUser(dto));
      return true;
    }
}