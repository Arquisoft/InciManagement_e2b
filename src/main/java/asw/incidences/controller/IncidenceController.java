package asw.incidences.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IncidenceController {

	@RequestMapping("/")
	public String send(){
		return "input";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/input")
	public String sended(Model m){
		
		return "input";
	}
	
	
}
