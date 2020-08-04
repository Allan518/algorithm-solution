import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ElectionTime {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfCows = Integer.parseInt(st.nextToken());
        int firstWinners = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> votes = new HashMap<>();
        ArrayList<Integer> firstVotes = new ArrayList<>();
        ArrayList<Integer> initialOrder = new ArrayList<>();
        for (int i = 0; i < numOfCows; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            votes.put(first, second);
            firstVotes.add(first);
            initialOrder.add(first);
        }
        Collections.sort(firstVotes);
        ArrayList<Integer> secondRound = new ArrayList<>();
        for (int i = firstVotes.size() - 1; i >= firstVotes.size() - firstWinners; i--) {
            secondRound.add(firstVotes.get(i));
        }
        int winningCowIndex = 0;
        int secondWinningVotes = 0;
        for (int i = 0; i < secondRound.size(); i++) {
            if (votes.get(secondRound.get(i)) > secondWinningVotes) {
                winningCowIndex = initialOrder.indexOf(secondRound.get(i)) + 1;
                secondWinningVotes = votes.get(secondRound.get(i));
            }
        }
        System.out.println(winningCowIndex);
    }
}
