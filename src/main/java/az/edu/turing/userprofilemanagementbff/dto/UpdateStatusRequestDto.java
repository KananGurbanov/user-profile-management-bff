package az.edu.turing.userprofilemanagementbff.dto;

import az.edu.turing.userprofilemanagementbff.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UpdateStatusRequestDto(
        @NotNull
        Status status) {
}
