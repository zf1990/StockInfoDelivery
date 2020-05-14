import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
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

import org.json.JSONArray;
import org.json.JSONObject;


public class APIRepository {
	
	//private variable
	
	private static final String URL = "https://financialmodelingprep.com/api/v3/quote";
	private String[] Symbols;
	private List<StockAttributes> attrs;
    private HttpClient httpClient = HttpClient.newHttpClient();
    private String JsonResponse;
    
    private List<HashMap<String, String>> infoList  = new ArrayList<HashMap<String, String>>();
    private static final HashMap<StockAttributes,String> keyMatch = new HashMap<StockAttributes,String>() {{
    	put(StockAttributes.PRICE, "price");//double
    	put(StockAttributes.CHANGEPERCENTAGE, "changesPercentage"); //double
    	put(StockAttributes.CHANGE, "change"); //double
    	put(StockAttributes.DAYLOW, "dayLow"); //double
    	put(StockAttributes.DAYHIGH, "dayHigh"); //double
    	put(StockAttributes.YEARHIGH, "yearHigh"); //double
    	put(StockAttributes.YEARLOW, "yearLow"); //double
    	put(StockAttributes.MARKETCAP, "marketCap"); //double
    	put(StockAttributes.PRICEAVG50, "priceAvg50"); //double
    	put(StockAttributes.PRICEAVG200, "priceAvg200"); //double
    	put(StockAttributes.VOLUME, "volume"); //int
    	put(StockAttributes.AVGVOLUME, "avgVolume"); //int
    	put(StockAttributes.EXCHANGE, "exhange"); //String
    	put(StockAttributes.EPS, "eps");//double
    	put(StockAttributes.PERATIO, "pe"); //double
    	put(StockAttributes.SHARESOUTSTANDING, "sharesOutstanding"); //long
    	
    }};
    
    
	public APIRepository(String[] symbols, List<StockAttributes> Data_Attributes) {
		this.Symbols = symbols;
		this.attrs = Data_Attributes;
	}
	
	public APIRepository(String[] symbols) {
		this.Symbols = symbols;
	}
	
	public String urlCombination() {
		String joinedSymbols = String.join(",", Symbols);
		String Combined_URL = "" + URL + "/" + joinedSymbols;
		return Combined_URL;
	}
	
	public void parseResponse() {
		JSONArray stocks_json = new JSONArray(JsonResponse);

		for (int i=0; i<stocks_json.length(); i++) {
			JSONObject oneStock = stocks_json.getJSONObject(i);
			
			HashMap<String, String> oneStockInfo = new HashMap<String,String>();
			oneStockInfo.put("Symbol", oneStock.getString("symbol"));
			oneStockInfo.put("Name", oneStock.getString("name"));
			
			for(StockAttributes j : attrs) {
				String keyword = keyMatch.get(j);
				String info = oneStock.get(keyword).toString(); //Turn everything to string and save it to a dictionary.
				
				oneStockInfo.put(keyword, info);				
			}
			infoList.add(oneStockInfo);
		}
	}
	
	public void sendAndParseResponse() {
		sendGetRequest();
		parseResponse();
		//System.out.println(infoArray); <--Made sure responses were correct.
	}
	
	
	public String sendGetRequest(){

		String apiURL = urlCombination();
		HttpRequest request = HttpRequest.newBuilder().
				GET().
				uri(URI.create(apiURL)).
				build();
			
		
		CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

		try {
			JsonResponse = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return JsonResponse;
							
	}
	
    public List<HashMap<String, String>> getInfoArray() { //This is what is being returned.
		return infoList;
	}
	
	
}
