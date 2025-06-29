public class Test {
    public static void main(String[] args) {
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";
        String str4 = str1 + str2;
        String str5 = "string";
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str3.equals(str4));//false
        System.out.println(str3.equals(str5));//true
        System.out.println(str4.equals(str5));//false
    }
}
