import java.util.ArrayList;
import java.util.Random;

public class Euroleague extends League {
	
	private static ArrayList<League> euroTeamList = new ArrayList<League>();
	
	public static ArrayList<League> getTeamList() {
		return euroTeamList;
	}
	public static void setTeamList(ArrayList<League> euroTeamList) {
		Euroleague.euroTeamList = euroTeamList;
	}
	
	public Euroleague(String name) {
		super(name);
		euroTeamList.add(this);
	}
	
	@Override
	public int scoreReturn() {
	
		int score = 0;
		
        Random random = new Random(); 
        
       for(int i=1; i<=4; i++)
       {
    	   int quarter = 0;
    	   
    	   for(int j=0; j<15; j++) 
    	   {
    		   	int number = random.nextInt(101); 
        	
    	   		int basket = 0;
    	   		if(number < 35) {
    	   			basket = 0;
    	   		} else if(number < 45){
    	   			basket = 1;
    	   		} else if(number < 80) {
    	   			basket = 2;
    	   		} else if(number < 100) {
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
	
	static Euroleague cska = new Euroleague    ("Cska Moscow         ");
	static Euroleague efes = new Euroleague    ("Anadolu Efes        ");
	static Euroleague fb = new Euroleague      ("Fenerbahçe Beko     ");
	static Euroleague madrid = new Euroleague  ("Real Madrid         ");
	static Euroleague milano = new Euroleague  ("Armani Milano       ");
	static Euroleague barca = new Euroleague   ("Barcelona           ");
	static Euroleague maccabi = new Euroleague ("Maccabi FOX         ");
	static Euroleague khimki = new Euroleague  ("Khimki Moscow       ");
	static Euroleague zalgiris = new Euroleague("Zalgiris Kaunas     ");
	static Euroleague pana = new Euroleague    ("Panathinaikos       ");
	static Euroleague munich = new Euroleague  ("Bayern Munich       ");
	static Euroleague asvel = new Euroleague   ("ASVEL               ");
	static Euroleague baskonia = new Euroleague("Baskonia            ");
	static Euroleague crvena = new Euroleague  ("Crvena Zvezda       ");
	/*static Euroleague oly = new Euroleague     ("Olympiacos          ");
	static Euroleague zenit = new Euroleague   ("Zenit               ");
	static Euroleague val = new Euroleague     ("Valencia Basket     ");
	static Euroleague berlin = new Euroleague  ("ALBA Berlin         ");
*/
	
}
