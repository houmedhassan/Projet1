package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author HOUMED, ABDOULRAHIM
 *
 */
@Controller
@RequestMapping("/annuaire")
public class AnnuaireController {
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView indexAction(){
		return new ModelAndView("hello");
		
	}
}
