package DependencyInjection;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        return "Customer{id='" + id + "', name='Alice', grade='Premium'}";
    }
}
