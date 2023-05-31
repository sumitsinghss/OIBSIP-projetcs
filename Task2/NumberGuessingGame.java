import java.util.Scanner;
public class NumberGuessingGame {
    static void numberGuessingGame()
    {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int)(100 * Math.random());
        int i;
        int attempt = 10;
        System.out.println("You have 10 trails to choose a number between 1-100");
        for ( i = 0; i < attempt; i++)
        {
            System.out.println("Guess the number:");
            if (sc.hasNextInt()){
                int guess = sc.nextInt();
                if (number == guess)
                {
                    System.out.println("Congratulations!"+" You guessed the number.");
                    break;
                }
                else if (number > guess && i != attempt - 1)
                {
                    System.out.println("The number is " + "greater than "+guess);
                }
                else if (number < guess && i != attempt - 1)
                {
                    System.out.println("The number is" +" less than " + guess);
                }
            }else{
                System.out.println("Input character is not a number.");
                break;
            }
        }
        if ( i==attempt)
        {
            System.out.println("You have exhausted "+attempt+" trials.");
            System.out.println("Better luck next time....");
            System.out.println("The number was " + number);
        }
    }
    public static void main(String[] args)
    {
        numberGuessingGame();
    }
}