import java.util.ArrayList;
import java.util.List;

public class LimitedInstances {
    private static List<LimitedInstances> instances = new ArrayList<>();
    private static final int limit = 4;

    private LimitedInstances() {
    }

    public static LimitedInstances getInstance() {
        if (instances.size() < limit) {
            LimitedInstances instance = new LimitedInstances();
            instances.add(instance);
            return instance;
        } else {
            throw new RuntimeException("Instance Limit reached");
        }
    }

    public static void main(String[] args) {
        try {
            LimitedInstances.getInstance();
            LimitedInstances.getInstance();
            LimitedInstances.getInstance();
            LimitedInstances.getInstance();
            LimitedInstances.getInstance();
            LimitedInstances.getInstance();
            LimitedInstances.getInstance();
            LimitedInstances.getInstance();
            LimitedInstances.getInstance();
            LimitedInstances.getInstance();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
