package org.example;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() throws NotEnoughMoneyException{
        throw new NotEnoughMoneyException();
    }
}
