package ifrs.canoas.model.portal;

/**
 * Created by VictorJr on 10/09/2017.
 */

public class Mensagem {

    private int id;
    private int useridfrom;
    private int useridto;
    private String subject;
    private String text;
    private String fullmessage;
    private int fullmessageformat;
    private String fullmessagehtml;
    private String smallmessage;
    private int notification;
    private String contexturl;
    private String contexturlname;
    private Long timecreated;
    private Long timeread;
    private String usertofullname;
    private String userfromfullname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUseridfrom() {
        return useridfrom;
    }

    public void setUseridfrom(int useridfrom) {
        this.useridfrom = useridfrom;
    }

    public int getUseridto() {
        return useridto;
    }

    public void setUseridto(int useridto) {
        this.useridto = useridto;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFullmessage() {
        return fullmessage;
    }

    public void setFullmessage(String fullmessage) {
        this.fullmessage = fullmessage;
    }

    public int getFullmessageformat() {
        return fullmessageformat;
    }

    public void setFullmessageformat(int fullmessageformat) {
        this.fullmessageformat = fullmessageformat;
    }

    public String getFullmessagehtml() {
        return fullmessagehtml;
    }

    public void setFullmessagehtml(String fullmessagehtml) {
        this.fullmessagehtml = fullmessagehtml;
    }

    public String getSmallmessage() {
        return smallmessage;
    }

    public void setSmallmessage(String smallmessage) {
        this.smallmessage = smallmessage;
    }

    public int getNotification() {
        return notification;
    }

    public void setNotification(int notification) {
        this.notification = notification;
    }

    public String getContexturl() {
        return contexturl;
    }

    public void setContexturl(String contexturl) {
        this.contexturl = contexturl;
    }

    public String getContexturlname() {
        return contexturlname;
    }

    public void setContexturlname(String contexturlname) {
        this.contexturlname = contexturlname;
    }

    public Long getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Long timecreated) {
        this.timecreated = timecreated;
    }

    public Long getTimeread() {
        return timeread;
    }

    public void setTimeread(Long timeread) {
        this.timeread = timeread;
    }

    public String getUsertofullname() {
        return usertofullname;
    }

    public void setUsertofullname(String usertofullname) {
        this.usertofullname = usertofullname;
    }

    public String getUserfromfullname() {
        return userfromfullname;
    }

    public void setUserfromfullname(String userfromfullname) {
        this.userfromfullname = userfromfullname;
    }

    @Override
    public String toString() {
        return "Mensagem Bonitinha" +
                "id=" + id +
                ", useridfrom=" + useridfrom +
                ", useridto=" + useridto +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", fullmessage='" + fullmessage + '\'' +
                ", fullmessageformat=" + fullmessageformat +
                ", fullmessagehtml='" + fullmessagehtml + '\'' +
                ", smallmessage='" + smallmessage + '\'' +
                ", notification=" + notification +
                ", contexturl='" + contexturl + '\'' +
                ", contexturlname='" + contexturlname + '\'' +
                ", timecreated=" + timecreated +
                ", timeread=" + timeread +
                ", usertofullname='" + usertofullname + '\'' +
                ", userfromfullname='" + userfromfullname + '\'' +
                '}';
    }
}
