package stepDefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Credentials;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.HashMap;

public class RequestAuthorize {

    private String URL = "http://207.154.242.0:8888/v1/authorize";

    public HashMap getAuthorize(Credentials credentials) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String responseToParse = "";

        try {
            RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, credentials, String.class);
            responseToParse = responseEntity.getBody();

            } catch (HttpStatusCodeException e) {
            if (e.getStatusCode().value() >= 400) {
                responseToParse = e.getResponseBodyAsString();
                }
        }
        return mapper.readValue(responseToParse, HashMap.class);
    }
}
