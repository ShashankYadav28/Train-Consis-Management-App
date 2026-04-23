import java.util.*;

public class UseCase7AddOnServiceSelection {

    static class AddOnService {
        private String serviceName;
        private double cost;

        public AddOnService(String serviceName, double cost) {
            this.serviceName = serviceName;
            this.cost = cost;
        }

        public double getCost() {
            return cost;
        }
    }

    static class AddOnServiceManager {
        private Map<String, List<AddOnService>> services = new HashMap<>();

        public void addService(String reservationId, AddOnService service) {
            services.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
        }

        public double getTotalCost(String reservationId) {
            double total = 0;
            List<AddOnService> list = services.get(reservationId);

            if (list != null) {
                for (AddOnService s : list) {
                    total += s.getCost();
                }
            }
            return total;
        }
    }

    public static void main(String[] args) {
        AddOnServiceManager manager = new AddOnServiceManager();

        String id = "Single-1";

        manager.addService(id, new AddOnService("Breakfast", 500));
        manager.addService(id, new AddOnService("Spa", 1000));

        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + id);
        System.out.println("Total Cost: " + manager.getTotalCost(id));
    }
}