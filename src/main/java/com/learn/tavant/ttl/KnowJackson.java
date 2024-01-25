package com.learn.tavant.ttl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Component
public class KnowJackson {

    public ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    public void convertObjectToJson() throws IOException {
        HashMap<String, String> map = new HashMap<>();

        map.put("name", "anil");
        map.put("designation", "software engineer");

        mapper.writeValue(new File("sample.json"), map);
        System.out.println("<><><> Running after constructing");
    }

    @PreDestroy
    public void preDestroyCheck(){
        System.out.println("<><><> Running before destructing");
    }

}
