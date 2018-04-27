package br.com.alura.loja.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.loja.dao.ProjetoDAO;

@Controller
@RequestMapping("/projetos")
public class ProjetoRecource {

	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<byte[]> getXml(final ModelMap map, final HttpServletResponse response) {

		final String xml = new ProjetoDAO().busca(1l).toXML();

		final byte[] documentBody = xml.getBytes();

		final HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "xml"));
		header.setContentLength(documentBody.length);
		return new HttpEntity<>(documentBody, header);
	}
}
