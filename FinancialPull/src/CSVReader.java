import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	String File_Name;
	
	
	
	public CSVReader(String File_Name) {
		this.File_Name = File_Name;
		
	}
	
	public ArrayList<String> ReadFile() {
		ArrayList<String> fileRows = new ArrayList<String>();
		
		BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader(File_Name));
			
			String row;
			try {				
				while((row=csvReader.readLine()) != null) { //FirstLine is heading.
					fileRows.add(row);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return fileRows;
	}
	
	
	
}
