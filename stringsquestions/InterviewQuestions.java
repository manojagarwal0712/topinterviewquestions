package stringsquestions;

import java.util.LinkedHashMap;
import java.util.Map;

public class InterviewQuestions {

    /**
     * Maximum occurring character in an input string
     *Input: ”test sample”
     * Output: 't'
     * 
     *
     * Input:”test”
     * Output:'t'
     */

    public static char findMaxOccurChar(String str){
        //create map to keep the iterated char their count
        Map<Character,Integer> mapCharCount = new LinkedHashMap<>();

        //iterate thorugh all the char of string one by one
        for (int i=0; i< str.length(); i++){
            Character ch = str.charAt(i);

            //verify if the char is already exists in Map , if yes - then increment the count of char by one else
            // add the char to map with count 1.
            if(mapCharCount.containsKey(ch)){
                mapCharCount.put(ch,mapCharCount.get(ch)+1);
            }else {
                mapCharCount.put(ch,1);
            }
        }

        //iterate through the created Map and return the char with max count.
        int count =0;
        char ch = ' ';
        for (Map.Entry<Character,Integer> entries : mapCharCount.entrySet()) {
            if(entries.getValue()>count){
                ch=entries.getKey();
                count = entries.getValue();
            }
        }
        return ch;
    }
}
