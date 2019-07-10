package zhen.swordoffer.Done;

/**
 * 翻转单词顺序列
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentenceOfWords {
    public static void main(String[] args) {
        String str = "abcd ef ghi. jklmn";
        ReverseSentenceOfWords re = new ReverseSentenceOfWords();
        System.out.println(re.ReverseSentence(str));
    }

    /**
     * 算法思想：先翻转整个句子，然后，依次翻转每个单词。
     * 依据空格来确定单词的起始和终止位置
     */
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);//翻转整个句子
        int blank = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int nextBlank = i;
                reverse(chars, blank, nextBlank - 1);//依次翻转每个单词
                blank = nextBlank + 1;
            }
        }
        reverse(chars, blank, chars.length - 1);//最后一个单词单独进行反转
        return new String(chars);
    }

    /**
     * 翻转整个句子
     */
    public String reverse(char[] ch, int begin, int end) {
        while (end > begin) {
            char temp = ch[begin];
            ch[begin] = ch[end];
            ch[end] = temp;
            begin++;
            end--;
        }
        return new String(ch);
    }

}
/**
 * 另一种思路：
 * public String ReverseSentence(String str) {
 * if(str.trim().equals("")){
 * return str;
 * }
 * String[] a = str.split(" ");//按照空格分割字符串为字符串数组
 * StringBuffer o=new StringBuffer();
 * for(int i=a.length;i>0;i--){
 * o.append(a[i-1]);
 * if(i>1) o.append(" ");//去掉最后一个空格
 * <p>
 * }
 * <p>
 * return o.toString();
 * }
 */
