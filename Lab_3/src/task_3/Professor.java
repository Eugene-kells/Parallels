package task_3;

import java.sql.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Professor extends Thread {
    protected final String url = "jdbc:postgresql://localhost:2345/postgres";
    protected final String user = "postgres";
    protected final String pass = "admin123";

    private String name;
    private LinkedBlockingQueue<Student> students;

    public Professor(String name, LinkedBlockingQueue students) {
        this.name = name;
        this.students = students;
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void setMark(Student student) throws SQLException {
        String SQL = "INSERT INTO lab.scores (score, student_id) VALUES (?, ?)";
        Connection conn = connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

        int random_score = (int) (Math.random() * 101);
        pstmt.setInt(1, random_score);
        pstmt.setInt(2, Integer.parseInt(student.id));
        pstmt.executeUpdate();
        conn.close();
        String write_str = String.format("%s gave a score for student %s %s (id: %s) from group %s",
                name, student.name, student.surname, student.id, student.group_name);
        System.out.println(write_str);
    }


    @Override
    public void run() {
        try {
            while (true) {
                setMark(students.take());
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
