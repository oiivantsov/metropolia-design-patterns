package chain_of_responsibility.feedback_handler;

public class Main {
    public static void main(String[] args) {

        Handler primaryHandler;

        Handler compensationClaimHandler = new CompensationClaimHandler();
        Handler contactRequestHandler = new ContactRequestHandler();
        Handler developmentSuggestionHandler = new DevelopmentSuggestionHandler();
        Handler generalFeedbackHandler = new GeneralFeedbackHandler();

        primaryHandler = compensationClaimHandler;

        // chaining the handlers
        compensationClaimHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(developmentSuggestionHandler);
        developmentSuggestionHandler.setNextHandler(generalFeedbackHandler);

        // messages
        Message compensationMessage = new Message(MessageType.COMPENSATION_CLAIM, "Shipment was delayed, please send by money back!.", "customer1@example.com");
        Message contactMessage = new Message(MessageType.CONTACT_REQUEST, "I want to call to HR as soon as possible please!", "customer2@example.com");
        Message suggestionMessage = new Message(MessageType.DEVELOPMENT_SUGGESTION, "Very good service! But could you please also call before one day before a shipment day.", "customer3@example.com");
        Message feedbackMessage = new Message(MessageType.GENERAL_FEEDBACK, "Thank you very much! 5/5", "customer4@example.com");

        // Send messages to the handler chain
        System.out.println("Processing feedback: ");
        System.out.println("--------------------");
        primaryHandler.handleMessage(compensationMessage);
        System.out.println("--------------------");
        primaryHandler.handleMessage(contactMessage);
        System.out.println("--------------------");
        primaryHandler.handleMessage(suggestionMessage);
        System.out.println("--------------------");
        primaryHandler.handleMessage(feedbackMessage);
    }
}
