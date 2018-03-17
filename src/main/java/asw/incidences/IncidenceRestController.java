package asw.incidences;

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
	public void sendIncidence(@ModelAttribute Incidence incidence) {
		String usuario = incidence.getUsuario();
		String pass = incidence.getPassword();
		//String kind = incidence.get;
		try {
			HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/user")
					  .header("content-type", "application/json")
					  .header("cache-control", "no-cache")
					  .body("{\n\"login\":\""+usuario+"\",\n\"password\":\""+pass+"\",\n\"kind\":\"1\"\n}\n")
					  .asJson();
			
			
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		

	}

}
