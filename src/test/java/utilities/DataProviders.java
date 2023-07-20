package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="TestData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		int total_rows=xlutil.getRowCount("Sheet1");
		int total_columns=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[total_rows][total_columns];
		
		for(int i=1;i<=total_rows;i++)
		{
			for(int j=0;j<total_columns;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
			
		return logindata;
	}
	
	
}
