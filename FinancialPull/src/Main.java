//https://financialmodelingprep.com/developer/docs/#Stock-Price --API
//https://mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/ --Code
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;*/

public class Main {
	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {
		//Variable
		APIRepository api_repo = new APIRepository();
		//Calling the API Repo to get the Real Time Price for Apple
		String realtimeprice = api_repo.getRealTimePrice("AAPL");
		System.out.println("Real Time Price");
		System.out.println(realtimeprice);
		
		
		//Calling the API to get historical
		String historical = api_repo.getHistoricalPrice("AAPL",30);
		System.out.println("Historical");
		System.out.println(historical);
		
	}
}
