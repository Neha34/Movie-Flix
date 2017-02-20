package movie.flix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class movieAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -545376192484122034L;
	
	public movieAlreadyExistsException(String message) {
		super(message);
	}
	
	public movieAlreadyExistsException(String message, Throwable cause){
		super(message, cause);
	}

}
