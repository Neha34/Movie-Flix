package movie.flix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class badRequestException extends RuntimeException {

	private static final long serialVersionUID = 7892077233097012831L;
	public badRequestException(String message) {
		super(message);
	}
	
	public badRequestException(String message, Throwable cause) {
		
	    super(message, cause);
	}

}
