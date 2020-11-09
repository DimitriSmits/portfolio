package killerapp.backend.service;

import killerapp.backend.enitities.Stats;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class RiotAPI {
    private static HttpsURLConnection connection;
    private String apikey = "?api_key=RGAPI-0e9dd59e-787e-47a5-a5f0-0ab5b1148b8f";
    public String getSummonerIDbyName(String summonername){
        String url = "https://euw1.api.riotgames.com//lol/summoner/v4/summoners/by-name/"+summonername+apikey;
        String summonerID = parseSummonerID(getResponseContent(url));
        return summonerID;
    }
    public Stats getStatisticsSummonerID(String summonerID){
        String url = "https://euw1.api.riotgames.com//lol/league/v4/entries/by-summoner/"+summonerID+apikey;
        return parseStatistics(getResponseContent(url));
    }
    private Stats parseStatistics(String responsebody){
        Stats stats= null;
        JSONArray statistics = new JSONArray(responsebody);
        for(int i = 0;i<statistics.length();i++){
            JSONObject statistic = statistics.getJSONObject(i);
            String queueType = statistic.getString("queueType");
            String tier = statistic.getString("tier");
            String rank = statistic.getString("rank");
            String summonerId = statistic.getString("summonerId");
            Integer leaguePointsString = statistic.getInt("leaguePoints");
            Integer winsString = statistic.getInt("wins");
            Integer lossesString = statistic.getInt("losses");

            /*int leaguePoints = Integer.parseInt(leaguePointsString);
            int wins = Integer.parseInt(winsString);
            int losses = Integer.parseInt(lossesString);*/

            stats = new Stats(queueType,tier,rank,summonerId,leaguePointsString,winsString,lossesString);
        }
        return stats;
    }
    private String parseSummonerID(String responsebody){
        String id ="";
        JSONArray ids = new JSONArray("["+responsebody+"]");
        for(int i = 0;i<ids.length();i++){
            JSONObject idObject = ids.getJSONObject(i);
            id = idObject.getString("id");
        }
        return id;
    }
    private String getResponseContent(String urlString){
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try{
            URL url = new URL(urlString);
            connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            if(status>299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
            }
            else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return responseContent.toString();
    }
}
