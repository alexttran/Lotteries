import java.util.ArrayList;

public class LotteryTicket {

    private String name;
    private ArrayList<Integer> picks;
    private int numVals;
    private int maxVal;

    /*
        Constructs a Quick Pick lottery ticket
     */
    public LotteryTicket(String name, int numVals, int maxVal) {
        this.name = name;
        this.numVals = numVals;
        this.maxVal = maxVal;
        picks = new ArrayList<Integer>();
        for (int i = 0; i < numVals; i++) {
            picks.add(pickUniqueVal());
        }
    }

    /*
        constructs a ticket using the ints in choices as the values for picks
     */
    public LotteryTicket(String name, int numVals, int maxVal, int[] choices) {
        this.name = name;
        this.numVals = numVals;
        this.maxVal = maxVal;
        picks = new ArrayList<Integer>();
        for (int num : choices) {
            picks.add(num);
        }
    }

    public LotteryTicket() {
        name = "Ticket";
        numVals = 3;
        maxVal = 10;
    }

    /*
       return true if this ticket has numVals in picks AND they are all unique
     */
    public boolean validate() {
        if (picks.size() == numVals) {
            for (int i = 0; i < numVals - 1; i++) {
                for (int j = i + 1; j < numVals; j++) {
                    if (i == j)
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    /*
        return ture if this ticket's picks match those of the winning ticket
     */
    public boolean grandPrizeWinner(LotteryTicket winningTicket) {
        if (winningTicket.validate()) {
            for (int pick : winningTicket.picks) {
                if (picksContains(pick)) {
                } else {
                    return false;
                }
            }
        } else
            return false;
        return true;
    }

    /*
        return a random int in range 1 through maxVal which is not
         currently contained in picks
     */
    private int pickUniqueVal() {
        int val = 0;
        boolean notUnique = true;
        while (notUnique) {
            val = (int) (Math.random() * maxVal) + 1;
            notUnique = picksContains(val);
        }
        return val;
    }

    private boolean picksContains(int val) {
        for (int i : picks) {
            if (i == val)
                return true;
        }
        return false;
    }

    public String toString() {
        return picks.toString();
    }
}
