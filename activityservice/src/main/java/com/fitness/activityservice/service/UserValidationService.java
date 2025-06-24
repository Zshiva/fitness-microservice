package com.fitness.activityservice.service;

import com.fitness.exception.FitnessErrorMessage;
import com.fitness.exception.FitnessException;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserValidationService {
    private final WebClient userServiceWebClient;

    public boolean validateUser(String userId){
        log.info("Calling User Validation API for userId : {}", userId);
        try {
            var env = Dotenv.load();
            String uri = env.get("USER_ID_VALIDATION");
            return userServiceWebClient.get()
                    .uri(uri, userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.NOT_FOUND)
                throw new FitnessException(FitnessErrorMessage.USER_NOT_FOUND);
            else if(e.getStatusCode() == HttpStatus.BAD_REQUEST)
                throw new FitnessException(FitnessErrorMessage.INVALID_REQUEST);
        }

        return false;
    }
}
