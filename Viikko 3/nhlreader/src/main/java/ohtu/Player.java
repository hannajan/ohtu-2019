
package ohtu;



public class Player implements Comparable<Player> {
    private String name;
    private int goals;
    private int assists;
    private int penalties;
    private String team;
    private String nationality;
    private String birthdate;

    public void setName(String name, String team, String nationality, String birthdate, String goals, String assists, String penalties) {
        this.name = name;
        this.team = team;
        this.nationality = nationality;
        this.birthdate = birthdate;
        this.goals = Integer.parseInt(goals);
        this.assists = Integer.parseInt(assists);
        this.penalties = Integer.parseInt(penalties);
        
    }

    public String getName() {
        return name;
    }
    
    public String getTeam() {
        return this.team;
    }

    public String getNationality() {
        return this.nationality;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s", name) + team + " "+ String.format("%2d", goals) + " + " + String.format("%2d", assists) + " = " + goals+assists;
    }

    @Override
    public int compareTo(Player o) {
        return (o.goals + o.assists) - (this.goals + this.assists);
    }

      
}
