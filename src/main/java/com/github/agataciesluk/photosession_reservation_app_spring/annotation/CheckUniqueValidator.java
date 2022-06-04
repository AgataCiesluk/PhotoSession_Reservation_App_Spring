package com.github.agataciesluk.photosession_reservation_app_spring.annotation;

import com.github.agataciesluk.photosession_reservation_app_spring.service.ClientBasicService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.PhotoSessionBasicService;
import com.github.agataciesluk.photosession_reservation_app_spring.service.UserBasicService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckUniqueValidator implements ConstraintValidator<CheckUnique, String> {

    private AttributeToCheck attributeToCheck;
    private UserBasicService userBasicService;
    private ClientBasicService clientBasicService;
    private PhotoSessionBasicService photoSessionBasicService;

    public CheckUniqueValidator(UserBasicService userBasicService, ClientBasicService clientBasicService, PhotoSessionBasicService photoSessionBasicService) {
        this.userBasicService = userBasicService;
        this.clientBasicService = clientBasicService;
        this.photoSessionBasicService = photoSessionBasicService;
    }

    @Override
    public void initialize(CheckUnique constraintAnnotation) {
        this.attributeToCheck = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String attribute, ConstraintValidatorContext context) {
        if (attributeToCheck == AttributeToCheck.USER_LOGIN) {
            return userBasicService.findUserByLogin(attribute) == null;
        }
        if (attributeToCheck == AttributeToCheck.EMAIL) {
            return clientBasicService.getClientByEmail(attribute) == null;
        }
        if (attributeToCheck == AttributeToCheck.PHONE_NUMBER) {
            return clientBasicService.getClientByPhoneNumber(attribute) == null;
        }
        if (attributeToCheck == AttributeToCheck.DATE) {
            return photoSessionBasicService.getPhotoSessByDate(attribute) == null;
        }
        return false;
    }
}
