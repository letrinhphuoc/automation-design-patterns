package com.automation.design.strategy;

import java.util.Map;

public interface PaymentOption {
    void enterPaymentInformation(Map<String, String> paymentDetails);
}
