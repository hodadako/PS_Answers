import java.util.*;

class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = Map.ofEntries(
            Map.entry(3000, "MMM"),
            Map.entry(2000, "MM"),
            Map.entry(1000, "M"),
            Map.entry(900, "CM"),
            Map.entry(800, "DCCC"),
            Map.entry(700, "DCC"),
            Map.entry(600, "DC"),
            Map.entry(500, "D"),
            Map.entry(400, "CD"),
            Map.entry(300, "CCC"),
            Map.entry(200, "CC"),
            Map.entry(100, "C"),
            Map.entry(90, "XC"),
            Map.entry(80, "LXXX"),
            Map.entry(70, "LXX"),
            Map.entry(60, "LX"),
            Map.entry(50, "L"),
            Map.entry(40, "XL"),
            Map.entry(30, "XXX"),
            Map.entry(20, "XX"),
            Map.entry(10, "X"),
            Map.entry(9, "IX"),
            Map.entry(8, "VIII"),
            Map.entry(7, "VII"),
            Map.entry(6, "VI"),
            Map.entry(5, "V"),
            Map.entry(4, "IV"),
            Map.entry(3, "III"),
            Map.entry(2, "II"),
            Map.entry(1, "I")
        );
        StringBuilder sb = new StringBuilder();
        int a = num;
        int d = 1000;
        while (a != 0) {
            if (d > a) {
                d /= 10;
                continue;
            } 
            int pop = d == 0 ? a : a - a % d ; 
            a -= pop;
            sb.append(map.get(pop));
            d /= 10;
        }
        return sb.toString();
    }
}