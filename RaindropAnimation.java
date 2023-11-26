import java.util.Scanner;

public class RaindropAnimation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String inputWord = scanner.nextLine();

        for (int i = 0; i < inputWord.length(); i++) {
            char ch = inputWord.charAt(i);
            System.out.print(ch);

            try {
                Thread.sleep(100); // Adjust the delay time for desired animation speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Use ANSI escape code to clear the console and create the illusion of falling raindrops
            System.out.print("\033[H\033[2J");
        }

        scanner.close();
    }
}

