package ufc.quixada.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.model.Estabelecimento;
import ufc.quixada.repository.CoordenadaRepository;
import ufc.quixada.repository.EstabelecimentoRepository;

@Controller
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	private CoordenadaRepository coordenadaRepository;

	@RequestMapping("/")
	public ModelAndView mapa() {
		return new ModelAndView("mapa");
	}
	
	@RequestMapping("/getEstabelecimentos")
	public @ResponseBody List<Estabelecimento> buscarEstabelecimentos(){
		return estabelecimentoRepository.findAll();
	}
	
	@RequestMapping("/rank")
	public ModelAndView rank() {
		ModelAndView mv = new ModelAndView("rank");
		mv.addObject("estabelecimentos", estabelecimentoRepository.findAll());
		mv.addObject("estabelecimento", new Estabelecimento());
		return mv;
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView adicionar(@Valid @ModelAttribute("estabelecimento") Estabelecimento estabelecimento) {
		ModelAndView mv = new ModelAndView("rank");
		
		coordenadaRepository.save(estabelecimento.getCoordenada());
		estabelecimentoRepository.save(estabelecimento);
		
		mv.addObject("estabelecimentos", estabelecimentoRepository.findAll());
		mv.addObject("estabelecimento", new Estabelecimento());
		return mv;
	}
}
