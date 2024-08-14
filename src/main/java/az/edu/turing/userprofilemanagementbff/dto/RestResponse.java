package az.edu.turing.userprofilemanagementbff.dto;

import lombok.Builder;

@Builder
public record RestResponse<T> (String status, T data) {
}
