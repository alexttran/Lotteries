public class MegamillionsTicket extends LotteryTicket {
    private int megaball;

    public MegamillionsTicket() {
        super("Megamillions", 5, 70);
        megaball = generateMegaball();
    }

    public MegamillionsTicket(int[] choices, int megaball) {
        super("Megamillions", 5, 70, choices);
        this.megaball = megaball;
    }

    public int generateMegaball() {
        return (int) (Math.random() * 25 + 1);
    }

    public boolean grandPrizeWinner(LotteryTicket winningTicket) {
        MegamillionsTicket otherTicket = (MegamillionsTicket) winningTicket;
        if (super.grandPrizeWinner(otherTicket)) {
            if (otherTicket.megaball == megaball) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return super.toString() + " [" + megaball + "]";
    }
}
