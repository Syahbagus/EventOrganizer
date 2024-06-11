public class Meeting extends Event {
    private String agenda;

    public Meeting(String title, String date, String location, String agenda) {
        super(title, date, location);
        this.agenda = agenda;
    }

    public String getAgenda() {
        return agenda;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Agenda: " + agenda);
    }
}
