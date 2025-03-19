package demo.repository;

import demo.model.MerchOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchOrderDb extends JpaRepository<MerchOrder, Long> {
    // You can add custom query methods here
}