package movie.flix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class movieNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -545376192484122034L;
	
	public movieNotFoundException(String message) {
		super(message);
	}
	
	public movieNotFoundException(String message, Throwable cause){
		super(message, cause);
	}
	
}
