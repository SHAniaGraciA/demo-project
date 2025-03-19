package demo.controller;

import demo.model.MerchOrder;
import demo.service.MerchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/merch")
@AllArgsConstructor
public class MerchController {
    
    private final MerchService merchService;
    
    @GetMapping
    public String viewMerchPage() {
        return "merch";
    }
    
    @PostMapping("/order")
    public String processOrder(
            @RequestParam String merchName,
            @RequestParam Integer merchPrice,
            @RequestParam String buyerName,
            @RequestParam String buyerNpm,
            @RequestParam String faculty,
            @RequestParam Integer quantity,
            RedirectAttributes redirectAttributes) {
            
        MerchOrder order = new MerchOrder();
        order.setBuyerName(buyerName);
        order.setBuyerNpm(buyerNpm);
        order.setFaculty(faculty);
        order.setMerchName(merchName);
        order.setPrice(merchPrice);
        order.setQuantity(quantity);
        
        merchService.saveOrder(order);
        
        redirectAttributes.addFlashAttribute("success", "Pembelian berhasil! Terima kasih telah memesan " 
                                            + merchName + " sebanyak " + quantity + " item.");
        
        return "redirect:/merch";
    }
}