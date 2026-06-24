package DependencyInjection;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Inject dependency via constructor
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        // Use service
        service.getCustomerDetails("C101");
    }
}
