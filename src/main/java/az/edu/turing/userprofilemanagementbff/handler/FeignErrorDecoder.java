package az.edu.turing.userprofilemanagementbff.handler;

import az.edu.turing.userprofilemanagementbff.exceptions.BadRequestException;
import az.edu.turing.userprofilemanagementbff.exceptions.RecordNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException("400","Bad Request");
            case 404:
                return new RecordNotFoundException("404","Record not found");
            default:
                return new Exception("Unknown error occurred. Status code: " + response.status());
        }
    }
}