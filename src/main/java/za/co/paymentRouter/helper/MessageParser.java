package za.co.paymentRouter.helper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import za.co.paymentRouter.dto.*;

@Component
public class MessageParser {

    final static Logger LOGGER = Logger.getLogger(MessageParser.class);
    static String rejectionReason;

    public MT195Message generateAcknowledgementMessage(MT101Message message){
        MT195Message mt195Message = new MT195Message();

        Block1 block1 = new Block1();
        block1.setApplicationId(message.getBlock1().getApplicationId());
        block1.setServiceId(message.getBlock1().getServiceId());
        block1.setLogicalTerminal(message.getBlock1().getLogicalTerminal());

        Block2 block2 = new Block2();
        block2.setInputOutputId("I");
        block2.setMessageType("195");
        block2.setLogicalTerminal(message.getBlock2().getLogicalTerminal());
        block2.setMessagePriority(message.getBlock2().getMessagePriority());

        Block4 block4 = new Block4();
        block4.setSendersReference("14458");
        block4.setRelatedReference(message.getBlock4().getSendersReference());
        block4.setQueries(":/99/Payment Rejected / See tag 79");
        block4.setNarrativeDescription("/REJT/"+this.rejectionReason);

        mt195Message.setBlock1(block1);
        mt195Message.setBlock2(block2);
        mt195Message.setBlock4(block4);

        return mt195Message;
    }

    /**
     * This is where rejection rules are used to determine if a message is to be rejected or not
     * @param message
     * @return
     */
    public boolean isMessageRejected(MT101Message message){

        if(StringUtils.isEmpty(message.getBlock4().getSendersReference())){
            this.rejectionReason = "Missing sender reference";
            return true;
        }

        if(StringUtils.isEmpty(message.getBlock2().getLogicalTerminal())){
            this.rejectionReason = "Missing logical terminal";
            return true;
        }

        // TODO: put more rules which can be used to filter out rejected messages
        return false;
    }

    /**
     * Determine the payment destination
     * @param message
     * @return
     */
    public String determineDestination(MT101Message message){
        return message.getBlock2().getLogicalTerminal();
    }
}
