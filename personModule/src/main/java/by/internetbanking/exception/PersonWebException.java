package by.internetbanking.exception;

import java.util.List;

public class PersonWebException extends RuntimeException {

    List<String> messageList;

    public PersonWebException(List<String> messageList) {
        this.messageList = messageList;
    }


    public PersonWebException(String message) {
        super(message);

    }


}
