package Google.GoogleOA.Email;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String[] array = {"@hotmail.com","ab@gmail.com","a.b@gmail.com","abc+.work@gmail.com",null,"a.b.b.@hotmail.com","a.b.c","...abc...@gmail.com"};
        System.out.println(sol.count(array));
    }
    public int count(String[] email_group)
    {
        if(email_group == null || email_group.length == 0)
        {
            return 0;
        }

        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<email_group.length;i++) {
            boolean find_plus = false;
            boolean find_at = false;

            if (email_group[i] == null) {
                continue;
            }
            int index = 0;
            StringBuilder sb = new StringBuilder();
            String email = email_group[i];

            while (index < email.length()) {
                char element = email.charAt(index);
                index++;
                if (!find_at && (element == '.' || element == '+' || find_plus)) {
                    find_plus = (element == '+'||find_plus);
                    continue;
                }
                else if(element == '@'){
                    find_at = true;
                    find_plus = false;
                }
                sb.append(element);
            }

            //make sure local is not empty and @ must exist
            if (find_at && sb.charAt(0)!='@')
            {
                set.add(sb.toString());
            }
        }


        return set.size();
    }
}
