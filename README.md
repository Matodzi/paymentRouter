# paymentRouter
Local deployment uses the following URL:

http://localhost:8080/processPayment

The service consumes a xml of the following format

<MT195Message>
    <block1>
        <applicationId>F</applicationId>
        <serviceId>01</serviceId>
        <logicalTerminal>SAESVAV0AXXX</logicalTerminal>
        <sessionNumber />
        <sequenceNumber />
    </block1>
    <block2>
        <inputOutputId>I</inputOutputId>
        <messageType>195</messageType>
        <inTime />
        <inDate />
        <logicalTerminal>LRLRXXXX4A07</logicalTerminal>
        <sessionNumber />
        <isn />
        <outTime />
        <outDate />
        <messagePriority>N</messagePriority>
    </block2>
    <block4>
        <sendersReference>14458</sendersReference>
        <relatedReference />
        <messageIndex />
        <orderingCustomer />
        <requestedExecutionDate />
        <repetitiveSequence />
        <queries>:/99/Payment Rejected / See tag 79</queries>
        <narrativeDescription>/REJT/Missing sender reference</narrativeDescription>
    </block4>
</MT195Message>
