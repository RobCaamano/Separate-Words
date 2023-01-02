import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class RestoreBlanks {
    public static ArrayList<String> wordList;
    public static boolean binarySearch(String target, int left, int right) {
        while (left <= right) {
            int middle = left + ((right-left) / 2);
            int test= target.compareTo(wordList.get(middle));
            if (test==0) {
                return true;
            }
            else if (test > 0) {
                left = middle + 1;
            }
            else if (test < 0) {
                right = middle - 1;
        }
        }
        return false;
    }

    public static String addSpace(String searchString) {
        String check;
        String pastcheck;
        if(binarySearch(searchString,0,wordList.size()-1)==true){
            return searchString;
        }
        for(int i=0;i<searchString.length();i++) {
            check=searchString.substring(0,i);
            pastcheck= searchString.substring(i);
            if(binarySearch(check,0, wordList.size()) && pastcheck !=null) {
                return check+" "+addSpace(pastcheck);
            }
        }
        return null;
        }

    public static void main(String[] args) {
        wordList = new ArrayList<String>();
        File file = new File("../resource/asnlib/public/words.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.next();
                wordList.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scan= new Scanner(System.in);
            String test= addSpace(scan.nextLine());
            System.out.println(test);

        scan.close();
    }
}