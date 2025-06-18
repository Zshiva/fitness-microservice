package com.fitness.exception;

public class FitnessException extends RuntimeException{
    private final FitnessErrorMessage fitnessErrorMessage;

    public FitnessException(FitnessErrorMessage fitnessErrorMessage){
        super(fitnessErrorMessage.getMessage());
        this.fitnessErrorMessage = fitnessErrorMessage;
    }
    public FitnessErrorMessage getFitnessErrorMessage(){
        return fitnessErrorMessage;
    }
}
