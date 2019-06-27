package zhen.swordoffer.Done;
/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * */
public class JuxingFugai {
    public static int RectCover(int target) {
        if(target<1){
            return 0;
        }else if(target==1||target==2){
            return target;
        }else{
            return RectCover(target-1)+ RectCover(target-2);
        }

    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(RectCover(n));
    }
}
/**变形的斐波那契数列
* f(n)
* 第一个竖着放时，剩下的f(n-1)
* 第一个横着放时，左下角必须也横着放一个，剩下的f(n-2)
* f(n)=f(n-1)+f(n-2)
* */