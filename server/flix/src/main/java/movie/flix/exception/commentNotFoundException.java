package movie.flix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class commentNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1724974318749814804L;
	
	public commentNotFoundException(String message) {
		super(message);
	}
	
	public commentNotFoundException(String message, Throwable cause){
		
		super(message,cause);
	}
	

}
