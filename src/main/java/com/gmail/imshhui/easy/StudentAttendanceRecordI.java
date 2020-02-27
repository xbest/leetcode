package com.gmail.imshhui.easy;

/**
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 *
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 *
 * @see <a href="https://leetcode.com/problems/student-attendance-record-i/">551. Student Attendance Record I</a>
 * User: liyulin
 * Date: 2020/2/27
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if (s == null) {
            return false;
        }
        int A = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                A++;
            }
            if (c == 'L' && i + 1 < s.length() && i + 2 < s.length() && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                return false;
            }
        }

        // bad case: "LALL", NOTE: more than two CONTINUOUS 'L'
        return A <= 1;
    }

    public boolean checkRecord1(String s) {
        if (s == null) {
            return false;
        }
        if (s.lastIndexOf('A') != s.indexOf('A') || s.contains("LLL")) {
            return false;
        }
        return true;
    }
}
