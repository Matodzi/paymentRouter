package za.co.paymentRouter.helper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class SettlementEngine {

    final static Logger LOGGER = Logger.getLogger(SettlementEngine.class);

    public void makePayment(String paymentDestination){
        LOGGER.info("Payment for "+ paymentDestination +" successfully settled");

        //TODO: Use in-memory database to mock payment
    }
}
