package za.co.paymentRouter.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.paymentRouter.dto.MT101Message;
import za.co.paymentRouter.dto.MT195Message;
import za.co.paymentRouter.helper.MessagesProcessor;


@RestController
public class PaymentRouterRestController {

    final static Logger LOGGER = Logger.getLogger(PaymentRouterRestController.class);
    private final MessagesProcessor messagesProcessor;

    @Autowired
    PaymentRouterRestController(MessagesProcessor messagesProcessor){
        this.messagesProcessor = messagesProcessor;
    }

    @RequestMapping(value = "/processPayment" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
    public MT195Message processPayment(@RequestBody MT101Message message){
        LOGGER.info("SWIFT MT101 message being processed : "+ message);
        return messagesProcessor.processMessage(message);
    }
}
