import java.awt.*;
import java.util.*;

public class MinSlots {

    public static void main(String[] args) {
        int[][] slots = {{1, 3, 2}, {2, 5, 3}, {5, 6, 2}};
        MinSlots s = new MinSlots();
        System.out.println(s.getSlots(slots));
    }

    public int getSlots(int[][] slots) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> whichSlots = new HashMap<>();
        int[] slotTracker = new int[slots.length];
        int ans = 0;
        for (int i = 0; i < slots.length; i++) {
            for (int j = slots[i][0]; j <= slots[i][1]; j++) {
                if (!frequency.containsKey(j)) {
                    frequency.put(j, 0);
                } else {
                    frequency.put(j, frequency.get(j) + 1);
                }
                if (!whichSlots.containsKey(j)) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    whichSlots.put(j, temp);
                } else {
                    whichSlots.get(j).add(i);
                }
            }
        }
        for (int i = 0; i < slots.length; i++) {
            ArrayList<Point> temp = new ArrayList<>();
            for (int j = slots[i][0]; j <= slots[i][1]; j++) {
                temp.add(new Point(frequency.get(j) * -1, j));
            }
            int count = slotTracker[i];
            Collections.sort(temp, new PointCompare());
            for (int j = 0; j < temp.size(); j++) {
                if (count == slots[i][2]) {
                    break;
                }
                if (visited.contains(temp.get(j).y)) {
                    continue;
                }
                visited.add(temp.get(j).y);
                ans++;
                count++;
                for (int k = 0; k < whichSlots.get(temp.get(j).y).size(); k++) {
                    slotTracker[whichSlots.get(temp.get(j).y).get(k)]++;
                }
            }
        }
        return ans;
    }

    public class PointCompare implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if (a.x < b.x) {
                return -1;
            } else if (a.x > b.x) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
