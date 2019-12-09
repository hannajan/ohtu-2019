
package statistics;

import statistics.matcher.*;

class QueryBuilder {
    Matcher m;
    
    public QueryBuilder() {
       this.m = new All();
    }
    

    
    public Matcher build() {
        return this.m;
    }

    public QueryBuilder playsIn(String team) {
        this.m = new PlaysIn(team);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.m = new HasAtLeast(value, category);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.m = new HasFewerThan(value, category);
        return this;
    }
}
