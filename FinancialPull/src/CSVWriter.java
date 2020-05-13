import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVWriter {
	String File_Name;
	
	public CSVWriter() {
	}
	
	public static void AddLines(String FileName, List<String> line) { //Append to the file.
		FileWriter fw;
		try {
			fw = new FileWriter(FileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			for(String i: line) {
				pw.println(i);
			}			
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Please close the file before continuing.");
		}

		
		//The Project was not built due to "release 6 is not found in the system
	}

	public static void writeFile(String FileName, List<String> lines) { //Write to a new file.
		FileWriter fw;
		try {
			fw = new FileWriter(FileName);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			for(String i: lines) {
				pw.println(i);
			}			
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Please close the file before continuing.");
		}
	}
	
}
