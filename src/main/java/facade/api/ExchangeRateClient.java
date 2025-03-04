package facade.api;

public class ExchangeRateClient {
    private static final String API_URL = "https://api.fxratesapi.com/latest";

    public static void main(String[] args) {
        ApiFacade apiFacade = new ApiFacade();

        try {
            String usdRate = apiFacade.getAttributeValueFromJson(API_URL, "rates.EUR");
            System.out.println("USD Exchange Rate: " + usdRate);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
