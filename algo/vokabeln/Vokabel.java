public class Vokabel {
    private String deutsch = "-1";
    private String englisch = "-2";

    public Vokabel(String deutsch, String englisch) {
        this.deutsch = deutsch;
        this.englisch = englisch;
    }

    public String getDeutsch() {
        return deutsch;
    } 

    public String getEnglisch() {
        return englisch;
    } 

    public String toString() {
        return (deutsch + " : " + englisch);
    }
}