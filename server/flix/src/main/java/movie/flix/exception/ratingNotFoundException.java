package movie.flix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ratingNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5231187020966243549L;
	
	public ratingNotFoundException(String message){
		
		super(message);
	}
	
	public ratingNotFoundException(String message, Throwable cause){
		
		super(message, cause);
	}

	
}
