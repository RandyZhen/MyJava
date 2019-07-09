package zhen.swordoffer.Done;
/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnceOfShuzu {
    public static void main(String[] args) {
    }
/**
 * 思路：位运算，异或：相同为0、不同为1.
 * 可以用位运算实现，如果将所有所有数字相异或，则最后的结果肯定是那两个只出现一次的数字异或的结果，
 * 所以根据异或的结果1所在的位，把数字分成两半，按照这个位将数组分成两个子数组，分组标准是数字在这个位上的值是否为1
 * 每一半里含有只出现一次的数据和成对出现的数据,这样继续对每一半相异或则可以分别求出两个只出现一次的数字。
 **/
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2)
            return;
        int temp = 0;
        for (int i = 0; i < array.length; i++)
            temp ^= array[i];
        int indexOf1 = findFirstBitIs(temp);
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i], indexOf1))//在第一个为1的位数上为1的所有数字 异或
                num1[0] ^= array[i];
            else                         //在第一个为1的位数上为0的所有数字 异或
                num2[0] ^= array[i];
        }
    }
    /**找到异或结果中第一个为1的位数*/
    public int findFirstBitIs(int num) { //从左向右移动，获取第一个为1的位数
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit) < 8 * 4) {
            num = num >> 1;//将num右移1位（也即除以2）
            ++indexBit;
        }
        return indexBit; //返回第一个为1的位数
    }

    public boolean isBit(int num, int indexBit) {//判断其他数字在第一个为1的位数上是否为1
        num = num >> indexBit;
        return (num & 1) == 1;
    }

}

/**
 * 1.首先我们考虑这个问题的一个简单版本：一个数组里除了一个数字之外，其他的数字都出现了两次。请写程序找出这个只出现一次的数字。
 * 这个题目的突破口在哪里？题目为什么要强调有一个数字出现一次，其他的出现两次？我们想到了异或运算的性质：任何一个数字异或它自己都等于0 。
 * 也就是说，如果我们从头到尾依次异或数组中的每一个数字，那么最终的结果刚好是那个只出现一次的数字，因为那些出现两次的数字全部在异或中抵消掉了。
 * <p>
 * **数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
 *
             * public static int find1From2(int[] a){
             * int len = a.length, res = 0;
             * for(int i = 0; i < len; i++){
             * res = res ^ a[i];
             * }
             * return res;
             * }
 * 有了上面简单问题的解决方案之后，我们回到原始的问题。如果能够把原数组分为两个子数组。在每个子数组中，包含一个只出现一次的数字，而其它数字都出现两次。
 * 如果能够这样拆分原数组，按照前面的办法就是分别求出这两个只出现一次的数字了。
 *
 * 因为a^b^a=b,所以问题就变成了把一个包含两个出现一次数字的数组array拆分成二个出现一次数组array1和array2的问题。
 * 怎么分呢，假设数组为a,a,b,b,c,c,d,f,依次异或，最后的结果是d^f，那么d^f的第n位为1，也就意味着d和f的第n位肯定不同，所以可以按照这个条件拆分数组d和f就肯定会被分开。
 * <p>
 * 我们还是从头到尾依次异或数组中的每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。因为其它数字都出现了两次，在异或中全部抵消掉了。
 * 由于这两个数字肯定不一样，那么这个异或结果肯定不为0 ，也就是说在这个结果数字的二进制表示中至少就有一位为1 。
 * 我们在结果数字中找到第一个为1 的位的位置，记为第N位。现在我们以第N位是不是1 为标准把原数组中的数字分成两个子数组，
 * 第一个子数组中每个数字的第N 位都为1，而第二个子数组的每个数字的第N位都为0 。
 * 现在我们已经把原数组分成了两个子数组，每个子数组都包含一个只出现一次的数字，而其它数字都出现了两次。因此到此为止，所有的问题我们都已经解决。
 * <p>
             * public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
             * if (array == null || array.length <= 1) {
             * num1[0] = num2[0] = 0;
             * return;
             * }
             * int len=array.length;
             * int sum=0;
             * int index;
             * for(int i=0;i<len;i++){
             * sum ^=array[i];
             * }
             * for(index=0;index<32;index++){
             * if((sum & (1 << index)) != 0) break;
             * }
             * for(int i = 0; i < len; i++){
             * if((array[i] & (1 << index))!=0){
             * num2[0] ^= array[i];
             * }else{
             * num1[0] ^= array[i];
             * }
             * }
             * }
 * **数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
             * @param a
             * @return public static int find1From3(int[] a){
             * int[] bits = new int[32];
             * int len = a.length;
             * for(int i = 0; i < len; i++){
             * for(int j = 0; j < 32; j++){
             * bits[j] = bits[j] + ( (a[i]>>j) & 1);  //a[i]第j位为1，则bits[j]++;
             * }
             * }
             * int res = 0;
             * for(int i = 0; i < 32; i++){
             * if(bits[i] % 3 !=0){    //bits[i]%3!=0 说明只出现一次的数在第i位为1，否则为0
             * res = res | (1 << i);//把1左移i位，相当于在第i位补1，从1-31位，依次补齐，即得到只出现一次的数字
             * }
             * }
             * return res;
             * }
 * <p>
 * 2.用hashset属性：值不重复
             * public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
             * <p>
             * HashSet<Integer> set = new HashSet<>();
             * <p>
             * for (int i = 0;i < array.length;i++){
             * if(!set.add(array[i])){
             * set.remove(array[i]);
             * }else{
             * set.add(array[i]);
             * }
             * <p>
             * Object[] temp =set.toArray();
             * num1[0] = (int) temp[0];
             * num2[0] = (int) temp[1];
             * }
 * 3.与2思路类似
             * public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
             * ArrayList<Integer> arrayList = new ArrayList<>();
             * for (int i = 0; i < array.length; i++) {
             * if (!arrayList.contains(array[i])) {
             * arrayList.add(array[i]);
             * } else {
             * arrayList.remove(new Integer(array[i]));
             * }
             * if (arrayList.size() > 1) {
             * num1[0] = arrayList.get(0);
             * num2[0] = arrayList.get(1);
             * <p>
             * }
             * }
             * }
 */
