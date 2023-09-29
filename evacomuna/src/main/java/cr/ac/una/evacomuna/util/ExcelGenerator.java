package cr.ac.una.evacomuna.util;

import cr.ac.una.evacomuna.dto.EvaluatedDto;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author estebannajera
 */
public class ExcelGenerator {

    private EvaluatedDto evaluatedDto;

    public ExcelGenerator(EvaluatedDto evaluatedDto) {
        this.evaluatedDto = evaluatedDto;
    }

    public EvaluatedDto getEvaluatedDto() {
        return evaluatedDto;
    }

    public void setEvaluatedDto(EvaluatedDto evaluatedDto) {
        this.evaluatedDto = evaluatedDto;
    }

    public CellStyle createStyleHeader(Workbook workbook, HorizontalAlignment horizontalAlignment, IndexedColors colors) {
        CellStyle cellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        cellStyle.setFont(headerFont);
        cellStyle.setAlignment(horizontalAlignment);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(colors.getIndex());

        return cellStyle;
    }

    public void generateExcelReport() {

        Workbook workbook = new HSSFWorkbook();
        
        Sheet sheet = workbook.createSheet("Report");
        CellStyle style = createStyleHeader(workbook, HorizontalAlignment.CENTER, IndexedColors.BLUE);
        //MAIN HEADER
        Row row = sheet.createRow(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));//MERGE 
        Cell cell = row.createCell(0);
        cell.setCellValue("Evaluation Name Here");
        cell.setCellStyle(style);
        //SUBHEADER SKILLS
        row = sheet.createRow(1);
        style = createStyleHeader(workbook, HorizontalAlignment.CENTER, IndexedColors.LIGHT_BLUE);
        cell = row.createCell(0);
        cell.setCellValue("");
        cell.setCellStyle(style);
        for (int i = 1; i < 5; i++) {
            cell = row.createCell(i);
            cell.setCellValue("Skill");
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
        }
        style = createStyleHeader(workbook, HorizontalAlignment.CENTER, IndexedColors.ORANGE);
        cell = row.createCell(5);
        cell.setCellValue("Total");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(5);

        cell = row.createCell(6);
        cell.setCellValue("Note");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(6);

        cell = row.createCell(7);
        cell.setCellValue("Average");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(7);

        style = createStyleHeader(workbook, HorizontalAlignment.CENTER, IndexedColors.LIGHT_BLUE);
        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue("Points");
        cell.setCellStyle(style);

        try (FileOutputStream outputStream = new FileOutputStream("User Report.xls")) {
            workbook.write(outputStream);
            System.out.println("Archivo Excel creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
