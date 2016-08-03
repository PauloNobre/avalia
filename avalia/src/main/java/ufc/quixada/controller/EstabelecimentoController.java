package ufc.quixada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.model.Estabelecimento;
import ufc.quixada.repository.EstabelecimentoRepository;

@Controller
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@RequestMapping("/")
	public ModelAndView mapa() {
		return new ModelAndView("mapa");
	}
	
	@RequestMapping("/getEstabelecimentos")
	public @ResponseBody List<Estabelecimento> buscarEstabelecimentos(){
		return estabelecimentoRepository.findAll();
	}
}
