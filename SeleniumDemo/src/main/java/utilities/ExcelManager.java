package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelManager {


    static String filePath = "src\\main\\resources\\TestData.xlsx";


    public static Object[][] readData1() throws IOException {

        File testDataFile = new File(filePath);

        FileInputStream fileInput = new FileInputStream(testDataFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInput);

        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = sheet.getRow(0);
        int rowCount = sheet.getLastRowNum();
        int coloumCount = row.getLastCellNum();


        System.out.println("No of Coloums :" + coloumCount); //2 (index start from 1)
        System.out.println("No of Rows :" + rowCount);//2 (index start from 0)

        // we have 3 rows -> 1st row is for title we have to ignore it ,
        // we have 2*2 array like in our excel for now {(1,1)(1,2)(2,1)(2,2)}
        //we have to store excel data in an Array

        Object[][] loginData = new Object[rowCount][coloumCount];

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < coloumCount; c++) {
                // loginData[r][c] =sheet.getRow(r+1).getCell(c+1).toString();
                // 1st iteration in Array [0][0] = [1][0] --> this is in excel (1st row have to ignore,if we give coloum 0 it starts from 1st coloum)
                // 2nd iteration in Array [0][1] = [1][1] --> this is in excel
                // 3rd iteration in Array [1][0] = [2][0] --> this is in excel
                // 4th iteration in Array [1][1] = [2][1] --> this is in excel

                XSSFCell cell = sheet.getRow(r + 1).getCell(c + 1);
                if (cell != null) { // Add null check here
                    loginData[r][c] = ((XSSFCell) cell).toString();
                } else {
                    loginData[r][c] = ""; // Handle null case
                }
            }
        }


            workbook.close();
            fileInput.close();
            testDataFile = null;

            return loginData;
        }
}




