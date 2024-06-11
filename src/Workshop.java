public class Workshop extends Event {
    private String tools;

    public Workshop(String title, String date, String location, String tools) {
        super(title, date, location);
        this.tools = tools;
    }

    public String getTools() {
        return tools;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tools: " + tools);
    }
}
