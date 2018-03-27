import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

public class Test {
	ArrayList<String[]> account;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("=== Set Up ===");
		System.out.println("Initialization of account array");
		account = new ArrayList<String[]>();
		
		String csvFile = "data/Account.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			int counter = 0;
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (counter++ == 0) continue;
				else account.add(line.split(cvsSplitBy));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("=== Tear Down ===");
	}

	@org.junit.Test
	public void test() {
		System.out.println("Array account length: " + account.size());
	}

}
