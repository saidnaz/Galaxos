package fr.isika.cda.galaxos.service;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
@Stateless
public class PaymentService {


    @PostConstruct
    private void init() {
        Stripe.apiKey = "sk_test_51JmfnrBVeS0qA3DPjCdV4AhiUBUD9wrCSp1ucRH1FrbZWLCuM3Kk8Bn4D6TH0D1D4Xh30eOSw2dkNDcrwPSUhb6V00PmWgviMA";//SecretKey
    }
    
    
    public Charge charge(String token, BigDecimal chargeAmount, String paymentCurrency) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        
        chargeParams.put("amount", chargeAmount);
        chargeParams.put("currency", paymentCurrency);
        chargeParams.put("source", token);

        return Charge.create(chargeParams);
    }
}
