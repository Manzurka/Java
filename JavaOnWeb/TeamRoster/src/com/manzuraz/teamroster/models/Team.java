package com.manzuraz.teamroster.models;

import java.util.ArrayList;

public class Team {
	private String team_name;
	private static int id = -1;
	public ArrayList<Player> players = new ArrayList<Player>();
	public static ArrayList<Team> teams = new ArrayList<Team>();
	
	public Team(String name) {
		this.team_name = name;
		id++;
		teams.add(this);
	   
	}
	
	public static void addPlayer(Team t, Player p) {
		t.players.add(p);
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Team.id = id;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public static ArrayList<Team> getTeams() {
		return teams;
	}
	
	public static Team findTeams(int id) {
		return teams.get(id);
	}
	public static void removePlayer(Team t, int id) {
		t.players.remove(id);
	}

}
