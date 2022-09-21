package me.study.demomongo.pat;

public class NotExistException extends RuntimeException{

    private final static String MESSAGE = "존재하지 않습니다.";

    public NotExistException() {
        super(MESSAGE);
    }
}
