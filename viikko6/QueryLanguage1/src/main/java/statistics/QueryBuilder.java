
package statistics;

import java.util.ArrayList;
import java.util.List;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
    
    private List<Matcher> vaatimukset = new ArrayList<Matcher>();
    
    public Matcher build() {
        Matcher[] matchers = {};
        matchers = vaatimukset.toArray(matchers);
        Matcher tulos = new And(matchers);
        this.vaatimukset.clear();
        return tulos;
    }
    
    public QueryBuilder HasFewerThan(int value, String category) {
       vaatimukset.add(new HasFewerThan(value, category));
       return this;
    }
    
    public QueryBuilder HasAtLeast(int value, String category) {
       vaatimukset.add(new HasAtLeast(value, category));
       return this;
    }
    
    public QueryBuilder Or(Matcher... matchers) {
       vaatimukset.add(new Or(matchers));
       return this;
    }
    
    public QueryBuilder Not(Matcher... matchers) {
       vaatimukset.add(new Not(matchers));
       return this;
    }
    
    public QueryBuilder PlaysIn(String team) {
       vaatimukset.add(new PlaysIn(team));
       return this;
    }
}
