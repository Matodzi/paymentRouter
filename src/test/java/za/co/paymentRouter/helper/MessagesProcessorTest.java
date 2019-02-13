package za.co.paymentRouter.helper;

import org.junit.Before;
import org.junit.Test;
import za.co.paymentRouter.dto.*;

import static org.junit.Assert.assertTrue;

public class MessagesProcessorTest {

    MessagesProcessor messagesProcessor = new MessagesProcessor(new MessageParser(), new SettlementEngine());

    static MT101Message mt101Message = new MT101Message();
    static MT101Message rejectedMt101Message = new MT101Message();

    @Before
    public void setUp(){
        Block1 block1 = new Block1();
        block1.setApplicationId("F");
        block1.setServiceId("01");
        block1.setLogicalTerminal("SAESVAV0AXXX");
        block1.setSessionNumber("0466");
        block1.setSequenceNumber("020121");

        Block2 block2 = new Block2();
        block2.setInputOutputId("O");
        block2.setInTime("101");
        block2.setInDate("070522");
        block2.setLogicalTerminal("LRLRXXXX4A07");
        block2.setSessionNumber("0000");
        block2.setIsn("591065");
        block2.setOutTime("070522");
        block2.setOutDate("1739");
        block2.setMessagePriority("N");

        Block3 block3 = new Block3();
        block3.setTag108("MT101 001 OF 019");

        Block4 block4 = new Block4();
        block4.setSendersReference("00028");
        block4.setMessageIndex("1/1");
        block4.setRequestedExecutionDate("020419");

        OrderingCustomer orderingCustomer = new OrderingCustomer();
        orderingCustomer.setLine1("/VTB.2003.02");
        orderingCustomer.setLine2("19Apr2002");

        block4.setOrderingCustomer(orderingCustomer);

        RepetitiveSequence repetitiveSequence = new RepetitiveSequence();
        repetitiveSequence.setTransactionReference("x");
        repetitiveSequence.setTransactionAmount("USD1");
        repetitiveSequence.setIndustryParty("x");

        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setLine1("/x");
        beneficiary.setLine2("x");

        repetitiveSequence.setBeneficiary(beneficiary);
        repetitiveSequence.setDetailsOfCharge("OUR");

        Block5 block5 = new Block5();

        mt101Message.setBlock1(block1);
        mt101Message.setBlock2(block2);
        mt101Message.setBlock3(block3);
        mt101Message.setBlock4(block4);
        mt101Message.setBlock5(block5);

        rejectedMt101Message.setBlock1(block1);
        rejectedMt101Message.setBlock2(block2);
        rejectedMt101Message.setBlock3(block3);
        Block4 rejectedBlock4 = new Block4();
        rejectedBlock4.setSendersReference("");
        rejectedMt101Message.setBlock4(rejectedBlock4);
    }

    @Test
    public void processMessageTest(){
        MT195Message mt195Message = messagesProcessor.processMessage(mt101Message);
        assertTrue(mt195Message == null);
    }

    @Test
    public void processMessageTestRejection(){
        MT195Message mt195Message = messagesProcessor.processMessage(rejectedMt101Message);
        assertTrue(mt195Message.getBlock4().getNarrativeDescription().equals("/REJT/Missing sender reference"));
    }
}
