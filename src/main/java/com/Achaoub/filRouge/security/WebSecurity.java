package com.Achaoub.filRouge.security;






import com.Achaoub.filRouge.services.ClientService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	private final ClientService clientDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	private UserPrincipalDetailsService userPrincipalDetailsService;
//    private UserRepository userRepository;
	
//	public WebSecurity(UserPrincipalDetailsService userPrincipalDetailsService, UserRepository userRepository) {
//        this.userPrincipalDetailsService = userPrincipalDetailsService;
//        this.userRepository = userRepository;
//    }
	
	public WebSecurity(ClientService clientDetailsService,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.clientDetailsService = clientDetailsService;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and()
			.csrf().disable()
				.authorizeRequests()
					.antMatchers(HttpMethod.POST,"/users")
						.permitAll()
				.and().authorizeRequests()
					.antMatchers(HttpMethod.GET,SecurityConstants.SIGN_UP_URL)
						.permitAll()
					.anyRequest().authenticated()
					.and()
					.addFilter(getAuthenticationFilter()) 
					.addFilter(new AuthorizationFilter(authenticationManager())) //donner acces avec un token voir classe AuthorizationFilter
					.sessionManagement() // necessaire --> microServices pour lier une session d'un user avec le token qui lui correspond
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//					.and()
//				.formLogin().and()
//				.httpBasic()
					;
	}
	
	
	// Personnalise url par defaut /login du spring security par le notre dans mon cas /users/login
	protected AuthentificationFilter getAuthenticationFilter() throws Exception{
		final AuthentificationFilter filter = new AuthentificationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
	}
	

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(clientDetailsService).passwordEncoder(bCryptPasswordEncoder);
		//auth.authenticationProvider(authenticationProvider());
	}
	


}
