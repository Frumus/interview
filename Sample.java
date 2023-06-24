import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sample {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                String s = "";
                BufferedReader br = new BufferedReader(new FileReader(args[i]));
                String line = br.readLine();
                while (line != null) {
                    s = s + line + "\n";
                    line = br.readLine();
                }
                String[] words = s.split("\\s|\\(|\\)|\\.|\\[|\\]|,|\\+|;|\\\\|\"|!|\\||/|=|\\*|@|<|>");
                ArrayList<String> uniqueWords = new ArrayList<>();
                for (int i = 0; i < words.length; i++) {
                    String testedWord = words[i];
                    int count = 0;
                    for (int j = 0; j < words.length; j++) {
                        if (testedWord.equals(words[j]))
                            count++;
                    }
                    if (count == 1 && !uniqueWords.contains(testedWord))
                        uniqueWords.add(testedWord);
                }
                Collections.sort(uniqueWords);
                
                for (int i = 0; i < uniqueWords.size(); i++) {
                    System.out.println(uniqueWords.get(i));
                }
                br.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            //невозможно
        }
    }
}
