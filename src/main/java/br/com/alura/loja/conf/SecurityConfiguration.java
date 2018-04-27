package br.com.alura.loja.conf;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//import br.com.casadocodigo.loja.daos.UsuarioDAO;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UsuarioDAO usuarioDao;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/carrinhos.json").permitAll()
				.antMatchers("/carrinhos/**").permitAll()
				.antMatchers("/projetos.json").permitAll()
				.antMatchers("/projetos/**").permitAll()
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(usuarioDao).passwordEncoder(new BCryptPasswordEncoder());
//	}
}
