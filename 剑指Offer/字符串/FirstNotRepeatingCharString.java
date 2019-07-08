package zhen.swordoffer.Done;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 */
public class FirstNotRepeatingCharString {
    public static void main(String[] args) {
        String str = "mygodnessmygirl";
        FirstNotRepeatingCharString f = new FirstNotRepeatingCharString();
        System.out.println(f.FirstNotRepeatingChar(str));
    }

    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();//Character存字符，Integer存对应字符出现的次数
        if (str == null) return -1;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {//map中存在此字符，则次数加1
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value + 1);
            } else {
                map.put(str.charAt(i), 1);//map中不存在此字符，次数1
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }


}
/**位图法
 * if(str==null) return -1;
 * char[] ch=str.toCharArray();
 * int[] map=new int[256];
 * for(int i=0;i<ch.length;i++){
 * map[ch[i]]++;
 * }
 * for(int i=0;i<ch.length;i++){
 * if(map[ch[i]]==1) return i;
 * }
 * return -1;
 */
