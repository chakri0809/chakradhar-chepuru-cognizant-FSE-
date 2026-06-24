package DependencyInjection;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerDetails(String id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Service fetched: " + customer);
    }
}
