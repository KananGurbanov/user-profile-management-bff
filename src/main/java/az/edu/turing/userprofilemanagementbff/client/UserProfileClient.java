package az.edu.turing.userprofilemanagementbff.client;

import az.edu.turing.userprofilemanagementbff.dto.*;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "user-profile", url = "${feign.client.config.user-profile.url")
public interface UserProfileClient {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RestResponse<Long>> createUser(@RequestBody @Valid UserRequestDto userCreateRequestDto);

    @GetMapping("/{id}")
    ResponseEntity<RestResponse<UserResponseDto>> getUserById(@PathVariable @NotNull Long id);

    @GetMapping
    ResponseEntity<RestResponse<List<UserResponseDto>>> getAllUsers();

    @PutMapping("/{id}")
    ResponseEntity<Void> updateUser(@PathVariable @NotNull Long id,
                                    @RequestBody @Valid UserRequestDto userUpdateRequestDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable @NotNull Long id);

    @GetMapping("/count")
    ResponseEntity<Long> getCountUsers();

    @GetMapping("/{id}/profiles")
    ResponseEntity<RestResponse<List<ProfileResponseDto>>> getAllProfiles(@PathVariable @NotNull Long id);


    @PostMapping("/{id}/profiles")
    ResponseEntity<RestResponse<Long>> addProfile(@PathVariable @NotNull Long id,
                                                  @RequestBody @Valid ProfileRequestDto profileRequestDto);

    @GetMapping("/{id}/profiles/{profileId}")
    ResponseEntity<RestResponse<ProfileResponseDto>> retrieveProfile(@PathVariable @NotNull Long id,
                                                                     @PathVariable @NotNull Long profileId);

    @PutMapping("/{id}/profiles/{profileId}")
    ResponseEntity<Void> updateProfile(@PathVariable @NotNull Long id, @PathVariable @NotNull Long profileId,
                                       @RequestBody @Valid ProfileRequestDto profileRequestDto);

    @DeleteMapping("/{id}/profiles/{profileId}")
    ResponseEntity<Void> deleteProfile(@PathVariable @NotNull Long id, @PathVariable @NotNull Long profileId);

    @PatchMapping("/{id}/profiles/{profileId}")
    ResponseEntity<Void> updateStatus(@PathVariable @NotNull Long id, @PathVariable @NotNull Long profileId,
                                      @RequestBody @Valid UpdateStatusRequestDto updateStatusRequestDto);
}
