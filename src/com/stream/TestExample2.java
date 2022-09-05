package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class TestExample2 {
	public static void main(String[] args) {
		
		int[] arr = {1,2,4,2,1,5,2};
		Arrays.sort(arr);
		int[] returnarr=new int[arr.length];
		int j=0;
		for(int i=0;i<arr.length-1;i++) {
			
			int curr=arr[i];
			if(curr!=arr[i+1]) {
				returnarr[j++]=curr;
			}
		}
		returnarr[j++]=arr[arr.length-1];
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(returnarr));
	}

	public static void main1(String[] args) {
		Player p1=new Player("Nirav",120,0,"M1","Royals"); 
		Player p2=new Player("Nirav",60,0,"M2","Royals"); 
		Player p3=new Player("Nirav",80,0,"M3","Royals"); 
		Player p4=new Player("Nirav",25,1,"M4","Royals"); 
		
		
		
		Player p5=new Player("Raj",80,1,"M1","Royals"); 
		Player p6=new Player("Raj",30,0,"M2","Royals"); 
		Player p7=new Player("Raj",23,2,"M3","Royals"); 
		Player p8=new Player("Raj",60,2,"M4","Royals"); 
		
		
		Player p9=new Player("Hardik",35,2,"M1","Lions");
		Player p10=new Player("Hardik",70,0,"M2","Lions");
		Player p11=new Player("Hardik",50,1,"M3","Lions");
		Player p12=new Player("Hardik",72,1,"M4","Lions");
		
		Player p13=new Player("Rajesh",48,1,"M1","Lions");
		Player p14=new Player("Rajesh",52,0,"M2","Lions");
		Player p15=new Player("Rajesh",30,0,"M3","Lions");
		Player p16=new Player("Rajesh",67,1,"M4","Lions");
		
		List<Player> playerlist1=new ArrayList<Player>();
		playerlist1.add(p1);
		playerlist1.add(p2);
		playerlist1.add(p3);
		playerlist1.add(p4);
		playerlist1.add(p5);
		playerlist1.add(p6);
		playerlist1.add(p7);
		playerlist1.add(p8);
		
		
		playerlist1.add(p9);
		playerlist1.add(p10);
		playerlist1.add(p11);
		playerlist1.add(p12);
		playerlist1.add(p13);
		playerlist1.add(p14);
		playerlist1.add(p15);
		playerlist1.add(p16);
		
		
		
		Map<String,List<Player>> playermap=playerlist1.parallelStream().collect(Collectors.groupingBy(Player::getMatchPlayed,Collectors.toList()));
		for(Map.Entry<String,List<Player>> map:playermap.entrySet()) {
			String match=map.getKey();
			Optional<Player> player=null;
			Optional<Player> player1=null;
			
			Long highestRun=map.getValue().stream().map(p->p.getRun()).max(Long::compare).get();
			player=map.getValue().stream().filter(p->p.getRun()==highestRun).findFirst();
			if(player.isPresent()) {
				System.out.println("*****Match***** "+match);
				System.out.println("::TopBatsman::");
				System.out.println("Team="+player.get().getTeamname()+" playername="+ player.get().getPname() +" HighestRun="+highestRun);
			}
			
			Long highestWicket=map.getValue().stream().map(p->p.getWicket()).max(Long::compare).get();
			player1=map.getValue().stream().filter(p->p.getWicket()==highestWicket).findFirst();
			if(player1.isPresent()) {
				System.out.println("");
				System.out.println("::Top Bowler ::");
				System.out.println("Team="+player1.get().getTeamname()+" playername="+ player1.get().getPname() +" HighestWicket="+highestWicket+"\n");
			}
		}
		
	}

}

class Player{
	private String pname;
	private long run;
	private long wicket;
	private String matchPlayed;
	String teamname;
	
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public String getMatchPlayed() {
		return matchPlayed;
	}
	public void setMatchPlayed(String matchPlayed) {
		this.matchPlayed = matchPlayed;
	}
	public Player(String pname,long run, long wicket, String matchPlayed, String teamname) {
		this.pname=pname;
		this.run=run;
		this.wicket=wicket;
		this.matchPlayed=matchPlayed;
		this.teamname=teamname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public long getRun() {
		return run;
	}
	public void setRun(long run) {
		this.run = run;
	}
	public long getWicket() {
		return wicket;
	}
	public void setWicket(long wicket) {
		this.wicket = wicket;
	}
	
}
/*class Team{
	
	private String teamname;
	private List<Player> playerlist;
	
	public Team(String teamname, List<Player> playerlist ) {
		
		this.teamname=teamname;
		this.playerlist=playerlist;
	}
	public String getTeamName() {
		return teamname;
	}
	public void setTeamName(String teamName) {
		this.teamname = teamName;
	}
	public List<Player> getPlayerlist() {
		return playerlist;
	}
	public void setPlayerlist(List<Player> playerlist) {
		this.playerlist = playerlist;
	}
	
	
}*/