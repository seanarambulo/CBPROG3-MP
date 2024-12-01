public class ShuttleRoute {
    private String time;
    private String LineName;

    public ShuttleRoute(String time, String LineName) {
        this.time = time;
        this.LineName = LineName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLineName() {
        return LineName;
    }

    public void setLineName(String LineName) {
        this.LineName = LineName;
    }
}

