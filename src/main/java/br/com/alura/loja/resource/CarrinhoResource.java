package br.com.alura.loja.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.loja.dao.CarrinhoDAO;

@Controller
@RequestMapping("/carrinhos")
public class CarrinhoResource {

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public HttpEntity<byte[]> getXml(@PathVariable("id") final Integer id, final ModelMap map,
			final HttpServletResponse response) {
		final String xml = new CarrinhoDAO().busca(id).toXML();

		final byte[] documentBody = xml.getBytes();

		final HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "xml"));
		header.setContentLength(documentBody.length);
		return new HttpEntity<>(documentBody, header);
	}
}
