import java.util.ArrayList;

public class Company {
    private ArrayList<Event> events;
    private ArrayList<Person> participants;

    public Company() {
        events = new ArrayList<>();
        participants = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void addParticipant(Person person) {
        participants.add(person);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<Person> getParticipants() {
        return participants;
    }

    public void displayEvents() {
        for (Event event : events) {
            event.displayInfo();
        }
    }

    public void displayParticipants() {
        for (Person person : participants) {
            person.displayInfo();
        }
    }
}