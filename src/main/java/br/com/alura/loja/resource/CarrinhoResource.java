package br.com.alura.loja.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoResource {
	@Autowired
	private CarrinhoDAO carrinhoDao;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public String getXml(@PathVariable("id") final Integer id) {
		String xml = "";
		try {
			xml = this.carrinhoDao.busca(id).toXML();
		} catch (final Exception e) {

		}
		return xml;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/json")
	public Carrinho getJson(@PathVariable("id") final Integer id) {
		return this.carrinhoDao.busca(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adiciona(@RequestBody final Carrinho carrinho) {
		this.carrinhoDao.adiciona(carrinho);
		final ModelAndView mav = new ModelAndView();
		mav.setStatus(HttpStatus.CREATED);
		return mav;
	}

}
