import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class LinkShortener {
    private final Map<String, String> shortToLongMap;
    private final Map<String, String> longToShortMap;
    private final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int CODE_LENGTH = 6;

    public LinkShortener() {
        this.shortToLongMap = new HashMap<>();
        this.longToShortMap = new HashMap<>();
    }

    public String shorten(String url) {
        if (longToShortMap.containsKey(url)) {
            return longToShortMap.get(url);
        }

        String shortCode = generateShortCode();
        shortToLongMap.put(shortCode, url);
        longToShortMap.put(url, shortCode);
        return shortCode;
    }

    public String expand(String shortCode) {
        return shortToLongMap.get(shortCode);
    }

    private String generateShortCode() {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return code.toString();
    }

    public static void main(String[] args) {
        LinkShortener shortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a long URL:");
        String longUrl = scanner.nextLine();

        String shortCode = shortener.shorten(longUrl);
        System.out.println("Shortened URL: " + shortCode);

        System.out.println("Enter a short code to expand the URL:");
        String shortInput = scanner.nextLine();
        String expandedUrl = shortener.expand(shortInput);
        System.out.println("Expanded URL: " + expandedUrl);

        scanner.close();
    }
}
