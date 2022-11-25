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

        if (methodName.getName().equalsIgnoreCase("Log_In_To_The_PSS_Admin")) {

            return new Object[][] {
                    {sqLs.getuserName(),FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminLogin", "B3")},

            };

        } else if (methodName.getName().equalsIgnoreCase("Search_For_Roles")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A2")}

            };

        } else if (methodName.getName().equalsIgnoreCase("Search_For_Airports")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A3")}

            };

        } else if (methodName.getName().equalsIgnoreCase("Search_For_City")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A4")}

            };

        } else if (methodName.getName().equalsIgnoreCase("Search_For_Country")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A5")}

            };

        } else if (methodName.getName().equalsIgnoreCase("Search_For_Sales_Territory")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A6")}

            };

        } else if (methodName.getName().equalsIgnoreCase("Search_For_Station")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A6")}

            };

        } else if (methodName.getName().equalsIgnoreCase("Search_For_Nationality")) {
            return new Object[][] {
                    {FileReaderManager.getInstance().getXlsFileReader().getCellData("PssAdminHomePage","A4")}

            };

        }else {
            throw new Exception("Incorrect test case name identified");
        }



    }





}
