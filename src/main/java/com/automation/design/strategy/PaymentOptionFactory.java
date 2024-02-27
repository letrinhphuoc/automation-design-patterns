package com.automation.design.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {
    /*
    Our payment option this constructor does not need anything,
    We don't need anything, so we want to simply return the object without accepting any parameter
    In this case we can use supplier, Supplier is the interface for that, It is going to return payment option
     We are going to call CC is non, it means I would not be accepting any parameter, but I will give you new credit card.
     So why we use the supplier? => Because we don't need any parameter for this
    * */
    private static final Supplier<PaymentOption> CC = () -> new CreditCard();
    private static final Supplier<PaymentOption> NB = () -> new NetBanking();

    private static final Map<String, Supplier<PaymentOption>> MAP = new HashMap<>();

    static {
        MAP.put("CC", CC);
        MAP.put("NB", NB);
    }
    public static PaymentOption get(String option){
        return MAP.get(option).get();
    }
}
