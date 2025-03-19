package demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "merch_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MerchOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String buyerName;
    private String buyerNpm;
    private String faculty;
    private String merchName;
    private Integer price;
    private Integer quantity;
    private Integer totalPrice;
    private LocalDateTime orderDate;
    
    @PrePersist
    public void prePersist() {
        orderDate = LocalDateTime.now();
        totalPrice = price * quantity;
    }
}