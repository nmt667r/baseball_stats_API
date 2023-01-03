package com.baseballstatsbatting.springbootbaseballsample;

public class Results {
	private int id; //ID
	private String name; //選手名
	private String league; //リーグ名
	private int year; //記録年
	private Double battingAverage; //打率
	private int games; //試合数
	private int atBats; //打席
	private int plateAppearance; //打数
	private int hits; //安打
	private int doubles; //二塁打
	private int triples; //三塁打
	private int homeruns; //本塁打
	private int totalBases; //塁打
	private int rbi; //打点
	private int runs; //得点
	private int strikeOuts; //三振
	private int baseOnBalls; //四球
	private int hitByPitches; //死球
	private int sacrificeBunts; //犠打
	private int sacrificeFlies; //犠飛
	private int stolenBases; //盗塁
	private int stolenBaseDeath; //盗塁死
	private int doublePlay; //併殺打
	private Double onBasePercentage; //出塁率
	private Double sluggingPercentage; //長打率
	private Double ops; //ＯＰＳ
	private Double scoringRangePercentage; //得点圏
	private int errors; //失策
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Double getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(Double battingAverage) {
		this.battingAverage = battingAverage;
	}
	public int getGames() {
		return games;
	}
	public void setGames(int games) {
		this.games = games;
	}
	public int getAtBats() {
		return atBats;
	}
	public void setAtBats(int atBats) {
		this.atBats = atBats;
	}
	public int getPlateAppearance() {
		return plateAppearance;
	}
	public void setPlateAppearance(int plateAppearance) {
		this.plateAppearance = plateAppearance;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getDoubles() {
		return doubles;
	}
	public void setDoubles(int doubles) {
		this.doubles = doubles;
	}
	public int getTriples() {
		return triples;
	}
	public void setTriples(int triples) {
		this.triples = triples;
	}
	public int getHomeruns() {
		return homeruns;
	}
	public void setHomeruns(int homeruns) {
		this.homeruns = homeruns;
	}
	public int getTotalBases() {
		return totalBases;
	}
	public void setTotalBases(int totalBases) {
		this.totalBases = totalBases;
	}
	public int getRbi() {
		return rbi;
	}
	public void setRbi(int rbi) {
		this.rbi = rbi;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getStrikeOuts() {
		return strikeOuts;
	}
	public void setStrikeOuts(int strikeOuts) {
		this.strikeOuts = strikeOuts;
	}
	public int getBaseOnBalls() {
		return baseOnBalls;
	}
	public void setBaseOnBalls(int baseOnBalls) {
		this.baseOnBalls = baseOnBalls;
	}
	public int getHitByPitches() {
		return hitByPitches;
	}
	public void setHitByPitches(int hitByPitches) {
		this.hitByPitches = hitByPitches;
	}
	public int getSacrificeBunts() {
		return sacrificeBunts;
	}
	public void setSacrificeBunts(int sacrificeBunts) {
		this.sacrificeBunts = sacrificeBunts;
	}
	public int getSacrificeFlies() {
		return sacrificeFlies;
	}
	public void setSacrificeFlies(int sacrificeFlies) {
		this.sacrificeFlies = sacrificeFlies;
	}
	public int getStolenBases() {
		return stolenBases;
	}
	public void setStolenBases(int stolenBases) {
		this.stolenBases = stolenBases;
	}
	public int getStolenBaseDeath() {
		return stolenBaseDeath;
	}
	public void setStolenBaseDeath(int stolenBaseDeath) {
		this.stolenBaseDeath = stolenBaseDeath;
	}
	public int getDoublePlay() {
		return doublePlay;
	}
	public void setDoublePlay(int doublePlay) {
		this.doublePlay = doublePlay;
	}
	public Double getOnBasePercentage() {
		return onBasePercentage;
	}
	public void setOnBasePercentage(Double onBasePercentage) {
		this.onBasePercentage = onBasePercentage;
	}
	public Double getSluggingPercentage() {
		return sluggingPercentage;
	}
	public void setSluggingPercentage(Double sluggingPercentage) {
		this.sluggingPercentage = sluggingPercentage;
	}
	public Double getOps() {
		return ops;
	}
	public void setOps(Double ops) {
		this.ops = ops;
	}
	public Double getScoringRangePercentage() {
		return scoringRangePercentage;
	}
	public void setScoringRangePercentage(Double scoringRangePercentage) {
		this.scoringRangePercentage = scoringRangePercentage;
	}
	public int getErrors() {
		return errors;
	}
	public void setErrors(int errors) {
		this.errors = errors;
	}


}
