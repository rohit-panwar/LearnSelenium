package dataDriven;

import java.util.ArrayList;

public class DataProvideExcelReader {

	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		reader = new Xls_Reader(
				System.getProperty("user.dir") + "\\src\\test\\java\\dataDriven\\DataProviderExcelData.xlsx");

		for (int i = 2; i <= reader.getRowCount("RegPage"); i++) {

			String getFirstName = reader.getCellData("RegPage", "name", i);
			String email = reader.getCellData("RegPage", "email", i);
			String getPhone = reader.getCellData("RegPage", "phone", i);
			String getComments = reader.getCellData("RegPage", "comments", i);

			Object ab[] = { getFirstName, email, getPhone, getComments };
			myData.add(ab);
		}
		return myData;
	}
}
