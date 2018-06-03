package br.com.alura.loja.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

@Controller
@RequestMapping("/projetos")
public class ProjetoRecource {
	@Autowired
	private ProjetoDAO projetoDao;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/xml")
	public HttpEntity<byte[]> getXml(@PathVariable("id") final Integer id, final ModelMap map,
			final HttpServletResponse response) {

		final String xml = this.projetoDao.busca(id).toXML();

		final byte[] documentBody = xml.getBytes();

		final HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "xml"));
		header.setContentLength(documentBody.length);
		return new HttpEntity<>(documentBody, header);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/json")
	@ResponseBody
	public Projeto getJson(@PathVariable("id") final Integer id) {
		return this.projetoDao.busca(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String adiciona(final String conteudo) {
		final Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		this.projetoDao.adiciona(projeto);
		return "<status> sucesso </status>";
	}
}
