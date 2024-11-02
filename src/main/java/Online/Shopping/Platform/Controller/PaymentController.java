package Online.Shopping.Platform.Controller;

import Online.Shopping.Platform.Entity.Payment;
import Online.Shopping.Platform.Service.PaymentProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentProducerService producerService;

    @PostMapping
    public Payment makePayment(@RequestParam Double amount, @RequestParam String currency) {
        Payment payment = new Payment();
        payment.setId(UUID.randomUUID().toString());
        payment.setAmount(amount);
        payment.setCurrency(currency);
        return payment;
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable String id) {
        // For demo purposes, return a dummy payment
        Payment payment = new Payment();
        payment.setId(id);
        payment.setAmount(100.00); // Dummy amoun
        payment.setCurrency("USD"); // Dummy currency
        return payment;
    }
    @GetMapping("/complete")
    public ResponseEntity<String> completePayment() {
        // Perform payment logic here...
        producerService.sendPurchaseNotification("Item purchase complete for order ");
        return ResponseEntity.ok("Payment completed and notification sent.");
    }
}
