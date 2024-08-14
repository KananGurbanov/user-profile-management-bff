package az.edu.turing.userprofilemanagementbff.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record UserResponseDto(
        String name,
        Integer age,
        List<ProfileResponseDto> profiles) {
}
