package com.learn.tavant.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WelcomeResponse {


    private String author = "Anil Yaduvanshi";

    /*
        @JsonIgnore
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        Both works when converting java object to Json By jackson,
        so we can use property in code.
    */
    @JsonIgnore
    private String projectName = "Tavant Learning";

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime startDate = LocalDateTime.of(2024, 1, 4, 9,30, 0,0);

    private String about = "welcome to my world";
}
