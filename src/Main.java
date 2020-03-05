import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Malisar
 *
 */
public class Main {

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		menu();
		
	}
	
	public static void menu() {
		
    	Scanner choose = new Scanner(System.in);
    	
		boolean flag = true;
	    while(flag) {
	    	
		    System.out.println("1)Exhibition Game    : 1\n" +
		    				   "2)NBA Regular Season : 2\n" +
		    				   "3)Euroleague Season  : 3\n" +
		    				   "Exit The Game        : -1");
		    
		    String league = choose.nextLine();
		    
		    long startTime = System.currentTimeMillis();
		    
	    	switch(league) {
	    	case "1":
	    		exhibitionMenu();
	    		break;
	    	case "2":
	    		seasonMenu("nba");
	    		break;
	    	case "3":
	    		seasonMenu("euro");
	    		break;
	    	case "-1":
	    		flag = false;
	    		System.out.println("Good Bye :'-(");
	    		break;
	    	default:
	    		System.out.println("Wrong Choose, Try Again :-)\n");
	    		break;
	    	}
	    	
	    	if(league.equals("2") || league.equals("3")) {
	    		
	    		long endTime = System.currentTimeMillis();
	    		long duration = (endTime - startTime);
	    		double time = duration / 1000.0;
	    		System.out.println("Total Time : " + time + " Second\n");
			    
	    		System.out.println("Please, press a key...");
			    choose.nextLine();
	    		
			    clearData(league);
			    
		    } else if(league.equals("1")) {
		    	
		    	System.out.println("Please, press a key...");
			    choose.nextLine();
		    }
	    }
	    choose.close();
	}
	
	public static void seasonMenu(String league) {
		
		leagueMenu(league);
		season(league);
		standings(league);
	}
	
	public static void leagueMenu(String league) {
		
		switch(league) {
			case "euro":
				System.out.println("TURKISH AIRLINES EUROLEAGUE\n");
				break;
			case "nba":
				System.out.println("NATIONAL BASKETBALL ASSOCIATION\n");
				break;
		}
		getTeams(league);
		System.out.println("\nMATCHES");
		System.out.println("-------");
	}
	
	
	public static void exhibitionMenu() {
		
		League homeTeam = exhibitionMatch("home");
		String homeName = homeTeam.name;
		int homeScore = homeTeam.getScore();
		System.out.println(homeName + "\n");
		
		League awayTeam = exhibitionMatch("away");
		String awayName = awayTeam.name;
		int awayScore = awayTeam.getScore();
		System.out.println(awayName + "\n");
		
		System.out.println("Exhibition Game");
		System.out.println("---------------");

		System.out.println(homeName + " " + homeScore + " - "
		+ awayScore + " " + awayName + "\n");
		
	}
	
	public static League exhibitionMatch(String side) {

		ArrayList<League> teams = Nba.getTeamList();
		String league = "nba";
		League myTeam = Nba.getTeamList().get(0);
		int teamNumber = 0;
		
		Scanner leagueChoose = new Scanner(System.in);
		Scanner teamChoose = new Scanner(System.in);

		if(side.equals("home")) {
			System.out.println("HOME");
			System.out.println("Please, choose your home team...\n");
		} else if(side.equals("away")) {
			System.out.println("AWAY");
			System.out.println("Please, choose your away team...\n");
		}
		
		System.out.println("NBA        : 1");
		System.out.println("Euroleague : 2");
		
		boolean flag = true;
		while(flag) {
			
				league = leagueChoose.nextLine();
				
				if(league.equals("1") || league.equals("2")) {
					
					switch(league) {
					case "1":
						getTeams("nba");
						break;
					case "2":
						getTeams("euro");
						teams = Euroleague.getTeamList();
						break;
					}	
					
					flag = false;
					
				} else {
					System.out.println("League choose must be 1 or 2!");
					System.out.println("Please, Try Again...");
				}
		}
		
		flag = true;
		while(flag) {
			
			String team = teamChoose.nextLine();
			
			ArrayList<String> numbers = new ArrayList<String>();
			
			teamNumber = teams.size();
			
			for(int i=1; i<=teamNumber; i++) {
				
				numbers.add(String.valueOf(i));
			}
			
			if(numbers.contains(team)) {
				
				myTeam = teams.get(Integer.parseInt(team)-1);
				generateScore(myTeam);
				
				flag = false;
				
			} else {
				System.out.println("Team choose must be between 1 - " + teamNumber + "!");
				System.out.println("Please, Try Again...");
			}
		}
		
		return myTeam;
	}
	
	public static void generateScore(String league) {
		
		ArrayList<League> teams = Nba.getTeamList();
		
		switch(league) {
		case "euro":
			teams = Euroleague.getTeamList();
			break;
		}
		
		for(League e : teams) {
			e.setScore(e.scoreReturn());
		}
	}
	
	public static void generateScore(League team) {
		
		team.setScore(team.scoreReturn());
	}
	
	public static void pointCalculate(League team1, League team2) {
		
		if(team1.getScore() > team2.getScore()) {
			team1.setPoint(2);
			team2.setPoint(1);
			
			team1.setWin(1);
			team2.setLost(1);
			
		} else {
			team2.setPoint(2);
			team1.setPoint(1);
			
			team2.setWin(1);
			team1.setLost(1);
		}
		
		team1.setPtsP(team1.getScore());
		team2.setPtsP(team2.getScore());
		
		team1.setPtsN(team2.getScore());
		team2.setPtsN(team1.getScore());
	}
	
	public static void standings(String league) {
		
		ArrayList<String> teamName = new ArrayList<>();
		ArrayList<Integer> teamPoint = new ArrayList<>();
		ArrayList<Integer> teamWin = new ArrayList<>();
		ArrayList<Integer> teamLost = new ArrayList<>();
		ArrayList<String> teamPercentage = new ArrayList<>();
		ArrayList<Integer> teamPtsP = new ArrayList<>();
		ArrayList<Integer> teamPtsN = new ArrayList<>();
		ArrayList<String> teamAverage = new ArrayList<>();
		
		System.out.println("\nSTANDINGS" + "\t\t " + " GP " + " P " + " W " + " L " + " PCT " + " PTS+ " + "PTS- " + "+/-");
		System.out.println("----------\t\t  ------------------------------");
		
		ArrayList<League> teams = Nba.getTeamList();
		switch(league) {
			case "euro":
				teams = Euroleague.getTeamList();
				break;
		}
		
		for(League e : teams) {
				
			setPercentage(e);
			setAverage(e);
				
			teamName.add(e.name);
			teamPoint.add(e.getPoint());
			teamWin.add(e.getWin());
			teamLost.add(e.getLost());
			teamPercentage.add(e.getPercentage());
			teamPtsP.add(e.getPtsP());
			teamPtsN.add(e.getPtsN());
			teamAverage.add(e.getAverage());
		}
		
		String weekScope = null, win = null, lost = null, scope = " ";
		int size = teamName.size();
		
		for(int week=1; week<=size; week++) {
			
			int index = teamPoint.indexOf(Collections.max(teamPoint));
			
			int gamePlayed = teamWin.get(index) + teamLost.get(index);
			
			if(week<10) {
				 weekScope = ") ";
			} else {
				 weekScope = ")";
			}
			
			if(teamLost.get(index) < 10) {
				lost = "  ";
			} else {
				lost = " ";
			}
			
			if(teamWin.get(index) < 10) {
				win = "  ";
			} else {
				win = " ";
			}
			
			System.out.println(week + weekScope + scope + teamName.get(index) + ":" + scope
			+ gamePlayed + scope + teamPoint.get(index) + scope + teamWin.get(index) + win 
			+ teamLost.get(index) + lost +  teamPercentage.get(index) + " " + 
			teamPtsP.get(index) + scope + teamPtsN.get(index) + " " + teamAverage.get(index));
			
			teamPoint.remove(index);
			teamName.remove(index);
			teamWin.remove(index);
			teamLost.remove(index);	
			teamPercentage.remove(index);
			teamPtsP.remove(index);
			teamPtsN.remove(index);
			teamAverage.remove(index);
			
			}
		System.out.println("\n");	
	}
	
	public static void season(String league) {
		
		ArrayList<String> teamName = new ArrayList<>();
		ArrayList<Integer> teamScore = new ArrayList<>();
		
		ArrayList<League> teams = Nba.getTeamList();
		
		switch(league) {
			case "euro":
				teams = Euroleague.getTeamList();
				break;
		}
		
		for(League e : teams) {
			teamName.add(e.name);
			teamScore.add(e.getScore());
		}
		fixture(league, teams);
	}
	
	private static void fixture(String league, ArrayList<League> team) {
		
		int size = team.size();
		
		String[][] array = new String[size][size];
		
		for(int m =0; m < size; m++) {
			for(int n=0; n < size; n++) {
				if(m == n) {
					continue;
				} else {
					generateScore(league);
					
					array[m][n] = team.get(m).name + " " + team.get(m).getScore() + 
					" - " + team.get(n).getScore() + " " + team.get(n).name;
					
					pointCalculate(team.get(m), team.get(n));
				}
				
			}
		}
		
		int[][]fixture = generateFixture(size);
		int week = 1;
		for(int m = 0; m < (size-1)*2; m++) {
			System.out.println("\nWEEK - " + week);
			System.out.println("----------");
			for(int n =0; n < size; n+=2) {
				System.out.println(array[fixture[m][n]][fixture[m][n+1]]);
			}
			week++;
		}
	}

	public static int[][] generateFixture(int teamNumber) {
		
		int week = (teamNumber - 1) * 2;
		
		int[][] fixture = new int[week][teamNumber];
		
		int[][] backup = new int[week/2][teamNumber];
		
		int limit = 0; 
		int teamLimit = teamNumber / 4;
		int count = 0;
		for(int m = 0; m < week/2; m++) {
			
			backup[m] = generateWeek(teamNumber);
			
			// 0123 => 2301, 1032 => 2301 same match control
			boolean order = false;
			int j=0, k=0;
			for(int i=0; i<m; i++) {
					
					if( ( (backup[i][j] == backup[m][k]) && (backup[i][j+1] == backup[m][k+1]) ) 
					 || ( (backup[i][j] == backup[m][k+1]) && (backup[i][j+1] == backup[m][k]) ) ) {
						
						order = true;
						break;
					} 
					
					j+=2;
					
					if(j>=teamNumber) {
						if(k<teamNumber-2) {
							
							j=0;
							k+=2;
						} else {
							
							i++;
							j=0;
							k=0;
						}
					}
					i--;
				}
			
			// Count for Stopped
			limit = (int) Math.pow(teamLimit, m);
			count++;		
			if(count > limit) {
							
				m=-1;
				count=0;
				continue;
			}
				
			if(order) {
				m--;
				continue;
			}
			
			for(int n = 0; n < teamNumber; n++) {
				
				fixture[m][n] = backup[m][n];
			}
		}
		
		// Week/2 => Week (Opposite Fixtures)
		for(int m = week/2; m < week; m++) {
			for(int n = 0; n < teamNumber; n+=2) {
				
				fixture[m][n] = fixture[m - week/2][n+1];
				fixture[m][n+1] = fixture[m - week/2][n];
			}
		}
		
		return fixture;
	}
	
	public static int[] generateWeek(int teamNumber) {
		
		int [] backup = new int[teamNumber];
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for (int i = 0; i < teamNumber; i++) {
			arrayList.add(i);
		}
		
		Collections.shuffle(arrayList);
		
		for(int i=0; i<teamNumber; i++) {
			backup[i] = arrayList.get(i);
		}
		
		return backup;
	}
	
	public static void getTeams(String league) {
		
		int count = 1;
		
		System.out.println("TEAMS");
		System.out.println("------");
		
		ArrayList<League> teams = Nba.getTeamList();
		
		switch(league) {
		case "euro":
			teams = Euroleague.getTeamList();
			break;
		}
		
		for(League e : teams) {
			System.out.println(count + ")" + e.name);
			count++;
		}
	}
	
	public static void setPercentage(League team) {
		
		final DecimalFormat df = new DecimalFormat("#.##");
		
		double total = team.getWin() + team.getLost();
		double win = team.getWin();
		
		double percentage = win / total;
		
		String per = df.format(percentage);
		
		if(per.length() == 3) {
			per += "0";
		}
		
		team.setPercentage(per);
	}
	
	public static void setAverage(League team) {
		
		int average = team.getPtsP() - team.getPtsN();
		
		String av = null;
		if(average>0) {
			av = "+" + average;
		} else {
			av = "" + average;
		}
		
		team.setAverage(av);
	}
	
	private static void clearData(String league) {
		
		ArrayList<League> teams = Nba.getTeamList();
		
		switch(league) {
			case "3":
				teams =  Euroleague.getTeamList();	
				break;
		}
		
		for(League e : teams) {
		
			int point = e.getPoint();
			int win   = e.getWin();
			int lost  = e.getLost();
			int ptsP  = e.getPtsP();
			int ptsN  = e.getPtsN();
		
			e.setPoint(-point);
			e.setWin(-win);
			e.setLost(-lost);
			e.setPtsP(-ptsP);
			e.setPtsN(-ptsN);
		
		}
	}
	
}


