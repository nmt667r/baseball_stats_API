package com.baseballstatsbatting.springbootbaseballsample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ResultController {
	@GetMapping("/NPB")
	public List<Results> GetStats(@RequestParam Map<String,String> requestParams) throws IOException{
		String league = validParamLeague(requestParams.get("league"));
		String year = validParamYear(requestParams.get("year"));
		Document document = Jsoup.connect("https://npb.jp/bis/"+year+"/stats/bat_"+league+".html").get();
		//List<Results> results = setStats(statsArray, year, league);
		Elements statsArray = document.select("tr");
		List<Results> results = setStats(statsArray, league);
		return results;
	}

	public final static List<Results> setStats(Elements statsArray, String league) throws IOException {
		//プレイヤー配列を用意
		List<Results> results = new ArrayList<Results>();
		for (int i = 2; i < statsArray.size()-1; i++) {
			Results result = new Results();
			if (i != statsArray.size()) {
				String[] data = statsArray.get(i).text().split(" ");
				Double SluggingPercentage = Double.parseDouble(data[23]);
				Double OnBasePercentage = Double.parseDouble(data[24]);
				//result.setId(i);
				result.setName(data[1]);
				result.setLeague(getLeagueString(league));
				result.setBattingAverage(Double.parseDouble(data[3]));
				result.setGames(Integer.parseInt(data[4]));
				result.setAtBats(Integer.parseInt(data[5]));
				result.setPlateAppearance(Integer.parseInt(data[6]));
				result.setRuns(Integer.parseInt(data[7]));
				result.setHits(Integer.parseInt(data[8]));
				result.setDoubles(Integer.parseInt(data[9]));
				result.setTriples(Integer.parseInt(data[10]));
				result.setHomeruns(Integer.parseInt(data[11]));
				result.setTotalBases(Integer.parseInt(data[12]));
				result.setRbi(Integer.parseInt(data[13]));
				result.setStolenBases(Integer.parseInt(data[14]));
				result.setStolenBaseDeath(Integer.parseInt(data[15]));
				result.setSacrificeBunts(Integer.parseInt(data[16]));
				result.setSacrificeFlies(Integer.parseInt(data[17]));
				result.setBaseOnBalls(Integer.parseInt(data[18]));
				result.setHitByPitches(Integer.parseInt(data[20]));
				result.setStrikeOuts(Integer.parseInt(data[21]));
				result.setDoublePlay(Integer.parseInt(data[22]));
				result.setSluggingPercentage(SluggingPercentage);
				result.setOnBasePercentage(OnBasePercentage);
				result.setOps(SluggingPercentage + OnBasePercentage);
				results.add(result);
			}
		}
		return results;
	}

	public final static String validParamLeague(String league) {
		if(league == null) {
			league = "c";
		} else if(league != "c" && league != "p"){
			league = "c";
		}
		return league;
	}

	public final static String validParamYear(String year) {
		if(year == null) {
			year = "2022";
		} else if (!year.matches("[0-9]+")) {
			year = "2022";
		} else if(Integer.parseInt(year) > 2022){
			year = "2022";
		} else if (Integer.parseInt(year) < 2005) {
			year = "2022";
		}
		return year;
	}

	public final static String getLeagueString(String league) throws IOException {
		if(league.equals("c")) {
			league = "セ";
		} else {
			league = "パ";
		}
		return league;
	}
}
