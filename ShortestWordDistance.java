/*

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1

*/

class ShortestWordDistance {
    public int shortestDistance(String[] words, String w1, String w2) {

        if (w1 .equals( w2) ) 
            return 0 ; 

        int min_dist = (words.length) + 1; 

        for (int index = 0; index < words.length ; index ++) { 

            if (words[index] .equals( w1)) { 
                for (int search = 0;  search < words.length; search ++)  { 
                    if (words[search] .equals(w2))  {  
                        int curr = Math.abs(index - search) - 1;   
                        if (curr < min_dist)  { 
                            min_dist = curr ; 
                        } 
                    } 
                } 
            } 
        } 
        return min_dist + 1;
    }
}
