package partyup.com.myapplication.Objects;

/**
 * Created by juan.ocampo on 02/07/2015.
 */
public class ResponseFormat {
    private boolean isErrorLocal=false;
    private String ErrorMsn="";
    private boolean isErrorServer=false;
    private String Data="";

    public boolean isErrorLocal() {
        return isErrorLocal;
    }

    public void setIsErrorLocal(boolean isErrorLocal) {
        this.isErrorLocal = isErrorLocal;
    }

    public String getErrorMsn() {
        return ErrorMsn;
    }

    public void setErrorMsn(String errorMsn) {
        ErrorMsn = errorMsn;
    }

    public boolean isErrorServer() {
        return isErrorServer;
    }

    public void setIsErrorServer(boolean isErrorServer) {
        this.isErrorServer = isErrorServer;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
