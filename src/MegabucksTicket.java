public class MegabucksTicket extends LotteryTicket {

    public MegabucksTicket() {
        super("Megabucks", 6, 48);
    }

    public MegabucksTicket(int[] choices) {
        super("Megabucks", 6, 48, choices);
    }
}
