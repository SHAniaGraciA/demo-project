package demo.service;

import demo.model.MerchOrder;
import demo.repository.MerchOrderDb;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MerchService {
    private final MerchOrderDb merchOrderDb;
    
    public MerchOrder saveOrder(MerchOrder merchOrder) {
        return merchOrderDb.save(merchOrder);
    }
}