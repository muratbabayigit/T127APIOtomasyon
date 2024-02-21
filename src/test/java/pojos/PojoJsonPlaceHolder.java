package pojos;

public class PojoJsonPlaceHolder {
     // 1- tum variable'lari private olarak olustur
    /*
     {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

     */
        private String title;
        private String body;
        private int userId;
        private int id;


    // 2- tum variable'lar icin getter ve setter metodlari olusturalim

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3- tum parametreleri kullanarak bir constructor olusturalim

    public PojoJsonPlaceHolder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4- default constructor yerine manuel olarak parametresiz bir constructor olusturalim

    public PojoJsonPlaceHolder() {
    }

    // 5- toString metodu olusturalim


    @Override
    public String toString() {
        return "PojoJsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
