package az.edu.turing.userprofilemanagementbff.service;

import az.edu.turing.userprofilemanagementbff.client.UserProfileClient;
import az.edu.turing.userprofilemanagementbff.dto.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {
    @Lazy
    private UserProfileClient userProfileClient;

    public ResponseEntity<RestResponse<Long>> createUser(UserRequestDto userCreateRequestDto) {
        return userProfileClient.createUser(userCreateRequestDto);
    }

    public ResponseEntity<RestResponse<UserResponseDto>> getUserById(Long id) {
        return userProfileClient.getUserById(id);
    }

    public ResponseEntity<RestResponse<List<UserResponseDto>>> getAllUsers() {
        return userProfileClient.getAllUsers();
    }

    public ResponseEntity<Void> updateUser(Long id, UserRequestDto userUpdateRequestDto) {
        return userProfileClient.updateUser(id, userUpdateRequestDto);
    }

    public ResponseEntity<Void> deleteUser(Long id) {
        return userProfileClient.deleteUser(id);
    }

    public ResponseEntity<Long> getCountUsers() {
        return userProfileClient.getCountUsers();
    }

    public ResponseEntity<RestResponse<List<ProfileResponseDto>>> getAllProfiles(Long id) {
        return userProfileClient.getAllProfiles(id);
    }

    public ResponseEntity<RestResponse<Long>> addProfile(Long id, ProfileRequestDto profileRequestDto) {
        return userProfileClient.addProfile(id, profileRequestDto);
    }

    public ResponseEntity<RestResponse<ProfileResponseDto>> retrieveProfile(Long id, Long profileId) {
        return userProfileClient.retrieveProfile(id, profileId);
    }

    public ResponseEntity<Void> updateProfile(Long id, Long profileId, ProfileRequestDto profileRequestDto) {
        return userProfileClient.updateProfile(id, profileId, profileRequestDto);
    }

    public ResponseEntity<Void> deleteProfile(Long id, Long profileId) {
        return userProfileClient.deleteProfile(id, profileId);
    }

    public ResponseEntity<Void> updateStatus(Long id, Long profileId, UpdateStatusRequestDto updateStatusRequestDto) {
        return userProfileClient.updateStatus(id, profileId, updateStatusRequestDto);
    }

}
