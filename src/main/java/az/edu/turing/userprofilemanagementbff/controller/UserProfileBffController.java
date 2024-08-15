package az.edu.turing.userprofilemanagementbff.controller;

import az.edu.turing.userprofilemanagementbff.dto.*;
import az.edu.turing.userprofilemanagementbff.service.UserProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/bff/v1/users")
@Validated
@RequiredArgsConstructor
@Tag(name = "User Profile BFF API", description = "User Profile BFF Controller")
public class UserProfileBffController {
    private final UserProfileService userProfileService;


    @PostMapping
    public ResponseEntity<RestResponse<Long>> createUser(@RequestBody @Valid UserRequestDto userCreateRequestDto) {
        return userProfileService.createUser(userCreateRequestDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserResponseDto>> getUserById(@PathVariable @NotNull Long id) {
        return userProfileService.getUserById(id);
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserResponseDto>>> getAllUsers() {
        return userProfileService.getAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable @NotNull Long id,
                                           @RequestBody @Valid UserRequestDto userUpdateRequestDto) {
        return userProfileService.updateUser(id, userUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable @NotNull Long id) {
        return userProfileService.deleteUser(id);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCountUsers() {
        return userProfileService.getCountUsers();
    }

    @GetMapping("/{id}/profiles")
    public ResponseEntity<RestResponse<List<ProfileResponseDto>>> getAllProfiles(@PathVariable @NotNull Long id) {
        return userProfileService.getAllProfiles(id);
    }

    @PostMapping("/{id}/profiles")
    public ResponseEntity<RestResponse<Long>> addProfile(@PathVariable @NotNull Long id,
                                                         @RequestBody @Valid ProfileRequestDto profileRequestDto) {
        return userProfileService.addProfile(id, profileRequestDto);
    }

    @GetMapping("/{id}/profiles/{profileId}")
    public ResponseEntity<RestResponse<ProfileResponseDto>> retrieveProfile(@PathVariable @NotNull Long id,
                                                                            @PathVariable @NotNull Long profileId) {
        return userProfileService.retrieveProfile(id, profileId);
    }

    @PutMapping("/{id}/profiles/{profileId}")
    public ResponseEntity<Void> updateProfile(@PathVariable @NotNull Long id, @PathVariable @NotNull Long profileId,
                                              @RequestBody @Valid ProfileRequestDto profileRequestDto) {
        return userProfileService.updateProfile(id, profileId, profileRequestDto);
    }

    @DeleteMapping("/{id}/profiles/{profileId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable @NotNull Long id, @PathVariable @NotNull Long profileId) {
        return userProfileService.deleteProfile(id, profileId);
    }

    @PatchMapping("/{id}/profiles/{profileId}")
    public ResponseEntity<Void> updateStatus(@PathVariable @NotNull Long id, @PathVariable @NotNull Long profileId,
                                             @RequestBody @Valid UpdateStatusRequestDto updateStatusRequestDto) {
        return userProfileService.updateStatus(id, profileId, updateStatusRequestDto);
    }
}
