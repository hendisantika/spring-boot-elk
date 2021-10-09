package com.hendisantika.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elk
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/10/21
 * Time: 07.41
 */
@Service
public class RestService {

    private static final String BASE_URL = "https://goweather.herokuapp.com/weather/";
    private static final Logger log = LoggerFactory.getLogger("outbound-logs");
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public JsonNode getPostsPlainJSON(String city) {
        log.info("Getting Weather Information for {}", city);
        String url = BASE_URL + city;
        log.info("Final URL => {}", url);
        try {
            String response = this.restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            log.info("Response => {}", response);
            return mapper.readTree(response);
        } catch (Exception e) {
            log.info("Error occurred in Outbound Request... => {}", e.getMessage());
        }
        return null;
    }
}
