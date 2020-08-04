import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MinimumNumber {
    static char[][] words;
    static char[] correctPassword;
    static boolean okay = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int numOfWords = Integer.parseInt(st.nextToken());
        char[] password;
        password = br.readLine().toCharArray();
        words = new char[numOfWords][];
        for (int i = 0; i < numOfWords; i++) {
            words[i] = br.readLine().toCharArray();
        }
        int forgottenNum = 0;
        for (int i = 0; i < length; i++) {
            if (password[i] == '?') {
                forgottenNum++;
            }
        }
        boolean found = false;
        for (int num = 0; num < Math.pow(2, forgottenNum); num++) {
            String binaryNum = Integer.toString(Integer.parseInt(String.valueOf(num), 10), 2);
            StringBuilder str = new StringBuilder();
            str.append(binaryNum);
            if (str.length() < forgottenNum) {
                while (str.length() < forgottenNum) {
                    str.insert(0, "0");
                }
            }
            if (isValid(password.clone(), str.toString())) {
                StringBuilder answer = new StringBuilder();
                for (int i = 0; i < correctPassword.length; i++) {
                    answer.append(correctPassword[i]);
                }
                System.out.println(answer);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("NO SOLUTION");
        }
    }

    static boolean isValid(char[] password, String missingLetters) {
        int index = 0;
        ArrayList<Character> pass = new ArrayList<>();
        for (int i = 0; i < password.length; i++) {
            if (password[i] == '?') {
                password[i] = missingLetters.charAt(index);
                index++;
            }
            pass.add(password[i]);
        }
        test(pass);
        if (okay) {
            correctPassword = password.clone();
            return true;
        }
        return false;
    }

    static void test(ArrayList<Character> password) {
        if (password.size() == 0) {
            okay = true;
        }
        for (int i = 0; i < words.length; i++) {
            if (password.size() < words[i].length) {
                continue;
            }
            boolean works = true;
            for (int j = 0; j < words[i].length; j++) {
                if (password.get(j) != words[i][j]) {
                    works = false;
                    break;
                }
            }
            if (works) {
                ArrayList<Character> newPass = new ArrayList<>(password);
                for (int k = 0; k < words[i].length; k++) {
                    newPass.remove(0);
                }
                test(newPass);
            }
        }
    }
}