package Utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestNGDataProvider extends GenericUtils {
    SQLs sqLs;
    public TestNGDataProvider() {
        sqLs = new SQLs();
    }


    @org.testng.annotations.DataProvider (name="SearchProvider")
    public Object[][] getDataFromDataprovider (Method methodName) throws Exception {

        if (methodName.getName().equalsIgnoreCase("LogInToThePSSAdmin")) {

            return new Object[][] {
                    {sqLs.getuserName(),FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminLogin", "B3")},

            };

        } else if (methodName.getName().equalsIgnoreCase("SearchForRoles")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A2")}

            };

        } else if (methodName.getName().equalsIgnoreCase("SearchForAirports")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A3")}

            };

        } else if (methodName.getName().equalsIgnoreCase("searchForCity")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A4")}

            };

        } else if (methodName.getName().equalsIgnoreCase("searchForCountry")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A5")}

            };

        } else if (methodName.getName().equalsIgnoreCase("searchForSalesTerritory")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A6")}

            };

        } else if (methodName.getName().equalsIgnoreCase("searchForStation")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A6")}

            };

        } else if (methodName.getName().equalsIgnoreCase("searchForNationality")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A4")}

            };

        }else {
            throw new Exception("Incorrect test case name identified");
        }



    }





}
