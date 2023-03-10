public class Main {
    public static void main(String[] args) {
        System.out.println("stringBuilder");
        String str = "This products";
        StringBuilder strBuild = new StringBuilder(str);
        System.out.println("strBuild: "+strBuild);
        char ch1 = strBuild.charAt(2);
        System.out.println("ch1(2):"+ch1);
        strBuild.setCharAt(2, 'a');
        strBuild.setCharAt(3, 't');
        System.out.println(strBuild);

        strBuild.append(" china");
        System.out.println(strBuild);

        strBuild.insert(13, " from");
        System.out.println(strBuild);

        strBuild.replace(19,24, "Russia");
        System.out.println(strBuild);

        strBuild.delete(19,25);
        strBuild.append("USA");
        System.out.println(strBuild);
    }
}