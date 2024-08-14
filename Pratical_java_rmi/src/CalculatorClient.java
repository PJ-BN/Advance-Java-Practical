import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {

    public static void main(String[] args) {
        try {
            
            Registry registry = LocateRegistry.getRegistry("localhost", 8000);

            
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            
            int a = 10;
            int b = 5;

            System.out.println("Addition: " + a + " + " + b + " = " + calculator.add(a, b));
            System.out.println("Subtraction: " + a + " - " + b + " = " + calculator.subtract(a, b));
            System.out.println("Multiplication: " + a + " * " + b + " = " + calculator.multiply(a, b));
            System.out.println("Division: " + a + " / " + b + " = " + calculator.divide(a, b));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
