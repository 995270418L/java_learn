package com.steve.cow_guest;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liu on 3/18/17.
 */
public class Main{

    //fishSize question
//    public static void main(String... args){
//        System.out.println(31/3 > 10.0);
//        Scanner sc = new Scanner(System.in);
//        String[] orders = new String[3];
//        while(sc.hasNext()){
//            //save a group of data
//            for(int i=0;i<3;i++){
//                orders[i] = sc.nextLine();
//            }
//            int num = Integer.valueOf(orders[1]);   //鱼缸鱼的数量
//            String[] size_new = orders[0].split(" "); //the scope of fish
//            String[] size_serve = orders[2].split(" ");
//            List<Integer> list = new ArrayList(); //所有鱼
//            for(int i=Integer.valueOf(size_new[0]);i<=Integer.valueOf(size_new[1]);i++){
//                boolean eat = false;
//                for(int j=0;j<num;j++){
//                    int tmp = Integer.valueOf(size_serve[j]);
//                    if( tmp*2 <= i && tmp*10 >= i ){
//                        eat = true;
//                    }else if(i*2 <= tmp && i*10 >= tmp){
//                        eat = true;
//                    }
//                }
//                if(!eat){
//                    list.add(i);
//                }
//            }
//            System.out.println(list.size());
//        }
//    }

    //DNA
//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String line = sc.nextLine();
//            String left = line.split(" ")[0];
//            String right = line.split(" ")[1]; //修改这一条
//            int count =0;
//            for(int i=0;i<left.length();i++){
//                //判断是否配对
//                char tmp_l = left.charAt(i);
//                char tmp_r = right.charAt(i);
//                switch(tmp_l){
//                    case 'A': if(tmp_r != 'T') count++;break;
//                    case 'C': if(tmp_r != 'G') count ++ ; break;
//                    case 'G' : if(tmp_r != 'C') count ++; break;
//                    case 'T' : if(tmp_r != 'A') count ++; break;
//                    default:break;
//                }
//            }
//            System.out.println(count);
//        }
//        sc.close();
//    }

    //sort int
//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            String[] input = new String[2];
//            for (int i = 0; i < 2; i++) {
//                input[i] = sc.nextLine();
//            }
//            int num = Integer.valueOf(input[0]);
//            String[] line = input[1].split(" ");
//            int[] tmp = new int[num];
//            for (int i = 0; i < num; i++) {
//                tmp[i] = Integer.valueOf(line[i]);
//            }
//            List<Integer> list = new ArrayList();
//            StringBuilder sb = new StringBuilder();
//            //排序
//            Arrays.sort(tmp);
//            int first = tmp[0];
//            boolean doub = true;
//            int count = 0;
//            for (int i = 0; i < tmp.length; i++, first++) {
//                if (tmp[i] != first) {
//                    int diff = tmp[i] - first;
//                    if (diff > 1) {
//                        doub = false;
//                        break;
//                    } else {
//                        //这里不能进两次
//                        list.add(first);
//                        doub = false;
//                        first++;
//                        count++;
//                    }
//                }
//            }
//            if (doub) {
//                list.add(tmp[0] - 1);
//                list.add(tmp[num - 1] + 1);
//            }
//            if (list.size() == 0 || count > 1) {
//                System.out.println("mistake");
//            } else {
//                for (Integer a : list) {
//                    sb.append(a).append(" ");
//                }
//                System.out.println(sb.toString().substring(0, sb.lastIndexOf(" ")));
//            }
//
//        }
//    }

//    public static void main(String... args){
//        DecimalFormat df = new DecimalFormat("#0.000");
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String line = sc.nextLine();
//            double pi = Math.PI;
//            int l = Integer.valueOf(line.split(" ")[0]);
//            int r = Integer.valueOf(line.split(" ")[1]);
//            double zc = 2*pi*r;
//            int quan = (int) (l / zc);
//            double leave = l - quan * zc ;  //left 距离
//            //损失
//            for(int i=0;i<2;i++) {
//                StringBuilder sb = new StringBuilder();
//                double jd = (2*pi) * leave / (4*pi);
//                if(i==1){
//                    double x = r * Math.cos(jd);
//                    double y = r * Math.sin(jd);
//                    sb.append(df.format(x)).append(" ").append(df.format(y));
//                    System.out.println(sb.toString());
//                }else{
//                    jd = 2*pi - jd;
//                    double x = r * Math.cos(jd);
//                    double y = r * Math.sin(jd);
//                    sb.append(df.format(x)).append(" ").append(df.format(y));
//                    System.out.println(sb.toString());
//                }
//            }
//        }
//        sc.close();
//    }

//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String[] orders = new String[2];
//            for(int i=0;i<2;i++){
//                orders[i] = sc.nextLine();
//            }
//
//            int num = Integer.valueOf(orders[0]);
//            String[] n = orders[1].split(" ");
//            int count = 0;
//            for(int i=num-1;i>=0;i--){
//                count += judge(i,num-1);
//            }
//            System.out.println(count);
//        }
//
//    }
//    static int judge(int i,int num){
//        int big =dg(num,i);
//        int little = dg_rev(1,i);
//        int aa = big/little;
//        return aa;
//    }
//    static int dg(int start,int end){
//        int result = end;
//        for(int i=end;i<start;i++){
//            result = result * (i+1);
//        }
//        return result;
//    }
//    static int dg_rev(int start,int end){
//        int result = start;
//        for(int i = start; i< end; i++){
//            result = result * (i+1);
//        }
//        return result;
//    }

//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int num = sc.nextInt();
//            Vector<String> vector = new Vector();
//            for(int i=0;i<num*2;i++){
//                if(i ==0 ){
//                    String line_first = sc.nextLine();
//                }
//                String line = sc.nextLine();
//                vector.addElement(line);
//            }
//            int k = 1;
//            for(int i=1;i<vector.size();i += 2){
//                StringBuilder sb = new StringBuilder();
//                int b = 0,a = 0;
//                for(int j =0;j<Integer.valueOf(vector.get(i-1));j++){
//
//                    if(j % 2 == 0){
//                        b += Integer.valueOf(vector.get(i).split(" ")[j]);
//                    }else{
//                        a += Integer.valueOf(vector.get(i).split(" ")[j]);
//                    }
//                }
//                String result = sb.append(a).append(" ").append(b).toString();
//                System.out.println("Case #"+k+": " + result);
//                k += 1;
//            }
//        }
//    }

//    public static void main(String... args){
//        String s;
//        System.out.println(s);
//    }
//   public static void main(String... args){
//       ArrayList<Integer> a = new ArrayList();
//       ArrayList<Integer> b = new ArrayList();
//
//       for(int i=0;i<10;i++){
//           a.add(i);
//       }
//
//       //反转ArrayList中的值
//       for(int i=a.size()-1;i>=0;i--){
//           b.add(a.get(i));
//       }
//
//   }
//   static void fermin(Integer i){
//       i = new Integer(11);
//   }

//    static int[] x = {1,11};
//    static int[] y = {5,3};
//    public static void main(String... args){
//        JumpFloorII(5);
//    }
//    static int gcd(int a,int b){
//        if(a==0 && b==0) return 1;
//        if(b==0) return a;
//        return a % b==0 ? b : gcd(b, a % b);
//    }
//    static void JumpFloorII(int n){
//        int f= 2,g=1;
//        n = n-2;
//        for(int i=1;i<=n;i++){
//            f = f + g + i;
//            g = f - g - i;
//        }
//        System.out.println(f);
//    }
//
//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            int num = sc.nextInt();
//            String[] line = new String[num];
//            for(int i=0;i<num;i++){
//                if(i == 0) sc.nextLine();
//                line[i] = sc.nextLine();
//            }
//            int ans = num;
//            for(int i=0;i<line.length-1;i++){
//                String pattern = "[^"+line[i]+"]";
//                Pattern p = Pattern.compile(pattern);
//                for(int j=i+1;j<line.length;j++){
//                    Matcher m = p.matcher(line[j]);
//                    if(!m.find()){
//                        ans --;
//                    }
//                }
//                if(ans == 1 ){
//                    break;
//                }
//            }
//            System.out.println(ans);
//        }
//    }

//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String line = sc.nextLine();
//            int N = Integer.valueOf(line.split(" ")[0]);
//            int M = Integer.valueOf(line.split(" ")[1]);
//            int K = Integer.valueOf(line.split(" ")[2]);
//            if(N >= M) {
//                int ans = 0;
//                for(int i=2;i<=M;i++){
//                    ans += 26;
//                }
//            }
//        }
//    }
//
//    public static void main(String... args){
//        int[] a = {1,2,3,4,5,6,7};
//        reOrderArray(a);
//        for(Integer i: a){
//            System.out.print(i+"\t");
//        }
//    }
//        public static void reOrderArray(int[] array) {
//            int os_num = 0;
//            for(int i=0;i<array.length;i++){
//                if(isEven(array[i])){
//                    os_num ++;
//                }
//            }
//            int js_num = array.length - os_num;
//            int[] js = new int[array.length];
//            int[] os = new int[os_num];
//            for(int i=0,j=0,z=0;i<array.length;i++){
//                if(isEven(array[i])){
//                    os[j] = array[i];
//                    j++;
//                }else{
//                    js[z] = array[i];
//                    z++;
//                }
//            }
//            for(int i=js_num,j=0;j<os_num;i++,j++){
//                js[i] = os[j];
//            }
//            for(int i=0;i<array.length;i++){
//                array[i] = js[i];
//            }
//        }
//        static boolean isEven(int i){
//            return (i & 1) == 0;
//        }
//
//    static class ListNode{
//        int val;
//        ListNode next = null;
//        ListNode(int val){
//            this.val = val;
//        }
//    }
//    public static ListNode find(ListNode head,int k){
//        ListNode p=null,pre=null;
//        p = head;
//        pre = head;
//        int count = 0,a=k;
//        //遍历列表
//        while(p != null){
//            p = p.next;
//            count ++;
//            if(k<1){
//                pre = pre.next;
//            }
//            k--;
//        }
//        if(count < a) return null;
//        return pre;
//    }
//    public static void main(String... args){
//        ListNode ln = new ListNode(1);
//        ListNode ln2 = new ListNode(2);
//        ListNode ln3 = new ListNode(3);
//        ListNode ln4 = new ListNode(4);
//        ListNode ln5 = new ListNode(5);
//        ln.next = ln2;
//        ln2.next = ln3;
//        ln3.next = ln4;
//        ln4.next = ln5;
//        find(ln,1);
//    }

//    public static void main(String... args){
//        Demo demo = new Demo();
//        System.out.println("This is main");
//    }

//    static class RandomNode implements Cloneable{
//        int label;
//        RandomNode next;
//        RandomNode random;
//        RandomNode(int label){
//            this.label = label;
//        }
//
//        public RandomNode clone() throws CloneNotSupportedException {
//            return (RandomNode) super.clone();
//        }
//    }
//    public static void main(String... args) throws CloneNotSupportedException {
//        RandomNode rn1 = new RandomNode(1);
//        RandomNode rn2 = new RandomNode(2);
//        RandomNode rn3 = new RandomNode(3);
//        rn1.next = rn2;
//        rn2.next = rn3;
//        rn1.random = rn3;
//        rn2.random = rn1;
//        rn3.next = rn1;
//        rn3.random = rn2;
//        Main main = new Main();
//        RandomNode head = main.Clone(rn1);
//        System.out.println(head.random.label);
//    }
//    public RandomNode Clone(RandomNode pHead){
//        if(pHead == null) return null;
//        RandomNode head = new RandomNode(pHead.label);
//        head.next = pHead.next;
//        head.random = pHead.random;
//        head.next= Clone(pHead.next);
//        return head;
//    }

//    public static void main(String... args){
//        String a ="hello,world";
//        Stack<String[]> stack = new Stack();
//        stack.push(new String[]{a,""});
//    }

//    public static void main(String... args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String source = sc.nextLine();
//            solve(source);
//        }
//    }

    private static void solve(String source) {
        if(source.equals("")){
            System.out.println(1);
            return;
        }
        int len = source.length();
        char[] c = source.toCharArray();
        Set<String> list = new HashSet<>();
        for(int i=0; i<len ; i++){
            // 这里就相当于截取了字符source[i];
            String s1 = source.substring(0,i);
            String s2 = source.substring(i+1,len);
            String s = s1 + s2;
            for(int j=0; j<len ; j++){
                //分离出两部分，以便插入数据
                String b1 = s.substring(0,j);
                String b2 = s.substring(j,len-1); // s 的长度为len-1
                String insert = String.valueOf(c[i]);
                String result = b1 + insert + b2;
                if(!result.equals(source) && isLegal(result.toCharArray())){
                    list.add(result);
                }
            }
        }
        System.out.println(list.size());
    }

    private static boolean isLegal(char[] a){
        int num = 0;
        for(int i=0; i<a.length ;i++){
            if(a[i] == '('){
                num ++;
            }else{
                num --;
            }
            if(num < 0){
                return false;
            }
        }
        if(num != 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Main().printMax("abcd12345ed125ss123058789");
    }

    public void printMax(String str){
        char[] arr = str.toCharArray();
        int len = arr.length;
        int[] dp = new int[len];
        if(arr[0] >= '0' && arr[0] <= '9'){
            dp[0] = 1;
        }
        for(int i=1;i<len;i++){
            if(arr[i] >= '0' && arr[i] <= '9'){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = 0;
            }
        }

        int max = 0;
        for(int i=0;i<dp.length;i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        String result = null;
        for(int i=0;i<dp.length;i++){
            if(dp[i] == max){
                result = str.substring(i-max+1,i+1);
            }
        }
        System.out.println(result);
    }
}
