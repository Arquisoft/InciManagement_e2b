package asw.incidences.service;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class IncidenceService {

	public HttpResponse<JsonNode> checkUser(String user, String pass, String kind) throws UnirestException{
		HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/user")
				  .header("content-type", "application/json")
				  .header("cache-control", "no-cache")
				  .body("{\n\"login\":\""+user+"\",\n\"password\":\""+pass+"\",\n\"kind\":\""+kind+"\"\n}\n")
				  .asJson();
		return response;
		
	}
	
}
