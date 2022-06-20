import java.util.Scanner;

public class TestLotteryTicket {
    public static void main(String[] args) {
        System.out.println("Welcome to the Oregon Lottery!  We offer the following jackpot games:");
        System.out.println("Megabucks: 6 unique numbers 1-48.");
        System.out.println("Powerball: 5 unique numbers 1-69, plus 1 powerball 1-26");
        System.out.println("Megamillions: 5 unique numbers 1-70, plus 1 megaball 1-25");
        System.out.println("You may play (1) Megabucks, (2) Powerball, or (3) Megamillions");
        System.out.print("Enter your choice 1, 2, or 3:  ");
        Scanner reader = new Scanner(System.in);
        int gameChoice = reader.nextInt();
        System.out.print("For Quick pick, enter 1.  To choose your own numbers, enter 2:  ");
        int qpOrChoose = reader.nextInt();
        LotteryTicket ticket = null;
        if (qpOrChoose == 1)
            ticket = vendQPTicket(gameChoice);
        else
            ticket = vendUsersChoiceTicket(gameChoice);
        playUntilJackpotWon(ticket, gameChoice);
    }

    /*
          creates and returns the appropriate QuickPick ticket
     */
    private static LotteryTicket vendQPTicket(int gameChoice) {
        LotteryTicket ticket = null;
        if (gameChoice == 1) {  // create a QP Megabucks ticket and assign it to ticket
            ticket = new MegabucksTicket();
        } else if (gameChoice == 2) { // create QP a Powerball ticket and assign it to ticket
            ticket = new PowerballTicket();
        } else {  // create a QP Megamillions ticket and assign it to ticket
            ticket = new MegamillionsTicket();
        }
        return ticket;
    }

    /*
        asks users for appropriate values, then creates and returns the appropriate game ticket
     */
    private static LotteryTicket vendUsersChoiceTicket(int gameChoice) {
        LotteryTicket ticket = null;
        if (gameChoice == 1) {
            int[] choices = new int[6];
            Scanner console = new Scanner(System.in);
            System.out.println("Enter 6 unique numbers between 1 and 48, pressing enter after each number.");
            int i = 0;
            while (i < 6) {
                choices[i] = console.nextInt();
                i++;
            }
            ticket = new MegabucksTicket(choices);
        } else if (gameChoice == 2) {
            int[] choices = new int[5];
            Scanner console = new Scanner(System.in);
            System.out.println("Enter 5 unique numbers between 1 and 69, pressing enter after each number.");
            int i = 0;
            while (i < 5) {
                choices[i] = console.nextInt();
                i++;
            }
            System.out.println("Now enter number for your Powerball");
            int powerball = console.nextInt();
            ticket = new PowerballTicket(choices, powerball);
        } else {
            int[] choices = new int[5];
            Scanner console = new Scanner(System.in);
            System.out.println("Enter 5 unique numbers between 1 and 70, pressing enter after each number.");
            int i = 0;
            while (i < 5) {
                choices[i] = console.nextInt();
                i++;
            }
            System.out.println("Now enter number for your Megaball");
            int megaball = console.nextInt();
            ticket = new MegamillionsTicket(choices, megaball);
        }
        return ticket;
    }

    private static void playUntilJackpotWon(LotteryTicket ticket, int gameChoice) {
        System.out.println("OK, we'll spend $2 per game twice a week until we win!");
        System.out.println("For each game we will generate a winning ticket and compare it with yours.");
        System.out.println("Every 500,000 games, we will print the winning ticket and your ticket.");
        System.out.println("When you have won, we will print the winning ticket, the total you have spent, and ");
        System.out.println("  the number of years, months, and weeks it took to win!");
        boolean won = false;
        int numBought = 0;
        if (gameChoice == 1) {
            while (!won) {
                numBought++;
                MegabucksTicket winningTicket = new MegabucksTicket();
                if (ticket.grandPrizeWinner(winningTicket)) {
                    won = true;
                    System.out.println("Game: " + numBought);
                    System.out.println("Your ticket: " + ticket);
                    System.out.println("Winning ticket: " + ticket);
                } else if (numBought % 500000 == 0) {
                    System.out.println("Game: " + numBought);
                    System.out.println("Your ticket: " + ticket);
                    System.out.println("Winning Ticket: " + winningTicket);
                }
            }
        } else if (gameChoice == 2) {
            while (!won) {
                numBought++;
                PowerballTicket winningTicket = new PowerballTicket();
                if (ticket.grandPrizeWinner(winningTicket)) {
                    won = true;
                    System.out.println("Game: " + numBought);
                    System.out.println("Your ticket: " + ticket);
                    System.out.println("Winning ticket: " + ticket);
                } else if (numBought % 500000 == 0) {
                    System.out.println("Game: " + numBought);
                    System.out.println("Your ticket: " + ticket);
                    System.out.println("Winning Ticket: " + winningTicket);
                }
            }
        } else {
            while (!won) {
                numBought++;
                MegamillionsTicket winningTicket = new MegamillionsTicket();
                if (ticket.grandPrizeWinner(winningTicket)) {
                    won = true;
                    System.out.println("Game: " + numBought);
                    System.out.println("Your ticket: " + ticket);
                    System.out.println("Winning ticket: " + ticket);
                } else if (numBought % 500000 == 0) {
                    System.out.println("Game: " + numBought);
                    System.out.println("Your ticket: " + ticket);
                    System.out.println("Winning Ticket: " + winningTicket);
                }
            }
        }
        int numWeeks = numBought / 2;
        System.out.println("Congrats!!! You Won!!!");
        System.out.println("You spent $" + numBought * 2 + " to win");
        System.out.println("It took you " + numWeeks / 52 + " years, " + (numWeeks % 52) / 4 + " months, and " + (numWeeks % 52) % 4 + " weeks to win");
    }
}
