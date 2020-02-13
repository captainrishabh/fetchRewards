import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Assuming that a word is a ‘pyramid’ word if you can arrange the letters
 * in increasing frequency, starting with 1 and continuing without gaps and
 * without duplicates such that :
 * character 1 would occur 1 time
 * character 2 would occur 2 times
 * character 3 would occur 3 times
 * .
 * .
 * .
 * character nth would occur n times
 * character n+1 would occur n+1 times
 */

public class IsInputAPyramidWord {
    public static void main(String[] args) {

        String inputStr = "bandana";
//        String inputStr = "banana";
//        String inputStr = "cbdacdcbcdd";
//        String inputStr = "cbdadcbcdd";
//        String inputStr = "cbdadcbcdde";
//        String inputStr = "cbdadcbcddeeeee";
//        String inputStr = "cebdadcbcddeeeee";

        System.out.println("Input String : "+inputStr);
        isPyramidString(inputStr);


    }
    /**
     * The method would return a map with character as a key and number of
     * occurrences as the values
     * @param inputStr
     * @return charAndCountMap
     */
    private static Map<Character, Integer> getCharCountMap(String inputStr){
        Map<Character, Integer> charAndCountMap = new HashMap<>();
        int charPosition=0;
        int inputStrlength = inputStr.length();
        while(inputStrlength > 0) {
            char mapKey = inputStr.charAt(charPosition);
            if (!charAndCountMap.containsKey(mapKey)) {
                charAndCountMap.put(mapKey, 1);
            }else {
                charAndCountMap.put(mapKey, charAndCountMap.get(mapKey)+1);
            }
            charPosition++;
            inputStrlength--;

        }
        return charAndCountMap;
    }

    /**
     * The method would sort all the entries of the map in the
     * increasing order of their values
     * @param charAndCountMap
     * @return entryList
     */
    private static ArrayList<Map.Entry<Integer, Integer>> getSortedEntriesList(Map<Character, Integer> charAndCountMap){
        ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList(charAndCountMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println("Char count"+entryList);
        return entryList;
    }


    /**
     * The method would would find out if the string
     * provided is a pyramid string or not.
     * @param inputStr
     * @return pyramid
     */
    private static boolean  isPyramidString(String inputStr){
        boolean pyramid = false;
        if(inputStr != null) {
            Map<Character, Integer> charAndCountMap = getCharCountMap(inputStr);
            ArrayList<Map.Entry<Integer, Integer>> entryList = getSortedEntriesList(charAndCountMap);
            int currentIndex = 0;
            int freqSeriesCurrCount = 1;
            for (Map.Entry<Integer, Integer> entry : entryList)
            {
                if(currentIndex > 0 && entry.getValue() == freqSeriesCurrCount ){
                    pyramid = true;

                }else if (currentIndex == 0 && entry.getValue() == freqSeriesCurrCount){
                    pyramid = true;
                }else{
                    pyramid = false;
                    break;
                }
                freqSeriesCurrCount++;
            }
            System.out.println("Input String is a pyramid :: "+pyramid);

        }
        return pyramid;
    }
}


/**
 * Output :
 * **************************************************
 * Scenario 1 : when Input String is bandana
 *
 * Input String : bandana
 * Char count[b=1, d=1, n=2, a=3]
 * Input String is a pyramid :: false
 *
 * **************************************************
 *
 * Scenario 2 : when Input String is banana
 *
 * Input String : banana
 * Char count[b=1, n=2, a=3]
 * Input String is a pyramid :: true
 *
 * **************************************************
 *
 * Scenario 3 : when Input String is cbdacdcbcdd
 *
 * Input String : cbdacdcbcdd
 * Char count[a=1, b=2, c=4, d=4]
 * Input String is a pyramid :: false
 *
 * **************************************************
 *
 * Scenario 4 : when Input String is cbdadcbcdd
 *
 * Input String : cbdadcbcdd
 * Char count[a=1, b=2, c=3, d=4]
 * Input String is a pyramid :: true
 *
 * **************************************************
 *
 * Scenario 5 : when Input String is cbdadcbcdde
 *
 * Input String : cbdadcbcdde
 * Char count[a=1, e=1, b=2, c=3, d=4]
 * Input String is a pyramid :: false
 *
 * **************************************************
 *
 * Scenario 6 : when Input String is cbdadcbcddeeeee
 *
 * Input String : cbdadcbcddeeeee
 * Char count[a=1, b=2, c=3, d=4, e=5]
 * Input String is a pyramid :: true
 *
 * **************************************************
 *
 * Scenario 7 : when Input String is cebdadcbcddeeeee
 *
 * Input String : cebdadcbcddeeeee
 * Char count[a=1, b=2, c=3, d=4, e=6]
 * Input String is a pyramid :: false
 *
 * **************************************************
 */







