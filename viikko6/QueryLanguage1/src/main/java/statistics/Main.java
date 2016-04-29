package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        Matcher m = query.HasAtLeast(10, "goals")
                         .HasAtLeast(10, "assists")
                         .PlaysIn("PHI").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        
        System.out.println(" ");
        Matcher m2 = query.Or(query.HasFewerThan(2, "assists").build(),
                query.HasAtLeast(50, "goals").build()
        ).build();

        for (Player player : stats.matches(m2)) {
            System.out.println(player);
        }

        System.out.println(" ");
        Matcher m3 = query.Not(query.HasFewerThan(10, "goals").build(),
                query.HasAtLeast(10, "assists").build(),
                query.PlaysIn("PHI").build(),
                query.PlaysIn("NSH").build(),
                query.PlaysIn("MIN").build(),
                query.PlaysIn("CHI").build()
        ).build();

        for (Player player : stats.matches(m3)) {
            System.out.println(player);
        }
    }
}
