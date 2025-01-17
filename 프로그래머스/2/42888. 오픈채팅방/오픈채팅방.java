import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;

        HashMap<String, String> ids = new HashMap<>();

        int length = 0;
        for (int i=record.length-1; i >= 0; i--) {
            String[] notice = record[i].split("\\s+");

            if (notice.length > 2) {
                if (!ids.containsKey(notice[1])) {
                    ids.put(notice[1], notice[2]);
                }
            }
            
            if ("Change".equals(notice[0])) {
                continue;
            }
            length++;
        }

        answer = new String[length];
        int i = 0;
        for (String item : record) {
            String[] notice = item.split("\\s+");

            if ("Change".equals(notice[0])) {
                continue;
            }

            answer[i] = ids.get(notice[1]) + getMessage(notice[0]);
            i++;
        }
        
        return answer;
    }
    
    private String getMessage(String word) {
        String result = "";
        if ("Enter".equals(word)) {
            result = "님이 들어왔습니다.";
        } else if ("Leave".equals(word)) {
            result = "님이 나갔습니다.";
        }
        return result;
    }
}