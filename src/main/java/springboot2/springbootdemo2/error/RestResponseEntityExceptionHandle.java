package springboot2.springbootdemo2.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import springboot2.springbootdemo2.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
class RestResponseEntityExceptionHandle extends ResponseEntityExceptionHandler  {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFouMessageResponseEntity(DepartmentNotFoundException exception, WebRequest request)
    {
ErrorMessage errorMessage= new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
