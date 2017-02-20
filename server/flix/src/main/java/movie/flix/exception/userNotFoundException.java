package movie.flix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class userNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7892077233097012831L;
	public userNotFoundException(String message) {
		super(message);
	}
	
	public userNotFoundException(String message, Throwable cause) {
		
	    super(message, cause);
	}

}
