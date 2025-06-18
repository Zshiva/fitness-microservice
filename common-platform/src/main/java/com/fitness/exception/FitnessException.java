package com.fitness.exception;

public class FitnessException extends RuntimeException{
    private final FitnessErrorMessage fitnessErrorMessage;

    public FitnessException(FitnessErrorMessage errorMessage){
        super(errorMessage.getMessage());
        this.fitnessErrorMessage = errorMessage;
    }
    public FitnessErrorMessage getFitnessErrorMessage(){
        return fitnessErrorMessage;
    }
}
