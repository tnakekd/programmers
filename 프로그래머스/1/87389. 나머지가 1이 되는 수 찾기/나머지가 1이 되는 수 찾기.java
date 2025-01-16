class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int i = 0;
        while (n > i) {
            if (n % ++i == 1) {
                answer = i;
                i = n;
            }
                
        }
        
        return answer;
    }
}