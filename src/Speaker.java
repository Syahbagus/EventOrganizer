public class Speaker extends Person {
    private String expertise;

    public Speaker(String name, String email, String expertise) {
        super(name, email);
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }
}
