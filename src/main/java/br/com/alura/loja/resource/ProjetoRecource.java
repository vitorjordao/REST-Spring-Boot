package br.com.alura.loja.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

@RestController
@RequestMapping("/projetos")
public class ProjetoRecource {
	@Autowired
	private ProjetoDAO projetoDao;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public String getXml2(@PathVariable("id") final Long id) {

		String xml = "";

		try {
			final Projeto busca = this.projetoDao.busca(id);
			xml = busca.toXML();

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return xml;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/json")
	public Projeto getJson(@PathVariable("id") final Long id) {
		return this.projetoDao.busca(id);
	}

	@PostMapping
	public ModelAndView adiciona(@RequestBody final Projeto projeto) {
		this.projetoDao.adiciona(projeto);
		final ModelAndView mav = new ModelAndView();
		mav.setStatus(HttpStatus.CREATED);
		return mav;
	}
}
