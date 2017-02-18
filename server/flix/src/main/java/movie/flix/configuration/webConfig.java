package movie.flix.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration 
@ComponentScan("movie.flix.*") 
@EnableWebMvc 

public class webConfig {

    
}