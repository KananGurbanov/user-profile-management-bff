package az.edu.turing.userprofilemanagementbff.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.util.List;

@Builder
public record UserRequestDto(
        @NotBlank
        String name,

        @Min(18)
        Integer age,

        @NotEmpty
        @Valid
        List<ProfileRequestDto> profiles) {
}
