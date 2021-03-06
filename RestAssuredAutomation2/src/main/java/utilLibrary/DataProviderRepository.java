package utilLibrary;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import baseSetUp.BaseSetUp_API;

public class DataProviderRepository extends BaseSetUp_API{
	public DataProviderRepository() throws IOException {
		super();		
	}

	static ExcelReader allURIfileName = null;
    static String SheetName = null;
    static String allCitiesFilePath=System.getProperty("user.dir" + "\\Test Excel Files\\CitiesData.xlsx");
    static String allURIfilepath=System.getProperty("user.dir" + "\\Test Excel Files\\URI_Response Validation.xlsx");
    ExcelReader excel1=new ExcelReader(allURIfilepath);
    ExcelReader excel2=new ExcelReader(allCitiesFilePath);
    
    
    
    @DataProvider(name="allURIsData")
    public static Object[][] getallURIs(){
        System.out.println("Inside data provider");
		String[][] uRIs = getExcelData1("All_URIs.xlsx", "FullURI");
    	return uRIs;
    }
    
    
    @DataProvider(name="allCitiesData")
    public static Object[][] getCities_Positive(){
        System.out.println("Inside Cities data provider for positive test cases");
		String[][] uRIs = getExcelData1("CitiesData.xlsx", "PositiveTestCasesData");
    	return uRIs;
    }
    
    public Object [][] getExcelData(String fileName, String sheetName) {
        int rows=excel1.getRowCount(sheetName);
        int cols=excel1.getColumnCount(sheetName);
        Object data [][]=new Object[rows-1][cols];
        for (int rowNum=1;rowNum<rows;rowNum++)
        {

            for (int colNum=0;colNum<cols;colNum++)
            {
                data [rowNum-1][colNum]=excel1.getCellData(sheetName, colNum, rowNum);
            }
        }
        return data;
    }
    
    /*public static String [][] getExcelData1(String ExcelName,String SheetName)
	 {
	    	String path= System.getProperty("user.dir")+"\\Test Excel Files\\" + ExcelName;
	    	excelReader=new ExcelReader(path);
	    	String[][] excelData = excelReader.getDatafromExcel(SheetName, ExcelName);
	    	return excelData;
	 }*/
    

}
