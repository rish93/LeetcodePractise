package com.blind75.string;

/*You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

        Return the length of the longest substring containing the same letter you can get after performing the above operations.



        Example 1:

        Input: s = "ABAB", k = 2
        Output: 4
        Explanation: Replace the two 'A's with two 'B's or vice versa.
        Example 2:

        Input: s = "AABABBA", k = 1
        Output: 4
        Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
        The substring "BBBB" has the longest repeating letters, which is 4.*/


public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        //    String input="dvdf";
        String s = "AABABBA";
        int k = 2;
        //    System.out.println("OUTPUT->  "+longestUniqueSubstring(input));
        System.out.println("OUTPUT->  " + characterReplacement(s, k));


    }

    private static int characterReplacement(String s, int k) {

        //lettersToReplace = (end - start + 1) - mostFreqLetter;
        // letterToReplace =(size of SlidingWindow)- mostFrequesntLetter;
        //we can deduce that if lettersToReplace > k(no. of changes) then the window is invalid and we decrease the window size from the left.

        int[] freq = new int[26];
        int mostFreqLetter = 0;
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;  // find the occurence of element from input and increase frequency array in the alphabet position
            mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;

            int lettersToChange = windowSize - mostFreqLetter;
            if (lettersToChange > k) {
                freq[s.charAt(left) - 'A']--;  //AAABB  k=1  taking letter out of frequency
                left++;                        // taking letter out of window

            }
            max = Math.max(max, windowSize);
        }

        return max;
    }


}
