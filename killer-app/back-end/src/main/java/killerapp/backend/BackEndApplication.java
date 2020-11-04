package killerapp.backend;

import com.google.gson.JsonObject;
import killerapp.backend.service.RiotAPI;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


@SpringBootApplication
public class BackEndApplication {

	private static HttpsURLConnection connection;
	private static String apikey = "?api_key=RGAPI-d832e6ee-5e35-4c30-9d41-3d3c62e09e50";
	private static String summonerID= "Djm4FTdfUlNIkQlDl6T3Ja9bb7X5zMOQ1n-ZS-zqMKVEF38";


	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);


		int yikes = 240+220;
		double poep = 240/ ((double)240+220)*100;
		int kan = (int) poep;
		//double test = Math.round(    240/poep*10000.0)/   100.0;
		System.out.println(String.valueOf(kan));
		RiotAPI api = new RiotAPI();
		String summonerID = api.getSummonerIDbyName("HenkHenkerson");
		api.getStatisticsSummonerID(summonerID);


		/*BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		try{
			URL url = new URL("https://euw1.api.riotgames.com//lol/league/v4/entries/by-summoner/"+summonerID+apikey);
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
			System.out.println("JAJAJAJAJAJAJAJAJAJAJAJAJA");
			System.out.println(responseContent.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		parse(responseContent.toString());
		*/
	}
	private static String parse(String responsebody){
		JSONArray statistieken = new JSONArray(responsebody);
		for(int i = 0;i<statistieken.length();i++){
			JSONObject statistiek = statistieken.getJSONObject(i);
			String tier = statistiek.getString("tier");
			System.out.println("jajajajajajajaj");
			System.out.println(tier);
		}
		return null;
	}


}
