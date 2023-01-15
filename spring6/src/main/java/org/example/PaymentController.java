package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
