public class VariableConversation {
    public static void main (String[] args) {

        // short [-128.. 127]
        //to byte
        short shortA = 128;
        byte shortB = (byte)shortA;
        //128 >> -128, изза нуля 
        System.out.println("SHORT shortA " + shortA + " conversation to BYTE = " + shortB);
        //shortA-1
        short shortAA = 127;
        byte shortBB = (byte)shortAA;
        System.out.println("SHORT shortAA " + shortAA + " conversation to BYTE = " + shortBB);

        // convers FLOAT [-3.4*10_38 .. 3.4*10_38, 4 bytes]
        // to DOUBLE [±4.9*10_-324 до ±1.7976931348623157*10_308, 8 bytes]
        float floatA = 3.14F;
        double floatB = floatA;
        System.out.println("FLOAT floatA = " + floatA + " conversation to DOUBLE = " + floatB);

        // conversion CHAR [1symbol, UTF-16, 0 .. 65535, 2 bytes]
        // to INT [-2147483648 .. 2147483647, 4 bytes]
        char charA = 'z';
        int charB = (int)charA;
        // ERROR incompatible types
        System.out.println("CHAR charA ="+ charA + "conversation to INT = " + charB);

        // conversion LONG [–9 223 372 036 854 775 808 .. 9 223 372 036 854 775 807, 8 bytes]
        // to INT [-2147483648 .. 2147483647, 4 bytes]
        long longA = 12345678;
        int longB = (int)longA;
        System.out.println("LONG longA " + longA + " conversion to INT = " + longB);

        // conversion INT [-2147483648 .. 2147483647, 4 bytes]
        // to DOUBLE [±4.9*10_-324 до ±1.7976931348623157*10_308, 8 bytes]
        int intA = 12345678;
        double intB = intA;
        System.out.println("INT intA " + intA + " conversion to DOUBLE = " + intB);

        // conversion DOUBLE [±4.9*10_-324 до ±1.7976931348623157*10_308, 8 bytes]
        // to INT (math.round) [-2147483648 .. 2147483647, 4 bytes]
        double doubleA = 1.65;
        int doubleB = (int) Math.round(doubleA);
        System.out.println("DOUBLE doubleB = " + doubleA +" conversation to INT with math.round = " + doubleB);
    }
}