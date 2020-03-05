import java.util.ArrayList;

public class League {
	
	String name;
	
	private int point;
	private int score;
	private int win;
	private int lost;
	private String percentage;
	private int ptsP;
	private int ptsN;
	private String average;
	
	
	private static ArrayList<League> teamList = new ArrayList<League>();
	public static ArrayList<League> getTeamList() {
		return teamList;
	}
	public static void setTeamList(ArrayList<League> teamList) {
		League.teamList = teamList;
	}
	
	public League(String name) {
		this.name=name;
		teamList.add(this);
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point += point;
	}
	
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win += win;
	}
	
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost += lost;
	}
	
	public String getPercentage() {
		
		return percentage;
	}
	public void setPercentage(String percentage) {
		
		this.percentage = percentage;
	}
	
	public int getPtsP() {
		return ptsP;
	}
	public void setPtsP(int ptsP) {
		this.ptsP += ptsP;
	}
	
	public int getPtsN() {
		return ptsN;
	}
	public void setPtsN(int ptsN) {
		this.ptsN += ptsN;
	}
	
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	
	
	public int scoreReturn() {
		int score=0;
		return score;
	}
	
	
	
	
}   

