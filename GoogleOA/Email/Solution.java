package Google.GoogleOA.Email;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String[] array = {"@hotmail.com","ab@gmail.com","a.b@gmail.com","abc+.work@gmail.com",null,"a.b.b.@hotmail.com","a.b.c","...abc...@gmail.com","...a.b.c...@gmail.com"};
        //String[] array = {"a.b@gmail.com"};
        System.out.println(sol.count(array));
    }
    public int count_1(String[] email_group)
    {
        if(email_group == null || email_group.length == 0)
        {
            return 0;
        }

        HashMap<String,Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0;i<email_group.length;i++) {
            if (email_group[i] == null) {
                continue;
            }
            boolean find_plus = false;
            boolean find_at = false;
            int index = 0;
            StringBuilder sb = new StringBuilder();
            String email = email_group[i];
            int dot_count = 0;
            int start_index = -1;
            while (index < email.length()) {
                char element = email.charAt(index);
                index++;
                if(element == '@'){
                    if(dot_count!=0)
                    {
                        while(dot_count>0)
                        {
                            dot_count--;
                            sb.append(".");
                        }
                    }
                    find_at = true;
                    find_plus = false;
                }
                else if (!find_at && (element == '.' || element == '+' || find_plus)) {
                    find_plus = (element == '+'||find_plus);
                    if(element == '.')
                    {
                        start_index = dot_count == 0? index:start_index;
                        dot_count++;
                    }
                    continue;
                }
                else{
                    if(dot_count != 0 && start_index == 0)
                    {
                        while(dot_count>0)
                        {
                            sb.append(".");
                            dot_count--;
                        }
                        start_index = -1;
                    }
                }
                sb.append(element);
            }

            String final_email = sb.toString();
//            make sure local is not empty and @ must exist
            if (find_at && final_email.charAt(0)!='@')
            {
                Integer email_count = map.get(final_email);
                if(email_count != null)
                {
                    result = email_count == 1? result+1:result;
                }
                else{
                    email_count = 0;
                }

                map.put(final_email,++email_count);
            }
        }
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<String,Integer> entry = iterator.next();
            System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
        }
        return result;
    }
    public int count(String[] email_group)
    {
        if(email_group == null || email_group.length == 0)
        {
            return 0;
        }

        HashMap<String,Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0;i<email_group.length;i++) {
            if (email_group[i] == null) {
                continue;
            }
            boolean find_plus = false;
            boolean find_at = false;
            int index = 0;
            StringBuilder sb = new StringBuilder();
            String email = email_group[i];
            while (index < email.length()) {
                char element = email.charAt(index);
                index++;
                if(element == '@'){
                    find_at = true;
//                    find_plus = false;
                }
                else if (!find_at && (element == '.' || element == '+' || find_plus)) {
                    find_plus = (element == '+'||find_plus);
                    continue;
                }

                sb.append(element);
            }

            String final_email = sb.toString();
//            make sure local is not empty and @ must exist
            if (find_at && final_email.charAt(0)!='@')
            {
                Integer email_count = map.get(final_email);
                if(email_count != null)
                {
                    result = email_count == 1? result+1:result;
                }
                else{
                    email_count = 0;
                }

                map.put(final_email,++email_count);
            }
        }
//        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
//        while(iterator.hasNext())
//        {
//            Map.Entry<String,Integer> entry = iterator.next();
//            System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
//        }
        return result;
    }
}
