package task_3;

import java.util.concurrent.LinkedBlockingQueue;

public class Assistent extends Professor {
    public Assistent(String name, LinkedBlockingQueue students) {
        super(name, students);
    }
}
