import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {

    public static void main(String[] args) {
        try {
            
            CalculatorImpl calculator = new CalculatorImpl();

            
            Registry registry = LocateRegistry.createRegistry(8000);

            
            registry.rebind("CalculatorService", calculator);

            System.out.println("CalculatorService is bound and ready for use.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
