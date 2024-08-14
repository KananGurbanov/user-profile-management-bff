package az.edu.turing.userprofilemanagementbff.exceptions;

public class RecordNotFoundException extends CustomValidationException {
    public RecordNotFoundException(String code, String message) {
        super(code, message);
    }
}
