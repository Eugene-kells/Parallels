package task_3;

import java.util.concurrent.LinkedBlockingQueue;

public class Application {

    public static void main(String[] args) {
        LinkedBlockingQueue students = new LinkedBlockingQueue<String>();
        Professor prof = new Professor(students);
        Assistent ass_1 = new Assistent(students);
        Assistent ass_2 = new Assistent(students);
        Assistent ass_3 = new Assistent(students);
        WeekJob job = new WeekJob(students);
        job.start();
        prof.start();
//        ass_1.start();
//        ass_2.start();
//        ass_3.start();
    }
}
