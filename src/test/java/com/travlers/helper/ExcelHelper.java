package com.travlers.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ExcelHelper {
    public static void readExcelFile() throws IOException {

        InputStream inputStream = new FileInputStream(new File("/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/Dane-2.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator iterator =  sheet.rowIterator();

        while (iterator.hasNext()) {
            Row row = (Row) iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if (cell.getCellType().equals(CellType.STRING)){
                    System.out.println(cell.getStringCellValue());
                } else if (cell.getCellType().equals(CellType.NUMERIC)) {
                    System.out.println(cell.getStringCellValue());
                } else {
                    System.out.println("Brak typu");
                }

            }

        }

    }

    public static Object[][] newReadExcelFile(File file) throws IOException {

        InputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
       // Iterator iterator =  sheet.rowIterator();
        int rowNumbers = sheet.getLastRowNum();
        int colNumbers = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[rowNumbers][colNumbers];

        for (int i = 0; i<rowNumbers; i++) {
            Row rowe = sheet.getRow(i + 1);
            for (int j = 0; j < rowe.getLastCellNum(); j++) {
                data[i][j] = rowe.getCell(j).getStringCellValue();
                System.out.println();
            }
        }
        return data;
    }



    public static void main(String[] args) throws IOException {
     //   readExcelFile();
        Object[][] data = newReadExcelFile(new File("/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/DaneNew.xlsx"));
        System.out.println(data[0][0]);
    }
}
