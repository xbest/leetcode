package com.gmail.imshhui.medium;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Rectangle Area
 *
 * Example:
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 *
 * @see <a href="https://leetcode.com/problems/rectangle-area/"></a>
 * User: liyulin
 * Date: 2019/10/9
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int overlap = 0;
        if (left < right && bottom < top) {
            overlap = (right - left) * (top - bottom);
        }
        return area1 + area2 - overlap;
    }
}
