package br.com.alura.loja.conf;

import java.util.Locale;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class JsonViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(final String arg0, final Locale arg1) throws Exception {
		final MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		jsonView.setPrettyPrint(true);
		return jsonView;
	}

}
