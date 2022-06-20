import java.util.Scanner;

public class PlayToWin3Of10 {
    public void PlayToWin() {
        boolean won = false;
        int numWeeks = 0;
        System.out.println("Hello, big spender, and welcome to the Pick 3 of 10 Lottery!\n" + "So you want to win the jackpot, eh?  OK.");
        System.out.println("Choose whether you will ");
        System.out.println("(1) buy a new Quick Pick ticket for each drawing until you win, or ");
        System.out.println("(2) Select your own 3 numbers to be played until you win.");
        System.out.print("Your choice? ");
        Scanner console = new Scanner(System.in);
        int option = console.nextInt();
        if (option == 1) {
            while (won == false) {
                numWeeks++;
                LotteryTicket userTicket = new LotteryTicket("userTicket", 3, 10);
                LotteryTicket winningTicket = new LotteryTicket("winningTicket", 3, 10);
                System.out.println("For game #" + numWeeks + ",");
                System.out.println("Your ticket is " + userTicket);
                System.out.println("Winning ticket is " + winningTicket);
                if (userTicket.grandPrizeWinner(winningTicket)) {
                    won = true;
                }
            }
        } else if (option == 2) {
            int[] choices = new int[3];
            System.out.print("Enter three unique values from 1 though 10: ");
            for (int i = 0; i < 3; i++) {
                choices[i] = console.nextInt();
            }
            LotteryTicket userTicket = new LotteryTicket("userTicket", 3, 10, choices);
            while (won == false) {
                numWeeks++;
                LotteryTicket winningTicket = new LotteryTicket("winningTicket", 3, 10);
                System.out.println("For game #" + numWeeks + ",");
                System.out.println("Your ticket is " + userTicket);
                System.out.println("Winning ticket is " + winningTicket + "\n");
                if (userTicket.grandPrizeWinner(winningTicket)) {
                    won = true;
                }
            }
        } else if (option == 3) {
            while (won == false) {
                numWeeks++;
                PowerballTicket userTicket = new PowerballTicket();
                PowerballTicket winningTicket = new PowerballTicket();
                System.out.println("For game #" + numWeeks + ",");
                System.out.println("Your ticket is " + userTicket);
                System.out.println("Winning ticket is " + winningTicket);
                if (userTicket.grandPrizeWinner(winningTicket)) {
                    won = true;
                }
            }
        }
        System.out.println("\n Yay! You won!!!!! \n");
        System.out.println("Your have spent $" + numWeeks * 2 + " on this lottery");
        System.out.println("You have been playing this game for " + numWeeks / 52 + " years, " + (numWeeks % 52) / 4 + " months, and " + (numWeeks % 52) % 4 + " weeks.");

    }
}
