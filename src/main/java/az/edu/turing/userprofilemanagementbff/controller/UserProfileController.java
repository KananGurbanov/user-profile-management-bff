package az.edu.turing.userprofilemanagementbff.controller;

import az.edu.turing.userprofilemanagementbff.dto.*;
import az.edu.turing.userprofilemanagementbff.service.UserProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "User Profile BFF API", description = "User Profile BFF Controller")
public class UserProfileController {

    private UserProfileService userProfileService;


    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody @Valid UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userProfileService.createUser(userRequestDto));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponseDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(Optional.ofNullable(userProfileService.getUserById(id)));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return ResponseEntity.ok(userProfileService.getAllUsers());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody @Valid UserRequestDto userRequestDto) {
        return userProfileService.updateUser(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userProfileService.deleteUser(id).getBody());
    }


    @GetMapping("/count")
    public ResponseEntity<Long> getCountUsers() {
        return ResponseEntity.ok(userProfileService.getCountUsers());
    }

    @GetMapping("/{id}/profiles")
    public ResponseEntity<List<ProfileResponseDto>> getAllProfiles(@PathVariable Long id) {
        return ResponseEntity.ok(userProfileService.getAllProfiles(id));
    }


    @PostMapping("/{id}/profiles")
    public ResponseEntity<Long> addProfile(@PathVariable Long id,
                                           @RequestBody @Valid ProfileRequestDto profileRequestDto) {
        return  ResponseEntity.ok(userProfileService.addProfile(id,profileRequestDto));
    }

    @GetMapping("/{id}/profiles/{profileId}")
    public ResponseEntity<ProfileResponseDto> retrieveProfile(@PathVariable Long id,
                                                              @PathVariable Long profileId) {
        return  ResponseEntity.ok(userProfileService.retrieveProfile(id,profileId));
    }

    @PutMapping("/{id}/profiles/{profileId}")
    public ResponseEntity updateProfile(@PathVariable Long id, @PathVariable Long profileId,
                                        @RequestBody @Valid ProfileRequestDto profileRequestDto) {
        return userProfileService.updateProfile(id,profileId,profileRequestDto);
    }

    @DeleteMapping("/{id}/profiles/{profileId}")
    public ResponseEntity deleteProfile(@PathVariable Long id, @PathVariable Long profileId) {
        return userProfileService.deleteProfile(id,profileId);
    }

    @PatchMapping("/{id}/profiles/{profileId}")
    public ResponseEntity updateStatus(@PathVariable Long id, @PathVariable Long profileId,
                                       @RequestBody @Valid UpdateStatusRequestDto updateStatusRequestDto) {
        return userProfileService.updateStatus(id, profileId, updateStatusRequestDto);
    }




}
