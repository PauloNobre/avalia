package ufc.quixada.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.model.Avaliacao;
import ufc.quixada.model.Estabelecimento;
import ufc.quixada.repository.AvaliacaoRepository;
import ufc.quixada.repository.CoordenadaRepository;
import ufc.quixada.repository.EstabelecimentoRepository;

@Controller
public class EstabelecimentoController {
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private CoordenadaRepository coordenadaRepository;
	
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
	
	@RequestMapping("/avaliar/{id}")
	public ModelAndView avaliarForm(@PathVariable("id") Integer id) {
		ModelAndView mv;
		Estabelecimento e = estabelecimentoRepository.findOne(id);
		
		if(e == null) {
			mv = new ModelAndView("rank");
			mv.addObject("estabelecimentos", estabelecimentoRepository.findAll());
			mv.addObject("estabelecimento", new Estabelecimento());
			return mv;
		}
		
		mv = new ModelAndView("avaliacao");
		mv.addObject("estabelecimento", e);
		mv.addObject("avaliacao", new Avaliacao());
		return mv;
	}
	
	@RequestMapping(value="/avaliar/{idEstabelecimento}", method=RequestMethod.POST)
	public String avaliar(@Valid @ModelAttribute("avaliacao") Avaliacao avaliacao, 
			@PathVariable("idEstabelecimento") Integer id) {
		
		Estabelecimento estabelecimento = estabelecimentoRepository.findOne(id);
		
		avaliacao.setEstabelecimento(estabelecimento);
		avaliacao.setMedia();
		avaliacaoRepository.save(avaliacao);
		
		estabelecimento.addAvaliacao(avaliacao);
		estabelecimentoRepository.save(estabelecimento);
		return "redirect:/rank";
	}
}
