package task_3;

import java.sql.*;
import java.util.concurrent.LinkedBlockingQueue;

public class WeekJob extends Thread {
    protected final String url = "jdbc:postgresql://localhost:2345/postgres";
    protected final String user = "postgres";
    protected final String pass = "admin123";

    private LinkedBlockingQueue<Student> students;

    public WeekJob(LinkedBlockingQueue students) {
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

    private ResultSet getStudents() throws SQLException {
        String SQL = "SELECT students.id AS id, " +
                "students.name AS student_name, " +
                "students.surname AS surname, " +
                "groups.name AS group_name " +
                "FROM lab.students JOIN lab.groups ON students.group_id = groups.id";
        Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        conn.close();
        return rs;
    }


    @Override
    public void run() {
        try {
            while (true) {
                ResultSet res = getStudents();
                while (res.next()) {
                    Student student = new Student(res.getString("id"),
                            res.getString("student_name"),
                            res.getString("surname"),
                            res.getString("group_name"));
                    students.put(student);
                }
                sleep(10000);
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
