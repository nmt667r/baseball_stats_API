package com.baseballstatsbatting.springbootbaseballsample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResultController {
	@GetMapping("/NPB")
	public List<Stats> GetStats(@RequestParam Map<String,String> requestParams) throws IOException{
		//URLパラメータ(league)のバリデーション処理と変数へのセット
		String league = validParamLeague(requestParams.get("league"));
		//URLパラメータ(year)のバリデーション処理と変数へのセット
		String year = validParamYear(requestParams.get("year"));
		//リーグと年情報を引き渡しNPB公式サイトをスクレイピング
		Elements scrapingData = Jsoup.connect("https://npb.jp/bis/"+year+"/stats/bat_"+league+".html").get().select("tr");
		//スクレイピングデータをリストに変換 (リーグ変数でセ・パ方式に変換)
		List<Stats> stats = setStats(scrapingData, league);
		return stats;
	}

	public final static List<Stats> setStats(Elements scrapingData, String league) throws IOException {
		//配列を用意
		List<Stats> stats = new ArrayList<Stats>();
		//スクレイピングデータの配列数文ループ
		for (int i = 2; i < scrapingData.size()-1; i++) {
			Stats stat = new Stats();
			if (i != scrapingData.size()) {
				//スクレイピングデータの""を除去
				String[] data = scrapingData.get(i).text().split(" ");
				//以降statマップにセット
				Double SluggingPercentage = Double.parseDouble(data[23]);
				Double OnBasePercentage = Double.parseDouble(data[24]);
				stat.setName(data[1]);
				stat.setLeague(getLeagueString(league));
				stat.setBattingAverage(Double.parseDouble(data[3]));
				stat.setGames(Integer.parseInt(data[4]));
				stat.setAtBats(Integer.parseInt(data[5]));
				stat.setPlateAppearance(Integer.parseInt(data[6]));
				stat.setRuns(Integer.parseInt(data[7]));
				stat.setHits(Integer.parseInt(data[8]));
				stat.setDoubles(Integer.parseInt(data[9]));
				stat.setTriples(Integer.parseInt(data[10]));
				stat.setHomeruns(Integer.parseInt(data[11]));
				stat.setTotalBases(Integer.parseInt(data[12]));
				stat.setRbi(Integer.parseInt(data[13]));
				stat.setStolenBases(Integer.parseInt(data[14]));
				stat.setStolenBaseDeath(Integer.parseInt(data[15]));
				stat.setSacrificeBunts(Integer.parseInt(data[16]));
				stat.setSacrificeFlies(Integer.parseInt(data[17]));
				stat.setBaseOnBalls(Integer.parseInt(data[18]));
				stat.setHitByPitches(Integer.parseInt(data[20]));
				stat.setStrikeOuts(Integer.parseInt(data[21]));
				stat.setDoublePlay(Integer.parseInt(data[22]));
				stat.setSluggingPercentage(SluggingPercentage);
				stat.setOnBasePercentage(OnBasePercentage);
				stat.setOps(SluggingPercentage + OnBasePercentage);
				//選手１人分の成績を配列に追加
				stats.add(stat);
			}
		}
		//選手情報の配列をリターン
		return stats;
	}

	public final static String validParamLeague(String league) {
		//URLパラメータとしてリーグ情報が引き渡さなかったらc(セントラルリーグの意)にする
		if(league == null) {
			league = "c";
		//URLパラメータとしてリーグ情報が引き渡された文字列がcまたはp以外は強制的にcにする
		} else if(!league.equals("c") && !league.equals("p")){
			league = "c";
		}
		return league;
	}

	public final static String validParamYear(String year) {
		//URLパラメータとして年情報が引き渡さなかったら2022年にする
		if(year == null) {
			year = "2022";
		//URLパラメータとして年情報が引き渡された文字列が数字以外は強制的に2022にする
		} else if (!year.matches("[0-9]+")) {
			year = "2022";
		//URLパラメータとして年情報が引き渡された文字列が2022より大きい数字であれば2022年にする
		} else if(Integer.parseInt(year) > 2022){
			year = "2022";
		//URLパラメータとして年情報が引き渡された文字列が2005より小さい数字であれば2022年にする
		} else if (Integer.parseInt(year) < 2005) {
			year = "2022";
		}
		return year;
	}

	public final static String getLeagueString(String league) throws IOException {
		//URLパラメータとしてリーグ情報がcで引き渡された場合「セ」として返す
		if(league.equals("c")) {
			league = "セ";
		} else {
		//URLパラメータとしてリーグ情報がc以外で引き渡された場合「パ」として返す
			league = "パ";
		}
		return league;
	}
}
