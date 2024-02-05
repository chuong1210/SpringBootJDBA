package springboot2.springbootdemo2.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import springboot2.springbootdemo2.entity.ErrorMessage;

@ControllerAdvice
public class FileUploadException {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorMessage> fileUploadNotFoundException(MaxUploadSizeExceededException exception, WebRequest request)
    {
//        ErrorMessage errorMessage= new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
//        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        ErrorMessage errorMessage= new ErrorMessage(HttpStatus.EXPECTATION_FAILED,"One or more file to large! ");
        return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errorMessage);
    }

}
