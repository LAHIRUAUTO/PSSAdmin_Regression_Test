package Utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.Properties;

public class XlsFileReader {


    public String getCellData (String  sheetName, String cellID) throws IOException, BiffException {
        String FilePath = System.getProperty("user.dir") + "/Test Data/PSStestdata.xls";
        FileInputStream fs = new FileInputStream(FilePath);
        Workbook wb = Workbook.getWorkbook(fs);
        Sheet dataSheet = wb.getSheet(sheetName);
        return dataSheet.getCell(cellID).getContents();
    }
}
