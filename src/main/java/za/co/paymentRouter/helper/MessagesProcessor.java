package za.co.paymentRouter.helper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.paymentRouter.dto.MT101Message;
import za.co.paymentRouter.dto.MT195Message;

@Component
public class MessagesProcessor {

    final static Logger LOGGER = Logger.getLogger(MessagesProcessor.class);

    private final MessageParser messageParser;
    private final SettlementEngine settlementEngine;

    @Autowired
    MessagesProcessor( MessageParser messageParser, SettlementEngine settlementEngine){
        this.messageParser = messageParser;
        this.settlementEngine = settlementEngine;
    };


    public MT195Message processMessage(MT101Message message){

        LOGGER.info("Inside "+this.getClass());// for debugging purposes

        MT195Message mt195Message = new MT195Message();

        LOGGER.info("Determining if message is to be rejected...");
        if(!messageParser.isMessageRejected(message)){

            LOGGER.info("Message was not rejected...");
            String paymentDestination = messageParser.determineDestination(message);

            LOGGER.info("Sending payment to settlement engine...");
            settlementEngine.makePayment(paymentDestination);
            mt195Message = null;
        }else {
            LOGGER.info("Message was rejected..");
            mt195Message = messageParser.generateAcknowledgementMessage(message);
        }
        return mt195Message;
    }
}
