package Utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestNGDataProvider extends GenericUtils {
    String FilePath = "/home/user/Desktop/Udemy/Test/Test Data/PSStestdata.xls";
    FileInputStream fs = new FileInputStream(FilePath);
    Workbook wb = Workbook.getWorkbook(fs);
    Sheet PSSAdminLogginSh = wb.getSheet("PssAdminLoggin");
    Sheet PSSAdminHomaPageSh = wb.getSheet("PssAdminHomePage");

    SQLs sqLs;
    public TestNGDataProvider() throws IOException, BiffException {

        sqLs = new SQLs();
    }


    @org.testng.annotations.DataProvider (name="SearchProvider")
    public Object[][] getDataFromDataprovider (Method methodName) throws Exception {

        if (methodName.getName().equalsIgnoreCase("LogInToThePSSAdmin")) {

            return new Object[][] {
                    {sqLs.getuserName(),PSSAdminLogginSh.getCell("B3").getContents()},

            };

        } else if (methodName.getName().equalsIgnoreCase("SearchForRoles")) {
            return new Object[][] {
                    {PSSAdminHomaPageSh.getCell("A2").getContents()}

            };

        } else if (methodName.getName().equalsIgnoreCase("SearchForAirports")) {
            return new Object[][] {
                    {PSSAdminHomaPageSh.getCell("A3").getContents()}

            };

        } else if (methodName.getName().equalsIgnoreCase("searchForCity")) {
            return new Object[][] {
                    {PSSAdminHomaPageSh.getCell("A4").getContents()}

            };

        } else if (methodName.getName().equalsIgnoreCase("searchForCountry")) {
            return new Object[][] {
                    {PSSAdminHomaPageSh.getCell("A5").getContents()}

            };

        } else if (methodName.getName().equalsIgnoreCase("searchForSalesTerritory")) {
            return new Object[][] {
                    {PSSAdminHomaPageSh.getCell("A6").getContents()}

            };

        } else if (methodName.getName().equalsIgnoreCase("searchForStation")) {
            return new Object[][] {
                    {PSSAdminHomaPageSh.getCell("A6").getContents()}

            };

        } else if (methodName.getName().equalsIgnoreCase("searchForNationality")) {
            return new Object[][] {
                    {PSSAdminHomaPageSh.getCell("A4").getContents()}

            };

        }else {
            throw new Exception("Incorrect Method name identified");
        }



    }





}
