import java.util.Timer;

public class RemindTask {
    private Timer timer;

    public RemindTask(Timer timer) {
        this.timer = timer;
    }

    public void run() {
        timer.cancel();
        System.exit(1);
    }

}
