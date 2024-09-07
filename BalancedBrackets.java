Question: Balanced Brackets

Input:
4
{[()]}
{[(])}
{{[[(())]]}}
{([)}]

Output:
YES
NO
YES
NO

Program:

import java.util.ArrayList;
import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine().trim());
        String output[] = new String[a];
        for(int i = 0; i < a; i++) {
            String line = sc.nextLine();
            output[i] = isBalance(line);
        }
        for(int i = 0; i < a; i++)
            System.out.println(output[i]);
    }
    
    public static String isBalance(String line) {
        String output = null;
        ArrayList<Character> bracketStack = new ArrayList<>();
        for (Character c : line.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                bracketStack.add(c);
            } else {
                if (bracketStack.isEmpty()) {
                    output = "NO";
                    break;
                }
                char ch = bracketStack.remove(bracketStack.size() - 1);
                if (c == ')' && ch == '(') {
                    continue;
                } else if (c == '}' && ch == '{') {
                    continue;
                } else if (c == ']' && ch == '[') {
                    continue;
                } else {
                    output = "NO";
                    break;
                }
            }
        }
        
        if (!bracketStack.isEmpty())
            output = "NO";
        if (output == null)
            output = "YES";
        
        return output;
    }
}
