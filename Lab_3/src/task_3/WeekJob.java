package task_3;

import java.sql.*;
import java.util.concurrent.LinkedBlockingQueue;

public class WeekJob extends Thread {
    protected final String url = "jdbc:postgresql://localhost:2345/postgres";
    protected final String user = "postgres";
    protected final String pass = "admin123";

    private LinkedBlockingQueue<String> students;

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
        String SQL = "SELECT id, name, surname, group_id FROM lab.students";
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
                    students.put(res.getString("id"));
                }
                sleep(10000);
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
