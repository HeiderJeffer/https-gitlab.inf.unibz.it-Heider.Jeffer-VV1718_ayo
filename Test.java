import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;

public class Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void test1() {
		String csvFile = "data/Account.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			int counter = 0;
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if(counter++ == 0) continue;

				// use comma as separator
				String[] column = line.split(cvsSplitBy);

				if(column[0].startsWith("NDS_AF"))
					assertEquals(column[3],"false");
				else if(column[0].startsWith("NDS_BS_PP"))
					assertEquals(column[3],"true");
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

}
