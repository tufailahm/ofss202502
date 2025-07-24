package com.training.hr;

import java.text.MessageFormat;
import java.time.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class DemoString {
    public static void main(String[] args) {
        StringBuilder data = new StringBuilder("Hello");
        data.append(98);
        System.out.println(data);
        StringBuffer data2 = new StringBuffer("OFSS");
        data2.reverse();
        System.out.println(data2);

        String basicText = "Tea\tprice 1.99 quantity 2\n\"English Breakfast\"\n";

        String textBlock = """
              Tea	   price 1.99 quantity 2
              "English Breakfast"
              """;

// All String operations apply as usual:
        int p1 = basicText.indexOf("price");
        int p2 = textBlock.indexOf("price");

        System.out.println(p1);
        System.out.println(p2);

        int searchEnglish = textBlock.indexOf("E");
        String str1 = textBlock.substring(searchEnglish,(searchEnglish+7));
        System.out.println(str1);









        String marks="98";
        int i = Integer.parseInt(marks);
        System.out.println(i+5);

        int d1=10;
        Integer d2 = d1;        //autoboxing

        Integer d3=100;
        int d4 = d3;        //auto unboxing

        LocalDateTime current = LocalDateTime.now();
        LocalDateTime different =  current.withMinute(14).withDayOfMonth(3).plusHours(12);
        int year = current.getYear();
        boolean before = current.isBefore(different);

        System.out.println(current);    //10:26
        System.out.println(different);  //3rd July14 , 12
        System.out.println(before);



        LocalDate today = LocalDate.now();
        LocalDate foolsDay = LocalDate.of(2019, Month.APRIL, 1);
        Instant timeStamp = Instant.now();
        int nanoSecondsFromLastSecond = timeStamp.getNano();
        Period howLong = Period.between(foolsDay, today);
        Duration twoHours = Duration.ofHours(2);
        long seconds = twoHours.minusMinutes(15).getSeconds();
        int days = howLong.getDays();


        ZoneId london = ZoneId.of("Europe/London");
        ZoneId la  = ZoneId.of("America/Los_Angeles");
        ZoneId china = ZoneId.of("Asia/Shanghai");

        LocalDateTime someTime = LocalDateTime.of(2019,Month.APRIL,1,07,14);
        ZonedDateTime londonTime = ZonedDateTime.of(someTime, london);
        ZonedDateTime laTime = londonTime.withZoneSameInstant(la);
        ZonedDateTime chnTime = londonTime.withZoneSameInstant(china);


        System.out.println(someTime);
        System.out.println(londonTime);
        System.out.println(laTime);
        System.out.println(chnTime);

        Locale locale = Locale.of("fr","FR");

        String name="Mouse";
        int price = 100;
        int quantity= 200;
        String bestBefore = "02/2025";
        ResourceBundle bundle = ResourceBundle.getBundle("messages",locale);
        String pattern = bundle.getString("product");
        String result = MessageFormat.format(pattern,
                name,price,quantity,bestBefore);

        String greeting= bundle.getString("greeting");
        System.out.println("Welcome in OFSS - "+greeting);
        System.out.println("Result- "+result);

    }
}
