package com.rzq.service.impl;

import com.rzq.entity.User;
import com.rzq.exception.CustomException;
import com.rzq.repository.AdditionalFacilityRepository;
import com.rzq.repository.FacilityRepository;
import com.rzq.repository.RoomCategoryRepository;
import com.rzq.repository.UserRepository;
import com.rzq.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Autowired
    private Validator validator;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomCategoryRepository roomCategoryRepository;

    @Autowired
    private AdditionalFacilityRepository additionalFacilityRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public void validate(Object request) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if (constraintViolations.size()>0){
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    @Override
    public User validateToken(String token) {
        if(token == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }

        User user = userRepository.findFirstByToken(token)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized"));

        if(user.getTokenExpiredAt()<System.currentTimeMillis()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }

        return user;
    }


    @Override
    public void validateDuplicateUsername(String username) {
        if(userRepository.existsById(username)){
            throw new CustomException(HttpStatus.BAD_REQUEST, "username", "already registered");
        }
    }

    @Override
    public void validateDuplicateRoomCategoryName(String name) {
        if(roomCategoryRepository.existsByName(name)){
            throw new CustomException(HttpStatus.BAD_REQUEST, "name", "already created");
        }
    }

    @Override
    public void validateDuplicateRoomCategoryName(String name, String id) {
        if(roomCategoryRepository.existsByNameAndIdNot(name, id)){
            throw new CustomException(HttpStatus.BAD_REQUEST, "name", "already created");
        }
    }

    @Override
    public void validateDuplicateAdditionalFacilityName(String name) {
        if(additionalFacilityRepository.existsByName(name)){
            throw new CustomException(HttpStatus.BAD_REQUEST, "name", "already created");
        }
    }

    @Override
    public void validateDuplicateAdditionalFacilityName(String name, String id) {
        if(additionalFacilityRepository.existsByNameAndIdNot(name ,id)){
            throw new CustomException(HttpStatus.BAD_REQUEST, "name", "already created");
        }
    }

    @Override
    public void validateDuplicateFacilityName(String name) {
        if(facilityRepository.existsByName(name)){
            throw new CustomException(HttpStatus.BAD_REQUEST, "name", "already created");
        }
    }

    @Override
    public void validateDuplicateFacilityName(String name, String id) {
        if(facilityRepository.existsByNameAndIdNot(name, id)){
            throw new CustomException(HttpStatus.BAD_REQUEST, "name", "already created");
        }
    }
}
