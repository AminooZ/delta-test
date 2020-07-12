import java.util.HashMap;

public class Experiment {
    String name = New String();
    HashMap<String, int> variations = new HashMap<String, int>();
    HashMap<int, String> allocations = new HashMap<int, String>();
    HashMap<String, String> fixedUsers = new HashMap<String, String>();
    int traffic = New int()

    public static void main(String[] args) {
        this.name = name;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }

    public void setVariations(HashMap<String, int> variations) {
        int totalTraffic = 0;
        for (int traffic : variations.values()) {
            totalTraffic += traffic;
        }
        if (totalTraffic != 100) {
            // TODO Use a more explicit exception by adding
            // - Actual total traffic
            throw new Exception("Traffic allocation should sum to 100%");
        }
        this.variations = variations;
        int lowerBand = 0
        for (Map.Entry element : variations.entrySet()) {
            int upperBand = lowerBand + element.getValue();
            for (int i = lowerBand; i < upperBand; i++) {
                this.allocations.put(i, element.getKey())
            }
            lowerBand = upperBand;
        }
    }

    public void setFixedUser(String user, String variation) {
        if (this.variations.containsKey(variation)) {
            this.fixedUsers.put(user, variation);
        } else {
            // TODO Use a more explicit exception by adding
            // - Actual variation
            // - Expected variations
            throw new Exception("Unknown variation");
        }
    }

    public int getVariation(String user) {
        // TODO Handle fixed users using try - catch
        if (this.fixedUsers.containsKey(user)) {
            return this.fixedUsers.get(user);
        }
        return this.allocations.get(user.hashCode() % 99)
    }
}