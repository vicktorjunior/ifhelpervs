package ifrs.canoas.model.portal;

public class User {

    public String token = "";

    private int userid;
    private String fullname;
    private String userpictureurl;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return "=> " + userid + " " + fullname + " " + userpictureurl;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserpictureurl() {
        return userpictureurl;
    }

    public void setUserpictureurl(String userpictureurl) {
        this.userpictureurl = userpictureurl;
    }
}
