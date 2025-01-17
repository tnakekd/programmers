import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answerList = new ArrayList<>();

        List<String[]> termGroup = Arrays.stream(terms)
                .map(item -> item.split(" "))
                .collect(Collectors.toList());

        for (int i = 0; i < privacies.length; i++) {
            String[] privacyGroup = privacies[i].split(" ");
            for (String[] term : termGroup) {
                if (privacyGroup[1].equals(term[0])) {
                     int termDay = Integer.parseInt(term[1]) * 28;

                     String result = addDays(privacyGroup[0], termDay);

                     if (today.compareTo(result) >= 0) {
                         answerList.add(i+1);
                     }
                }
            }

        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static String addDays(String startDate, int days) {

        String[] result = new String[3];
        int[] dateGroup = Arrays.stream(startDate.split("\\.")).mapToInt(Integer::parseInt).toArray();

        int date = dateGroup[2] + days;
        int month = dateGroup[1];
        int year = dateGroup[0];

        while (date > 28) {
            date -= 28;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        result[0] = String.format("%04d", year);
        result[1] = String.format("%02d", month);
        result[2] = String.format("%02d", date);

        return String.join(".", result);
    }
}