
package statistics;

import statistics.matcher.*;

class QueryBuilder {
    Matcher m;
    
    public QueryBuilder() {
       this.m = new All();
    }
    

    
    public Matcher build() {
        Matcher apu = this.m;
        this.m = new All();
        return apu;
        
    }

    public QueryBuilder playsIn(String team) {
        this.m = new And(this.m, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.m = new And(this.m, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.m = new And(this.m, new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.m = new Or(m1, m2);
        return this;
    }
}
