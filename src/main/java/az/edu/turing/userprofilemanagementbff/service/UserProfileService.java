package az.edu.turing.userprofilemanagementbff.service;


import az.edu.turing.userprofilemanagementbff.client.UserProfileClient;
import az.edu.turing.userprofilemanagementbff.dto.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    @Lazy
    private UserProfileClient userProfileClient;


    public Long createUser(UserRequestDto userCreateRequestDto) {
        ResponseEntity<RestResponse<Long>> response = userProfileClient.createUser(userCreateRequestDto);
        return response.getBody().data();
    }


    public UserResponseDto getUserById(Long id) {
        ResponseEntity<RestResponse<UserResponseDto>> response = userProfileClient.getUserById(id);
        return response.getBody().data();
    }


    public List<UserResponseDto> getAllUsers() {
        ResponseEntity<RestResponse<List<UserResponseDto>>> response = userProfileClient.getAllUsers();
        return response.getBody().data();
    }


    public ResponseEntity<Void> updateUser(Long id, UserRequestDto userUpdateRequestDto) {
        ResponseEntity<Void> response = userProfileClient.updateUser(id,userUpdateRequestDto);
        userProfileClient.updateUser(id, userUpdateRequestDto);
        return response;
    }



    public ResponseEntity<Void> deleteUser(Long id) {
        ResponseEntity<Void> response = userProfileClient.deleteUser(id);
        userProfileClient.deleteUser(id);
        return response;
    }


    public Long getCountUsers() {
        ResponseEntity<Long> response = userProfileClient.getCountUsers();
        return response.getBody();

    }


    public List<ProfileResponseDto> getAllProfiles(Long id) {
        ResponseEntity<RestResponse<List<ProfileResponseDto>>> response = userProfileClient.getAllProfiles(id);
        return response.getBody().data();
    }



    public Long addProfile(Long id, ProfileRequestDto profileRequestDto) {
        ResponseEntity<RestResponse<Long>> response = userProfileClient.addProfile(id,profileRequestDto);
        return response.getBody().data();
    }


    public ProfileResponseDto retrieveProfile(Long id, Long profileId) {
        ResponseEntity<RestResponse<ProfileResponseDto>> response = userProfileClient.retrieveProfile(id,profileId);
        return response.getBody().data();
    }


    public ResponseEntity updateProfile(Long id, Long profileId, ProfileRequestDto profileRequestDto) {
        ResponseEntity<Void> response = userProfileClient.updateProfile(id, profileId, profileRequestDto);
        return response;
    }



    public ResponseEntity deleteProfile(Long id, Long profileId) {
        ResponseEntity<Void> response = userProfileClient.deleteProfile(id,profileId);
        userProfileClient.deleteProfile(id, profileId);
        return null;
    }


    public ResponseEntity updateStatus(Long id, Long profileId, UpdateStatusRequestDto updateStatusRequestDto) {
        ResponseEntity<Void> response = userProfileClient.updateStatus(id,profileId,updateStatusRequestDto);
        userProfileClient.updateStatus(id, profileId,updateStatusRequestDto);
        return null;
    }




}
