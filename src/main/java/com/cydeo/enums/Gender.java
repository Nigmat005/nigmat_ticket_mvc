package com.cydeo.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter(AccessLevel.PUBLIC)
@AllArgsConstructor
public enum Gender {
    MALE("Male"),FEMALE("Female");
    private String genderType;

//     Gender(String genderType){
//        this.genderType=genderType;
//    }
//   public String getGenderType(){
//         return this.genderType;
//   }

}
