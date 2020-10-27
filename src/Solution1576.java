/**
 * 替换所有的问号
 * @author Yin
 * @date 2020/10/27
 */
public class Solution1576 {
    public String modifyString(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        // 当只有一个?存在的时候直接进行下面的逻辑会出现问题
        if (s.length() == 1) {
            if (s.charAt(0) == '?') {
                return "a";
            } else {
                return s;
            }
        }
        char[] charArray = s.toCharArray();
        char firstChoose = 'a';
        for (int i = 0; i < charArray.length; ++i) {
            char ch = charArray[i];
            if (ch == '?') {
                if (i != 0 && i != charArray.length - 1) {
                    char pre = charArray[i - 1];
                    char post = charArray[i + 1];
                    int index = 0;
                    char temp = firstChoose;
                    while (temp == pre || temp == post) {
                        temp = (char)(firstChoose + index);
                        index++;
                    }
                    charArray[i] = temp;

                } else if (i != 0) {
                    char pre = charArray[i - 1];
                    int index = 0;
                    char temp = firstChoose;
                    while (temp == pre) {
                        temp = (char)(firstChoose + index);
                        index++;
                    }
                    charArray[i] = temp;
                } else {
                    char post = charArray[i + 1];
                    int index = 0;
                    char temp = firstChoose;
                    while (temp == post) {
                        temp = (char)(firstChoose + index);
                        index++;
                    }
                    charArray[i] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : charArray) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
