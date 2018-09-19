package guessinggamepack;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is a number guessing game. Enter a lower bound:");
        int min = scanner.nextInt();
        System.out.println("Enter an upper bound:");
        int max = scanner.nextInt();
        int ans = (int)((Math.random()) * max + min) ;
        int[] guesses = new int[max-min];
        System.out.println("We have a number to guess! Enter your guess:");
        int guess = scanner.nextInt();
        int wrongTries = 0;

        while (guess != ans)
        {
            if (guess > ans) System.out.println("Too high");
            else if (guess < ans) System.out.println("Too low");

            Arrays.sort(guesses);
            if ( Arrays.binarySearch(guesses, guess) >= 0 )
            {
                System.out.println("You already guessed that.");
            }
            else
            {
                wrongTries++;
                guesses[wrongTries] = guess;
            }
            guess = scanner.nextInt();
        }
        System.out.println("Nice! You got it!");
        if (wrongTries == 0) System.out.println("On the first try, too =)");
        else if (wrongTries == 1) System.out.println("You got it wrong once!");
        else if (wrongTries > 1) System.out.println("You got it wrong " + wrongTries + " times");
    }
}