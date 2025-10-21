import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        boolean playAgain = true;
        boolean done = false;
        int point = 0;

        do
        {
            System.out.printf("%-8s%-8s%-8s\n", "Die 1", "Die 2", "Sum");


            int roll = 1;
            int die1 = rand.nextInt(6) + 1; // Random number between 1 and 6
            int die2 = rand.nextInt(6) + 1; // Random number between
            int sum = die1 + die2;

            System.out.printf("%-8d%-8d%-8d\n", die1, die2, sum);

            do
            {
                if (sum == 7 || sum == 11) {
                    System.out.println("You got a natrual win!");
                    done = true;
                }
                else if (sum == 2 || sum == 3 || sum == 12)
                {
                    System.out.println("Craps! You lose!");
                    done = true;
                }
                else
                {
                    System.out.println("The point is " + sum);
                    point = sum;
                    done = false;

                    System.out.print("_______________________________\n");

                    do {
                        roll++;
                        die1 = rand.nextInt(6) + 1; // Random number between 1 and 6
                        die2 = rand.nextInt(6) + 1; // Random number between
                        sum = die1 + die2;

                        System.out.printf("%-8d%-8d%-8d\n", die1, die2, sum);

                        if (sum == point) {
                            System.out.println("You rolled your point! You win!");
                            done = true;
                        } else if (sum == 7) {
                            System.out.println("You rolled a 7 before your point. You lose!");
                            done = true;
                        }
                    } while (!done);
                }
            } while (!done);
            System.out.print("Do you want to play again? (y/n): ");
            String response = in.nextLine();
            if (response.equalsIgnoreCase("y"))
            {
                playAgain = true;
                done = false;
            }
            else
            {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        } while (playAgain);
    }
}