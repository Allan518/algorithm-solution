// Arup Guha
// 5/13/2018
// Solution to USACO 2015 January Silver Problem: Stampede

import java.util.*;
import java.io.*;

public class StampedeW {

    public static int n;
    public static interval[] events;
    public static item[] items;

    public static void main(String[] args) throws Exception {

        // Read in data.
        BufferedReader stdin = new BufferedReader(new FileReader("stampede.in"));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());
        n = Integer.parseInt(tok.nextToken());
        events = new interval[2*n];
        items = new item[n];

        // Read through events.
        for (int i=0; i<n; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int x = Integer.parseInt(tok.nextToken());
            int y = Integer.parseInt(tok.nextToken());
            int r = Integer.parseInt(tok.nextToken());
            events[2*i] = new interval(y, -(x+1)*r, i, true);
            events[2*i+1] = new interval(y, -x*r, i, false);
            items[i] = new item(i, y);
        }

        // First sort by time.
        Arrays.sort(events);

        boolean[] seen = new boolean[n];
        TreeSet<item> ts = new TreeSet<item>();

        // Now go through the events in time.
        int i = 0;

        while (i < 2*n) {

            // Find range of events with the same time.
            int j = i;
            while (j < 2*n && events[j].t == events[i].t) j++;
            j--;

            // Process these events.
            for (int k=i; k<=j; k++) {
                if (events[k].open)
                    ts.add(items[events[k].id]);
                else
                    ts.remove(items[events[k].id]);
            }

            // Mark this as being seen.
            if (ts.size() > 0) seen[ts.first().id] = true;

            // Go onto the next group.
            i = j+1;
        }

        // Add up the cows seen.
        int res = 0;
        for (i=0; i<n; i++)
            if (seen[i])
                res++;

        // Write result.
        PrintWriter out = new PrintWriter(new FileWriter("stampede.out"));
        out.println(res);
        out.close();
        stdin.close();
    }
}

// Sorts events by time. (This is a bad class name, sorry!)
class interval implements Comparable<interval> {

    public int y;
    public int t;
    public int id;
    public boolean open;

    public interval(int myy, int myt, int i, boolean myo) {
        y = myy;
        t = myt;
        id = i;
        open = myo;
    }

    public int compareTo(interval other) {
        if (t != other.t) return t - other.t;
        if (!open && other.open) return -1;
        if (open && !other.open) return 1;
        return 0;
    }
}

// Sorts cows by y value (guaranteed to be distinct)
class item implements Comparable<item> {

    public int id;
    public int y;

    public item(int i, int myy) {
        id = i;
        y = myy;
    }

    public int compareTo(item other) {
        return this.y - other.y;
    }
}


// Here is how to create a class that has a custom compare method.
class MyComparator implements Comparator<interval> {
    public int compare(interval a, interval b) {
        return a.y - b.y;
    }
}