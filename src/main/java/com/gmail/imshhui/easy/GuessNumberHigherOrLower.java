package com.gmail.imshhui.easy;

/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example :
 *
 * Input: n = 10, pick = 6
 * Output: 6
 *
 * @see <a href="https://leetcode.com/problems/guess-number-higher-or-lower/">374. Guess Number Higher or Lower</a>
 * User: liyulin
 * Date: 2019/11/5
 */
public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid;
        while (true) {
            mid = low + (high - low) / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess == -1) {
                high = mid - 1;
            } else if (guess == 1) {
                low = mid + 1;
            }
        }
    }
}

class GuessGame {
    // dummy method implementation
    public int guess(int num) {
        return 1;
    }
}
