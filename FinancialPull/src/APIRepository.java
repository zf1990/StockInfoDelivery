import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
//import kong.unirest.HttpResponse;
//import kong.unirest.JsonNode;
//import kong.unirest.Unirest;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;



public class APIRepository {
	
	//private variable
	
	private String URL = "https://financialmodelingprep.com/api/v3/stock/real-time-price/";
	private String[] Symbols;
	private HashSet<String> Data_Attributes;
    private HttpClient httpClient = HttpClient.newHttpClient();
//    		= 
//    		HttpClient.newBuilder()
//            .build();

	public APIRepository() {
	}
    
	public APIRepository(String[] symbols, HashSet<String> Data_Attributes) {
		this.Symbols = symbols;
		this.Data_Attributes = Data_Attributes;
	}
	
	public APIRepository(String[] symbols) {
		this.Symbols = symbols;
	}
	
	//Method for getting real time stock price for specific Company
	public String getRealTimePrice(String company_name)
	{
		//Set the URL Endpoint for Real time stock price
		String endPoint = "https://financialmodelingprep.com/api/v3/stock/real-time-price/" + company_name;
		
		return getResponse(endPoint);
	}
	
	//Method for getting historical stock price for 1,5,15,30 minutes
	public String getHistoricalPrice(String company_name, int duration)
	{
		//Set the URL Endpoint for Real time stock price
		String endPoint = "https://financialmodelingprep.com/api/v3/historical-chart/" + duration +"min/" + company_name;
		
		return getResponse(endPoint);
	}
	
	//Generic Method for making the API call and return response
	public String getResponse(String apiEndPoint) 
	{
		String response = "";
		
		  try {

			URL url = new URL(apiEndPoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			//System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
				response = response + output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		  
		  return response;
	}
	
	public String urlCombination() {
		String joinedSymbols = String.join(",", Symbols);
		String Combined_URL = "" + URL + "/" + joinedSymbols;
		return Combined_URL;
	}
	
	public void sendGetRequest() {

		String apiURL = urlCombination();
		HttpRequest request = HttpRequest.newBuilder().
				GET().
				uri(URI.create(apiURL)).
				build();
			
		httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body) //Double colon is a lambda expression
			.thenAccept(System.out::println)
			.join(); //Must have it to print results to window.
							
	}
	
	
	
	
	
	//Generic Method for making the API call and return response
		/*public String getResponse(String apiEndPoint)
		{
		      // Headers for a request
		      String x_rapidapi_host = "movie-database-imdb-alternative.p.rapidapi.com";
		      String x_rapidapi_key = <YOUR_RAPIDAPI_KEY>;//Type here your key
		       Params
		      String s = "Pulp";
		      
		  // Format query for preventing encoding problems
		      String query = String.format("s=%s",
		       URLEncoder.encode(s, charset));
			
			 Host, charset and headers vars should be the same
		      String i = "tt0110912";
		  // Format query for preventing encoding problems
		      query = String.format("i=%s",
		       URLEncoder.encode(i, charset));      
		       //Json response
		      HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
		      HttpResponse <String> response = Unirest.get(apiEndPoint).asString();
		      .header("x-rapidapi-host", x_rapidapi_host);
		      .header("x-rapidapi-key", x_rapidapi_key);
		      
		  //Prettifying
		      Gson gson = new GsonBuilder().setPrettyPrinting().create();
		      JsonParser jp = new JsonParser();
		      JsonElement je = jp.parse(response.getBody().toString());
		      String prettyJsonString = gson.toJson(je);
		      System.out.println(prettyJsonString);
		      
		      return prettyJsonString;
		}*/
}
