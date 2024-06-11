public class Seminar extends Event {
    private String topic;

    public Seminar(String title, String date, String location, String topic) {
        super(title, date, location);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Topic: " + topic);
    }
}
