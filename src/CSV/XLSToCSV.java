package CSV;

import Message.Message;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author Zach Larson
 */
public class XLSToCSV {

    public static File convertXLSToCSV(File xls) {
        try {
            String fileName = xls.getName();
            File csv = File.createTempFile(fileName, ".csv");
            FileOutputStream fos = new FileOutputStream(csv);
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(xls));
            Sheet sheet = workbook.getSheetAt(0);
            int startRowIndex = 4;
            int lastRowNumber = sheet.getLastRowNum();
            StringBuilder output = new StringBuilder();
            for (int i = startRowIndex; i < lastRowNumber + 1; i++) {
                Row currentRow = sheet.getRow(i);
                try {
                    for (int cellIndex = 0; cellIndex < currentRow.getLastCellNum(); cellIndex++) {
                        Cell cell = currentRow.getCell(cellIndex, Row.CREATE_NULL_AS_BLANK);
                        output.append(getContents(cell).replaceAll("[,]", "")).append(",");
                    }
                } catch (Exception ex) {
                    break;
                }

                if (output.toString().endsWith(",")) {
                    output.deleteCharAt(output.length() - 1);
                }
                output.append("\n");
            }
            fos.write(output.toString().getBytes());
            return csv;
        } catch (Exception ex) {
            String message = "There was an error converting the .xls file to a "
                    + "CSV file. (XLStoCSV convertXLSToCSV(File xls)) \n";
            Message.displayError("Parsing .xls file", message + ex.getMessage());;
        }
        return null;
    }

    private static String getContents(Cell cell) {
        String contents = "";
        int cellType = cell.getCellType();
        switch (cellType) {
            case Cell.CELL_TYPE_STRING:
                try {
                    double value = Double.parseDouble(cell.getStringCellValue());
                    contents = "\"" + value + "\"";
                } catch (Exception ex) {
                    String tmp = cell.getStringCellValue();
                    if (tmp.startsWith("Ca") || tmp.startsWith("K")
                            || tmp.startsWith("Mg") || tmp.startsWith("Na")
                            || tmp.startsWith("B") || tmp.startsWith("Cu")
                            || tmp.startsWith("Fe") || tmp.startsWith("Mn")
                            || tmp.startsWith("S") || tmp.startsWith("Zn")
                            || tmp.startsWith("P")) {
                        tmp = tmp.replaceAll("[0-9_]", "");
                    }

                    contents = tmp;
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                contents = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                contents = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                contents = "";
                break;
        }
        return contents;
    }
}
