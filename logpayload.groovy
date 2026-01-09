import com.sap.gateway.ip.core.customdev.util.Message;

def Message processData(Message message) {
    // Get the current message body as a String
    def body = message.getBody(java.lang.String) as String;
    
    // Get access to the Message Processing Log
    def messageLog = messageLogFactory.getMessageLog(message);
    
    // Check if message logging is enabled
    if (messageLog != null) {
        // Add a string property to the log for identification
        messageLog.setStringProperty("LoggingStep", "Payload captured at specific step");
        
        // Add the payload as an attachment to the MPL
        messageLog.addAttachmentAsString("PayloadAttachment", body, "text/plain");
    }
    
    // Return the message for continued processing in the iFlow
    return message;
}
