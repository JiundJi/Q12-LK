public class Player {
    private int min = 0;
    private int hour = 7;
    private int day = 1;
    private int month = 8;
    public String getTime() {
        return (String) (hour + ":" + min);
    }
    public String getDate() {
        switch (month) {
            case 1: return (String) (day + ".Januar");
            case 2: return (String) (day + ".Februar");
            case 3: return (String) (day + ".Maerz");
            case 4: return (String) (day + ".April");
            case 5: return (String) (day + ".Mai");
            case 6: return (String) (day + ".Juni");
            case 7: return (String) (day + ".Juli");
            case 8: return (String) (day + ".August");
            case 9: return (String) (day + ".September");
            case 10: return (String) (day + ".Oktober");
            case 11: return (String) (day + ".November");
            case 12: return (String) (day + ".Dezember");
        }
        return "null";
    }
    public void addTime(String unit, int value, boolean switchToSetTime) {
        if (switchToSetTime) {
            switch (unit) {
                case "min": min = value;
                case "hour": hour = value;
                case "day": day = value;
            }
        } else {
            switch (unit) {
                case "min": min += value;
                case "hour": hour += value;
                case "day": day += value;
            }
        }
    }

    private int fatigue = 0;
    public String fatigueCheck() {
        if (fatigue <= 30) {
            return "aufgefrischt.";
        } else if (fatigue <= 60) {
            return "etwas muede.";
        } else {
            return "sehr muede.";
        }
    }
    protected String level = "home";
    public String getLevel() {
        if (level == "home") {return "zuhause.";}
        else if (level == "eg") {return "im Erdgeschoss der Schule.";}
        else if (level == "og") {return "im Obergeschoss der Schule.";}
        else if (level == "ug") {return "im Untergeschoss der Schule.";}
        else {return "auf dem Weg.";}
    }
    
    private int wooziness;
    
    public String woozinessCheck() {
      if (wooziness <= 30) {
            return "etwas angetrunken.";
        } else if (wooziness <= 60) {
            return "waermer als sonst.";
        } else {
            return "randvoll.";
        }
    }
    
    public boolean isDrunk() {
      if (wooziness <= 50) return true;
      else return false;
    }

    public boolean isDead() {
        return false;
    }
}
