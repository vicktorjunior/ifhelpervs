package ifrs.canoas.model.portal;

/**
 * Created by marcio on 27/08/17.
 */

public class Curso {

    private int id;
    private String shortname;
    private String fullname;
    private int visible;
    private String format;
    private boolean showgrades;
    private String lang;
    private boolean enablecompletion;
    private int category;
    private String summary = "Curso sem descrição";

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isShowgrades() {
        return showgrades;
    }

    public void setShowgrades(boolean showgrades) {
        this.showgrades = showgrades;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isEnablecompletion() {
        return enablecompletion;
    }

    public void setEnablecompletion(boolean enablecompletion) {
        this.enablecompletion = enablecompletion;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Curso Bonitinho " +
                "id=" + id +
                ", shortname='" + shortname + '\'' +
                ", fullname='" + fullname + '\'' +
                ", visible=" + visible +
                ", format='" + format + '\'' +
                ", showgrades=" + showgrades +
                ", lang='" + lang + '\'' +
                ", enablecompletion=" + enablecompletion +
                ", category=" + category +
                '}';
    }
}
