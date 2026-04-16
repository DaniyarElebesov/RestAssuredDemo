package staticData;

import lombok.Getter;

import static org.apache.http.HttpStatus.*;

public enum StatusCodes {
    HTTP_OK(SC_OK),
    HTTP_CREATED(SC_CREATED),
    HTTP_NO_CONTENT(SC_NO_CONTENT),
    HTTP_BAD_REQUEST(SC_BAD_REQUEST),
    HTTP_NOT_FOUND(SC_NOT_FOUND);
    @Getter
    private final int status;

    StatusCodes(int status){
        this.status = status;
    }
}
