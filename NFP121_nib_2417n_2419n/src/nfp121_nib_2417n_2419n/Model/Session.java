package nfp121_nib_2417n_2419n.Model;

public class Session {
    private String sessionId;
    private String userId;
    private String startTime;
    private String endTime;
    private String duration;

    public Session(String sessionId, String userId, String startTime, String endTime, String duration) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDuration() {
        return duration;
    }
}
