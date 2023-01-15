package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {
    private final PaymentService paymentService;
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() throws NotEnoughMoneyException{
        PaymentDetails paymentDetails = paymentService.processPayment();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }

    @PostMapping("/payments")
    public ResponseEntity<PaymentDetails> makePayments(@RequestBody PaymentDetails paymentDetails) throws NotEnoughMoneyException{
        logger.info("Received payments" + paymentDetails.getAmount());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }

    @PostMapping("/createpayment")
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestId, @RequestBody Payment payment){
        logger.info("Recieved request with ID " + requestId + "; Payments amount: " + payment.getAmount());
        payment.setId(UUID.randomUUID().toString());
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("reauestId", requestId)
                .body(payment);
    }
}
