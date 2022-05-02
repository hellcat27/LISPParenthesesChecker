import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        boolean isValid = CheckString();
        System.out.println("Valid LISP parentheses: " + isValid);
        System.out.print("Task complete.");
    }

    public static boolean CheckString(){
        Stack<Character> charStack = new Stack<>();
        boolean valid = false;
        boolean inputDone = false;
        boolean submittedCode = false;
        System.out.println("Enter string to check (submit a blank string to end input): ");
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String line;// = reader.readLine();

            int submissionCount = 0;
            while((line = reader.readLine()) != null) {
                if(line.isEmpty()){
                    break;
                }
                for (char c : line.toCharArray()) {
                    if (c == '(') {
                        charStack.push(c);
                        submittedCode = true;
                    } else if (c == ')') {
                        submittedCode = true;
                        if (charStack.isEmpty()) {
                            return false;
                        }
                        char val = charStack.pop();
                        if (val != '(') {
                            return false;
                        }
                    }
                }
            }
        } catch(IOException ie) {
            ie.printStackTrace();
        }
        if (charStack.size() > 0) {
            return false;
        }
        if(submittedCode){
            valid = true;
        }
        return valid;
    }
}