package ufc.quixada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EstabelecimentoController {

	@RequestMapping("/")
	public ModelAndView mapa() {
		ModelAndView mv = new ModelAndView("mapa");
		
		return mv;
	}
}
