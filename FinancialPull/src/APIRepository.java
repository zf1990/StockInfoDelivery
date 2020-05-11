import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
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
	
	private String URL = "https://financialmodelingprep.com/api/v3/quote/";
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
	/*public String getRealTimePrice(String company_name)
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
	}*/
	
	public String urlCombination() {
		String joinedSymbols = String.join(",", Symbols);
		String Combined_URL = "" + URL + "/" + joinedSymbols;
		return Combined_URL;
	}
	
	public String sendGetRequest() throws Exception {

		String apiURL = urlCombination();
		HttpRequest request = HttpRequest.newBuilder().
				GET().
				uri(URI.create(apiURL)).
				build();
			
		/*return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body); //Double colon is a lambda expression*/
			//.thenAccept(System.out::println);
			//.join(); //Must have it to print results to window.
		
		CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        return response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
							
	}
}
