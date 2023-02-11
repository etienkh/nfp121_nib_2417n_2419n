package nfp121_nib_2417n_2419n.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import nfp121_nib_2417n_2419n.MVC.MyObservable;
import nfp121_nib_2417n_2419n.MVC.MyObserver;

public class Session extends MyObservable implements Serializable {
    private String sessionId;
    private String name;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private ArrayList<Person> attendees;

    public Session(String sessionId, String name, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.sessionId = sessionId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        attendees = new ArrayList<Person>();
        this.name = name;
        setChanged();
        notifyObservers();
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
        setChanged();
        notifyObservers();
    }

    public void setDate(LocalDate date) {
        this.date = date;
        setChanged();
        notifyObservers();
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
        setChanged();
        notifyObservers();
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
        setChanged();
        notifyObservers();
    }

    public Session() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public ArrayList<Person> getAttendees() {
        return attendees;
    }

    public void setAttendees(ArrayList<Person> attendees) {
        this.attendees = attendees;
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers();
    }

    public String toString() {
        String s = "";
        s += "Session ID : " + sessionId + "\nSession Name : " + name + "\nDate : " + date.toString() + "\nStarts on "
                + startTime.toString() + " Ends on " + endTime;
        if (attendees.size() > 0) {
            s += "\nAttendees : ";

            for (Person person : attendees) {
                s += "\n" + person.firstName + " " + person.lastName;
            }
        }
        return s;
    }
//     public String toStringStud() {
//        String s = "";
//        s += "Session ID : " + sessionId + "\nSession Name : " + name + "\nDate : " + date.toString() + "\nStarts on "
//                + startTime.toString() + " Ends on " + endTime;
//        return s;
//    }

    public List<MyObserver> getObservers() {
        return super.observers;
    }
}
