import java.util.*;

public class classCalendar {
    public static void main(String[] args){                
        if (args.length != 2) {
            System.out.println("no parameters passed");
            System.exit(1);
        }
        Calendar calendar = new GregorianCalendar(Integer.valueOf(args[1]), 
            Integer.valueOf(args[0]) - 1, 1);
        header(calendar); 
        for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) 
            System.out.print("    ");
        while (calendar.get(Calendar.DATE) <calendar.getActualMaximum(Calendar.DATE)) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == 7)
                System.out.printf("%4d\n", calendar.get(Calendar.DATE));
            else
                System.out.printf("%4d", calendar.get(Calendar.DATE));
            calendar.add(Calendar.DATE, 1);
        }
        
        System.out.printf("%4d\n", calendar.get(Calendar.DATE));
        end(calendar); 
    }

    public static String[] nameMonths(){
        String[] months = {"January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"};
        return months;
    }

    public static void header(Calendar calendar){
        String[] months = nameMonths();
        int length = 29 / 2 - (months[calendar.get(Calendar.MONTH)].length() / 2 + 3);
        System.out.println();
        for (int i = 0; i < length; i++)
            System.out.print(" ");
        System.out.println(months[calendar.get(Calendar.MONTH)] + ", " + 
            calendar.get(Calendar.YEAR));
        System.out.println("™™™™™™™™™™™™™™™™™™™™™™™");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    public static void end(Calendar calendar){
        String[] months = nameMonths();
        System.out.println(" \n™™™™™™™™™™™™™™™™™™™™™");
        System.out.println(months[calendar.get(Calendar.MONTH)] + ", " + calendar.get(Calendar.YEAR) +" contains "+ calendar.get(Calendar.DATE) +" days");
    }

}