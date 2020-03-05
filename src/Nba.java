import java.util.ArrayList;
import java.util.Random;

public class Nba extends League {
	
	private static ArrayList<League> nbaTeamList = new ArrayList<League>();
	
	public static ArrayList<League> getTeamList() {
		return nbaTeamList;
	}
	public static void setTeamList(ArrayList<League> nbaTeamList) {
		Nba.nbaTeamList = nbaTeamList;
	}
	
	public Nba(String name) {
		super(name);
		nbaTeamList.add(this);
	}
	
	@Override
	public int scoreReturn() {
	
		int score = 0;
		
        Random random = new Random(); 
        
       for(int i=1; i<=4; i++)
       {
    	   int quarter = 0;
    	   
    	   for(int j=0; j<21; j++) 
    	   {
    		   	int number = random.nextInt(101); 
        	
    	   		int basket = 0;
    	   		if(number < 30) {
    	   			basket = 0;
    	   		} else if(number < 45){
    	   			basket = 1;
    	   		} else if(number < 75) {
    	   			basket = 2;
    	   		} else if(number < 99) {
    	   			basket = 3;
    	   		} else {
    	   			basket = 4;
    	   		}
    	   		
    	   		quarter += basket;
        }
  
        score += quarter;
       }
		return score;
	}
	
	// Eastern Conference
	static Nba phi = new Nba     ("Philadelphia 76ers  ");
	static Nba mil = new Nba     ("Milwaukee Bucks     ");
	static Nba celtics = new Nba ("Boston Celtics      ");
	static Nba miami = new Nba   ("Miami Heat          ");
	static Nba raptors = new Nba ("Toronto Raptors     ");
	static Nba indiana = new Nba ("Indiana Pacers      ");
	static Nba detroit = new Nba ("Detroit Pistons     ");
	static Nba hawks = new Nba   ("Atlanta Hawks       ");

	//Western Conference
	static Nba lal = new Nba     ("Los Angeles Lakers  ");
	static Nba lac = new Nba     ("Los Angeles Clippers");
	static Nba dallas = new Nba  ("Dallas Mavericks    ");
	static Nba houston = new Nba ("Houston Rockets     ");
	static Nba denver = new Nba  ("Denver Nuggets      ");
	static Nba jazz = new Nba    ("Utah Jazz           ");
 	static Nba suns = new Nba    ("Phoenix Suns        ");
	static Nba spurs = new Nba   ("San Antonio Spurs   ");

}
