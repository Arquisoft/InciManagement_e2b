package asw.incidences.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import asw.dbManagement.model.Incidence;

@RestController
public class IncidenceRestController {

	@RequestMapping(value = "/incidence/send", method = RequestMethod.POST, headers = { "Accept=application/json",
			"Accept=application/xml" })
	public String sendIncidence(@ModelAttribute("incidence") Incidence incidence) {
		String usuario = incidence.getUsuario();
		String pass = incidence.getPassword();
		//String kind = incidence.get;
		System.out.println(usuario);
		try {
			HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/user")
					  .header("content-type", "application/json")
					  .header("cache-control", "no-cache")
					  .body("{\n\"login\":\""+usuario+"\",\n\"password\":\""+pass+"\",\n\"kind\":\"1\"\n}\n")
					  .asJson();
			
			System.out.println(response.getBody().toString());
			if(response.getStatus() != 200){
				return response.getBody().toString();
			}else if(response.getStatus() == 200){
				return response.getBody().toString();
			}
			return "{\"error\": \"Could not find response\"}";
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return "{\"error\": \"Could not connect\"}";
	}

	@ModelAttribute("incidence")
	public Incidence getIncidence(){
	    return new Incidence();
	}
}
