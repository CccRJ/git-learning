package string;

public class DefangIPaddr {
    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr(new String("255.100.50.0")));
    }
}
