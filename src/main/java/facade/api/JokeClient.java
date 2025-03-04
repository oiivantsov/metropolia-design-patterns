package facade.api;

public class JokeClient {
    private static final String API_URL = "https://api.chucknorris.io/jokes/random";

    public static void main(String[] args) {
        ApiFacade apiFacade = new ApiFacade();

        try {
            String joke = apiFacade.getAttributeValueFromJson(API_URL, "value");
            System.out.println("Random Chuck Norris Joke: " + joke);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

