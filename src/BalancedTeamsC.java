import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class BalancedTeamsC {
    static int[] player_skill = new int[12];
    static int[] player_team = new int[12];
    static int[] team_count = new int[4];
    static int answer = -1;

    static void recurse(int player) {
        //   System.out.println("start recurse player = " + player);
        if (player == 12) {
            int[] team_skill = new int[4];
            for (int i = 0; i < 12; i++) {
                team_skill[player_team[i]] += player_skill[i];
            }
            int S = max(max(team_skill[0], team_skill[1]),
                    max(team_skill[2], team_skill[3]));
            int s = min(min(team_skill[0], team_skill[1]),
                    min(team_skill[2], team_skill[3]));

            if (answer == -1 || S - s < answer) {
                answer = S - s;
            }
            return;
        }
        for (int team = 0; team < 4; team++) {
            if (team_count[team] < 3) {
                player_team[player] = team;
                team_count[team]++;
                System.out.println("player_team[" + player + "] =" + player_team[player]);
                System.out.println("team_count[" + team + "] =" + team_count[team]);
                recurse(player + 1);

                team_count[team]--;
            }
        }
        //  System.out.println("end of recursive player = " + player);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("bteams.in"));
        List<Integer> skillLevels = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            player_skill[i] = Integer.parseInt(br.readLine());
        }
        recurse(0);
        System.out.println(answer);
        PrintWriter printWriter = new PrintWriter(new FileWriter("bteams.out"));
        printWriter.println(answer);
        printWriter.flush();
    }
}


