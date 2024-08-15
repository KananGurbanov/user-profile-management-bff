package az.edu.turing.userprofilemanagementbff.dto;


import az.edu.turing.userprofilemanagementbff.enums.SocialMediaType;
import az.edu.turing.userprofilemanagementbff.enums.Status;

public record ProfileResponseDto(
        String mailAddress,
        String password,
        Status status,
        SocialMediaType socialMediaType,
        String image) {
}
