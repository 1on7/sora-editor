/*
 *    CodeEditor - the awesome code editor for Android
 *    Copyright (C) 2020-2021  Rosemoe
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *     Please contact Rosemoe by email roses2020@qq.com if you need
 *     additional information or have any questions
 */
package io.github.rosemoe.editor.text;

public class TextUtils {

    public static int countLeadingSpaceCount(CharSequence text, int tabWidth) {
        int p = 0, count = 0;
        while (p < text.length()) {
            if (isWhitespace(text.charAt(p))) {
                if (text.charAt(p) == '\t') {
                    count += tabWidth;
                } else {
                    count++;
                }
                p++;
            } else {
                break;
            }
        }
        return count;
    }

    public static String createIndent(int indentSize, int tabWidth, boolean useTab) {
        indentSize = Math.max(0, indentSize);
        int tab = 0;
        int space;
        if (useTab) {
            tab = indentSize / tabWidth;
            space = indentSize % tabWidth;
        } else {
            space = indentSize;
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < tab; i++) {
            s.append('\t');
        }
        for (int i = 0; i < space; i++) {
            s.append(' ');
        }
        return s.toString();
    }

    private static boolean isWhitespace(char ch) {
        return ch == '\t' || ch == ' ';
    }

    /**
     * Check whether character is a leading emoji
     */
    public static boolean isEmoji(char ch) {
        return ch == 0xd83c || ch == 0xd83d || ch == 0xd83e;
    }
}
