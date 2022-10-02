import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private double totalCost;

    @ManyToOne // opposite of customer one
    @JoinColumn(
            name = "customer_id",
            nullable = false
    )
    private Customer c;

    public Order() {
    }

    public Order(long id, String date, double totalCost) {
        this.id = id;
        this.date = date;
        this.totalCost = totalCost;
    }

    public Customer getCustomer() {
        return c;
    }

    public void setCustomer(Customer customer) {
        this.c = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
