import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private Company company;
    private JTextArea textArea;

    public Main() {
        company = new Company();
        createGUI();
    }

    public void createGUI() {
        JFrame frame = new JFrame("CorpEventManager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JButton addMeetingButton = new JButton("Add Meeting");
        JButton addSeminarButton = new JButton("Add Seminar");
        JButton addWorkshopButton = new JButton("Add Workshop");
        JButton addEmployeeButton = new JButton("Add Employee");
        JButton addSpeakerButton = new JButton("Add Speaker");
        JButton displayEventsButton = new JButton("Display Events");

        panel.add(addMeetingButton);
        panel.add(addSeminarButton);
        panel.add(addWorkshopButton);
        panel.add(addEmployeeButton);
        panel.add(addSpeakerButton);
        panel.add(displayEventsButton);

        frame.add(panel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.setVisible(true);

        addMeetingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog(frame, "Enter meeting title:");
                String date = JOptionPane.showInputDialog(frame, "Enter meeting date (YYYY-MM-DD):");
                String location = JOptionPane.showInputDialog(frame, "Enter meeting location:");
                String agenda = JOptionPane.showInputDialog(frame, "Enter meeting agenda:");

                if (title != null && date != null && location != null && agenda != null) {
                    Event meeting = new Meeting(title, date, location, agenda);
                    company.addEvent(meeting);
                    JOptionPane.showMessageDialog(frame, "Meeting added!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Meeting not added. Please provide all details.");
                }
            }
        });

        addSeminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog(frame, "Enter seminar title:");
                String date = JOptionPane.showInputDialog(frame, "Enter seminar date (YYYY-MM-DD):");
                String location = JOptionPane.showInputDialog(frame, "Enter seminar location:");
                String topic = JOptionPane.showInputDialog(frame, "Enter seminar topic:");

                if (title != null && date != null && location != null && topic != null) {
                    Event seminar = new Seminar(title, date, location, topic);
                    company.addEvent(seminar);
                    JOptionPane.showMessageDialog(frame, "Seminar added!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Seminar not added. Please provide all details.");
                }
            }
        });

        addWorkshopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog(frame, "Enter workshop title:");
                String date = JOptionPane.showInputDialog(frame, "Enter workshop date (YYYY-MM-DD):");
                String location = JOptionPane.showInputDialog(frame, "Enter workshop location:");
                String tools = JOptionPane.showInputDialog(frame, "Enter workshop tools:");

                if (title != null && date != null && location != null && tools != null) {
                    Event workshop = new Workshop(title, date, location, tools);
                    company.addEvent(workshop);
                    JOptionPane.showMessageDialog(frame, "Workshop added!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Workshop not added. Please provide all details.");
                }
            }
        });

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter employee name:");
                String email = JOptionPane.showInputDialog(frame, "Enter employee email:");
                String department = JOptionPane.showInputDialog(frame, "Enter employee department:");

                if (name != null && email != null && department != null) {
                    Person employee = new Employee(name, email, department);
                    company.addParticipant(employee);
                    JOptionPane.showMessageDialog(frame, "Employee added!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Employee not added. Please provide all details.");
                }
            }
        });

        addSpeakerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter speaker name:");
                String email = JOptionPane.showInputDialog(frame, "Enter speaker email:");
                String expertise = JOptionPane.showInputDialog(frame, "Enter speaker expertise:");

                if (name != null && email != null && expertise != null) {
                    Person speaker = new Speaker(name, email, expertise);
                    company.addParticipant(speaker);
                    JOptionPane.showMessageDialog(frame, "Speaker added!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Speaker not added. Please provide all details.");
                }
            }
        });

        displayEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Clear the text area

                textArea.append("Meetings:\n");
                for (Event event : company.getEvents()) {
                    if (event instanceof Meeting) {
                        textArea.append("Nama Meeting: " + event.getTitle() + "\n");
                        textArea.append("Hari Tanggal: " + event.getDate() + "\n");
                        textArea.append("Lokasi: " + event.getLocation() + "\n");
                        textArea.append("Agenda: " + ((Meeting) event).getAgenda() + "\n");
                        textArea.append("\n");
                    }
                }

                textArea.append("Seminars:\n");
                for (Event event : company.getEvents()) {
                    if (event instanceof Seminar) {
                        textArea.append("Nama Seminar: " + event.getTitle() + "\n");
                        textArea.append("Hari Tanggal: " + event.getDate() + "\n");
                        textArea.append("Lokasi: " + event.getLocation() + "\n");
                        textArea.append("Topik: " + ((Seminar) event).getTopic() + "\n");
                        textArea.append("\n");
                    }
                }

                textArea.append("Workshops:\n");
                for (Event event : company.getEvents()) {
                    if (event instanceof Workshop) {
                        textArea.append("Nama Workshop: " + event.getTitle() + "\n");
                        textArea.append("Hari Tanggal: " + event.getDate() + "\n");
                        textArea.append("Lokasi: " + event.getLocation() + "\n");
                        textArea.append("Tools: " + ((Workshop) event).getTools() + "\n");
                        textArea.append("\n");
                    }
                }

                textArea.append("Participants:\n");
                for (Person person : company.getParticipants()) {
                    textArea.append("Nama: " + person.getName() + "\n");
                    textArea.append("Email: " + person.getEmail() + "\n");
                    if (person instanceof Employee) {
                        textArea.append("Departemen: " + ((Employee) person).getDepartment() + "\n");
                    } else if (person instanceof Speaker) {
                        textArea.append("Keahlian: " + ((Speaker) person).getExpertise() + "\n");
                    }
                    textArea.append("\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
