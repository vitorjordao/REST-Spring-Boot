package br.com.alura.loja.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

@Controller
@RequestMapping("/carrinhos")
public class CarrinhoResource {
	@Autowired
	private CarrinhoDAO carrinhoDao;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/xml")
	public HttpEntity<byte[]> getXml(@PathVariable("id") final Integer id, final ModelMap map,
			final HttpServletResponse response) {
		final String xml = this.carrinhoDao.busca(id).toXML();

		final byte[] documentBody = xml.getBytes();

		final HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "xml"));
		header.setContentLength(documentBody.length);
		return new HttpEntity<>(documentBody, header);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/json")
	@ResponseBody
	public Carrinho getJson(@PathVariable("id") final Integer id) {
		return this.carrinhoDao.busca(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adiciona(final String conteudo, final ModelMap map, final HttpServletResponse response) {
		final Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		this.carrinhoDao.adiciona(carrinho);
		final ModelAndView mav = new ModelAndView("redirect:/carrinhos");
		mav.setStatus(HttpStatus.CREATED);
		return mav;
	}

}
