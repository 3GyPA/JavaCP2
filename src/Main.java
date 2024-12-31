// Клас для роботи з текстом у Java
public class Main {

    public static void main(String[] args) {
        try {
            // Заданий текст
            String text = "Everybody Wants to Rule the World was written by Roland Orzabal, Ian Stanley and Chris Hughes, and produced by Hughes. ";

            System.out.println("Original Text:");
            System.out.println(text);

            // Обробка тексту: зміна місцями першого та останнього слова у кожному реченні
            String result = swapFirstAndLastWords(text);

            System.out.println("\nModified Text:");
            System.out.println(result);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Метод для обробки тексту: зміна місцями першого та останнього слова у кожному реченні.
     *
     * @param text Вхідний текст.
     * @return Оброблений текст.
     */
    public static String swapFirstAndLastWords(String text) {
        StringBuilder result = new StringBuilder();
        String[] sentences = text.split("\\.\\s*"); // Розділення на речення

        for (String sentence : sentences) {
            String trimmedSentence = sentence.trim();
            if (trimmedSentence.isEmpty()) continue;

            String[] words = trimmedSentence.split("\\s+"); // Розділення на слова

            if (words.length > 1) {
                // Заміна першого та останнього слова
                String temp = words[0];
                words[0] = words[words.length - 1];
                words[words.length - 1] = temp;
            }

            // З'єднання слів назад у речення
            StringBuilder modifiedSentence = new StringBuilder();
            for (String word : words) {
                if (modifiedSentence.length() > 0) {
                    modifiedSentence.append(" ");
                }
                modifiedSentence.append(word);
            }

            // Додавання до результату
            if (result.length() > 0) {
                result.append(". ");
            }
            result.append(modifiedSentence);
        }

        // Додавання крапки в кінці тексту, якщо вона була
        if (text.endsWith(".")) {
            result.append(".");
        }

        return result.toString();
    }
}
