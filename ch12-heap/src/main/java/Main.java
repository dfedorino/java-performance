import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<>();
        while (true) {
            customerList.add(new Customer("Matt"));
            if (customerList.size() > 1000) {
                Iterator<Customer> iterator = customerList.iterator();
                for (int i = 0; i < 10; i++) {
                    iterator.next();
                    iterator.remove();
                }
            }
        }
    }
}
