package com.fitness.activityservice.service;

import com.fitness.exception.FitnessErrorMessage;
import com.fitness.exception.FitnessException;
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
            return userServiceWebClient.get()
                    .uri("/api/users/{userId}/validate", userId)
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
