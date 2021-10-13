package ndk.utils_android1;

import java.util.Map;

public class FireStoreRequestResponse {

    int status;
    Map<String, Object> data;
    Exception exception;

    public FireStoreRequestResponse(int status, Map<String, Object> data, Exception exception) {
        this.status = status;
        this.data = data;
        this.exception = exception;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
