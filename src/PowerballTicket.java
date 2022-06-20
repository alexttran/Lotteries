public class PowerballTicket extends LotteryTicket {
    private int powerNum;

    public PowerballTicket() {
        super("Powerball", 5, 69);
        powerNum = generatePowerNum();
    }

    public PowerballTicket(int[] choices, int powerNum) {
        super("Powerball", 5, 69, choices);
        this.powerNum = powerNum;
    }

    public int generatePowerNum() {
        return (int) (Math.random() * 26 + 1);
    }


    public boolean grandPrizeWinner(LotteryTicket winningTicket) {
        PowerballTicket otherTicket = (PowerballTicket) winningTicket;
        if (super.grandPrizeWinner(otherTicket)) {
            if (otherTicket.powerNum == powerNum)
                return true;
        }
        return false;
    }

    public String toString() {
        return super.toString() + " [" + powerNum + "]";
    }
}
