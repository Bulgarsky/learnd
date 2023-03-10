public class Main {
    public static void main(String[] args) {
        System.out.println("string methods");
        String str1 = "Products";
        String str2 = new String("Owner");
        String str3 = new String (new char[]{'R', 'U', 'S', 'S', 'I', 'A'});
        System.out.println(str1+str2+str3);
        String str4 = new String(new char[]{'R', 'U', 'S', 'S', 'I', 'A'}, 1,2);
        System.out.println(str1+str2+str4);

        char[] chars = str4.toCharArray();
        System.out.println(chars);
        System.out.println(chars[0]);
        System.out.println(str4.length());

        String str5 = null;
        if (str5 == null) System.out.println("str5 is null");

        String str6 = "Worldd";
        String strRes1 = str1+str2+str6;
        System.out.println(strRes1);

        String strRes2 = str2.concat(str6);
        System.out.println(strRes2);

        String strRes3 = String.join("_", str6,str1,str2,strRes1);
        System.out.println(strRes3);

        char char1 = str6.charAt(2);
        char[] chars2 = new char[3];
        System.out.println(char1+" _ "+ chars2);

        str1.getChars(0,3, chars2, 0);
        System.out.println(chars2);

        String str7 = "WORLDD";
        System.out.println(str6 == str7);
        System.out.println(str6.equals(str7));
        System.out.println(str6.equalsIgnoreCase(str7));

        System.out.println(str7.indexOf("W"));
        System.out.println(str7.indexOf("R"));
        System.out.println(str7.lastIndexOf("DD"));
        System.out.println(str7.startsWith("WO"));
        System.out.println(str7.endsWith("DD"));
        System.out.println(str7.replace("DD", "D of the Earth"));
    }
}