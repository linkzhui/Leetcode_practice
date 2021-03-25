package Google.Graph.Leetcode_Word_Ladder_II;

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        List<List<String>> result = sol.findLaddersBiBfs("hit","cog",wordList);
        for(List<String> part_result:result) {
            for (String word:part_result) {
                System.out.println(word+" ");
            }
            System.out.println();
        }
    }

    public List<List<String>> findLaddersFindParents (String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return result;
        }
        dict.remove(beginWord);
        dict.remove(endWord);

        //Steps记录每个从begin words到当前点的最短距离
        HashMap<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 1);
        //因为可能有多个parents到达这个点的距离是相同，都是最短距离
        HashMap<String, List<String>> parents = new HashMap<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast(beginWord);
        int step = 0;
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            ++step;
            for (int size = queue.size(); size > 0; size--) {
                String p = queue.pollFirst();
                char[] chars = p.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char orig_char = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String temp_word = new String(chars);
                        if (temp_word.equals(endWord)) {
                            if (!parents.containsKey(endWord)) {
                                parents.put(endWord, new ArrayList<>());
                            }
                            parents.get(endWord).add(p);
                            found = true;
                        } else if (steps.containsKey(temp_word) && step < steps.get(temp_word)){
                            parents.get(temp_word).add(p);
                        }
                        if (dict.contains(temp_word)) {
                            dict.remove(temp_word);
                            queue.offerLast(temp_word);
                            parents.put(temp_word, new ArrayList<>());
                            parents.get(temp_word).add(p);
                            steps.put(temp_word, steps.get(p) + 1);
                        }
                    }
                    chars[i] = orig_char;
                }
            }
        }
        if (found) {
            pathGnerateList(result, endWord, parents, new ArrayList<>());
        }
        return result;

    }

    private void pathGnerateList (List<List<String>> result, String cur_word, HashMap<String, List<String>> parents, List<String> path) {

        if (!parents.containsKey(cur_word)) {
            //The begin word have no parents
            path.add(0, cur_word);
            result.add(new ArrayList<>(path));
            path.remove(0);
            return;
        }
        path.add(0,cur_word);
        for (String parent : parents.get(cur_word)) {
            pathGnerateList(result, parent, parents, path);
        }
        path.remove(0);
    }


    //Bi BFS
    //Most prefered solution：
    public List<List<String>> findLaddersBiBfs(String beginWord, String endWord, List<String> wordList) {
        //利用两个set，一个set记录beginword的扩展，一个set记录endword的扩展
        //然后轮换着expand all the nodes from two sets, generated new nodes and put back to the set
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        dict.remove(beginWord);
        List<List<String>> result = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return result;
        }

        //这里需要用一个hashmap来记录每一个node的children，然后通过iterate children来找到最后的path
        HashMap<String, List<String>> child = new HashMap<>();
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        //把begin word加到begin set里面，end word加到end set里面
        begin.add(beginWord);
        end.add(endWord);
        boolean found = false;
        boolean swap = false;
        //如果一个set为空了，就代表之间不存在一条从begin word到end word的path
        while (!found && !begin.isEmpty() && !end.isEmpty()) {

            //每次都扩展size比较小的set，为了省时间
            if (begin.size() > end.size()) {
                HashSet<String> temp = begin;
                begin = end;
                end = temp;
                swap = !swap;
            }
            //这里为什么要从dictionary里面remove all set呢，不把单词加到set的时候就从dict里面删掉，
            // 是因为在同一层，可能有多条可以通往这个点的路径 ，需要记录下当前层到达这个点的path(同时是到达这个点的最短path)
            dict.removeAll(begin);
            dict.removeAll(end);
            HashSet<String> temp = new HashSet<>();
            for (String word : begin) {
                //iterate smaller size set
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char orig = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        //因为end set里面最开始存的是end word，我们要加child的话，end word就是child，所以我们找到的新的word其实是parents，
                        //然后begin set里面存的是begin word，我们找到的新的可以变化的word的是child

                        String new_word = new String(chars);
                        String key = swap? new_word:word;
                        String value = swap? word:new_word;
                        if (end.contains(new_word)) {
                            //当前层已经找到找到了结果，所以我们知道，最短的路径就只能存在当前层，当iterate完当前的set之后，就可以break while loop
                            found = true;
                            if(!child.containsKey(key)) {
                                child.put(key, new ArrayList<>());
                            }
                            child.get(key).add(value);
                        } else if (dict.contains(new_word) && !found) {
                            temp.add(new_word);
                            if (!child.containsKey(key)) {
                                child.put(key, new ArrayList<>());
                            }
                            child.get(key).add(value);
                        }
                    }
                    chars[i] = orig;
                }
            }
            begin = temp;
        }
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            getPaths(beginWord, endWord, child, path, result);
        }
        return result;
    }

    private void getPaths(String word, String endWord, HashMap<String, List<String>> children, List<String> path, List<List<String>> result) {
        if (word.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        //当前的node没有孩子了，就return
        if (!children.containsKey(word)) {
            return;
        }
        for (String child:children.get(word)) {
            path.add(child);
            getPaths(child, endWord, children, path, result);
            path.remove(path.size()-1);
        }
    }




    //dfs: not suggested, prefer bfs for shortest distance in graph
    //time complexity: O(n*26^l)  n: n is the size for the word list      l: l is the length of the word
    //space complexity: O(n+k*result_length)  k: k is the number of paths
    public List<List<String>> wordLadder(String beginWord, String endWord, List<String> wordList){
        Set<String> set = new HashSet<>();

        set.addAll(wordList);
        if(!set.contains(endWord))
            return null;
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        path.add(beginWord);
        visited.add(beginWord);
        input(beginWord, endWord, set, res, path, visited);
        return res;

    }
    void input (String beginWord, String endWord, Set<String> set, List<List<String>> res, List<String> path, Set<String> visited){
        if(endWord.equals(beginWord)){
            //1. res add from previos (res.get(0).size() == path.size())
            //2. res add new (1. res size is 0 2. res.length > path.size() )
            if (res.size() != 0 && res.get(0).size() > path.size()) {
                //res = new ArrayList<>();
                res.clear();
                res.add(new ArrayList<>(path));
            } else if(res.size() == 0 || res.get(0).size() == path.size()){
                res.add(new ArrayList<>(path));
            }
            return;

        }
        char[] word = beginWord.toCharArray();
        for(int i=0; i<word.length; i++){
            char origin_char = word[i];
            for(char ch = 'a'; ch <= 'z'; ch++){
                word[i] = ch;
                String s = new String(word);
                if(!visited.contains(s) && set.contains(s)){
                    visited.add(s);
                    path.add(s);
                    input(s, endWord, set, res, path, visited);
                    path.remove(path.size()-1);
                    visited.remove(s);
                }
            }
            word[i] = origin_char;
        }

    }
}

