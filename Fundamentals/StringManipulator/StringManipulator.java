public class StringManipulator {
    public String trimAndConcat(String A, String B){
        String s1 = A.trim(); 
        String s2 = s1.concat(B.trim());
        String s = s2.trim();
        return s;
    }
    public Integer getIndexOrNull(String str, char letter){
        char ch =letter;
        if (str.indexOf(ch)>=0) {
            Integer index = str.indexOf(ch);
            return index;
        } else {
            return null;
        }
    }
    public Integer getIndexOrNull(String str1, String str2){
        if (str1.indexOf(str2)>=0) {
            Integer index = str1.indexOf(str2);
            return index;
        } else {
            return null;
        }
    }
    public String concatSubstring(String str1, int num1, int num2, String str2){
        if (str1.length()>0 && str2.length()>0 && num1>=0 && num2>=0) {
            String s1 = str1.substring(num1, num2);
            String s2 = str2;
            String newStr = s1.concat(s2);
            return newStr;
        } else {
            return null;
        }
    }
}
