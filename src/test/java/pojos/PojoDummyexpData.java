package pojos;

public class PojoDummyexpData {
    private String status;
    private String message;
    private PojoDummyData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PojoDummyData getData() {
        return data;
    }

    public void setData(PojoDummyData data) {
        this.data = data;
    }



    public PojoDummyexpData(String status, String message, PojoDummyData data) {
        this.status = status;
        this.message = message;
        this.data = data;


    }

    public PojoDummyexpData() {
    }

    @Override
    public String toString() {
        return "PojoDummyexpData{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
