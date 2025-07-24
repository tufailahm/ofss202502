package com.training.finance;

import java.util.*;
import java.util.function.Predicate;

public class PlayersDetails {

    public static void main(String[] args) {
        Map<String,Integer> players = new TreeMap<String,Integer>();

        players.put("Messi",998);
        players.put("Ronaldo",12);
        players.put("Ronaldo",87);

        System.out.println(players.get("Messi"));


        List<String> newNames = new ArrayList<String>();
        newNames.add("Neha");
        newNames.add("Karthick");
        newNames.add("Aaliya");
        newNames.add("Mohan");
        newNames.add("Mahima");
        newNames.add("Isha");
        Collections.sort(newNames);
        System.out.println(newNames);
        newNames.removeIf(new LongNames());
        System.out.println(newNames);

        //all the names starting with M using lambda
        //newNames.removeIf( (String s) -> !s.startsWith("M"));
        //newNames.removeIf( String::startsWith("M"));

        //1.
        /*
        Collections.sort(newNames, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
*/
        //using lambda expression
        Collections.sort(newNames, ((o1, o2) -> o2.compareTo(o1)));

        //3. method references
        Collections.sort(newNames, String::compareTo);

        System.out.println(newNames);

    }
}
class LongNames
        implements Predicate<String> {
    public boolean test(String data) {
        return data.length() == 4;
    }
}





