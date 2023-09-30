package cr.ac.una.evacomuna.util;

import cr.ac.una.evacomuna.App;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.dto.FinalCalificationDto;
import cr.ac.una.evacomuna.dto.SkillDto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
 import  java.awt.Desktop;
import java.io.File;
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
    private EvaluationDto evaluationDto;
    
    public ExcelGenerator(EvaluatedDto evaluatedDto, EvaluationDto evaluationDto) {
        this.evaluatedDto = evaluatedDto;
        this.evaluationDto = evaluationDto;
    }
    
    public EvaluationDto getEvaluationDto() {
        return evaluationDto;
    }
    
    public void setEvaluationDto(EvaluationDto evaluationDto) {
        this.evaluationDto = evaluationDto;
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
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, evaluatedDto.getFinalCalifications().size()));//MERGE 
        Cell cell = row.createCell(0);
        cell.setCellValue(evaluationDto.getName());
        cell.setCellStyle(style);
        //SUBHEADER SKILLS
        row = sheet.createRow(1);
        style = createStyleHeader(workbook, HorizontalAlignment.CENTER, IndexedColors.LIGHT_BLUE);
        cell = row.createCell(0);
        cell.setCellValue("");
        if (evaluatedDto != null) {
            Long totalPoints = Long.valueOf(0), totalCalification = Long.valueOf(0);
            
            cell.setCellStyle(style);
            int i = 1;
            List<FinalCalificationDto> finalCalificationDtos = evaluatedDto.getFinalCalifications();
            Row pointsRow = sheet.createRow(2);
            Row calificationRow = sheet.createRow(3);

            //
            cell = pointsRow.createCell(0);
            cell.setCellValue("Points");
            cell.setCellStyle(style);
            //
            cell = calificationRow.createCell(0);
            cell.setCellValue(evaluatedDto.getEvaluated().getName() + " " + evaluatedDto.getEvaluated().getLastname());
            cell.setCellStyle(style);
            
            for (FinalCalificationDto finalCalificationDto : evaluatedDto.getFinalCalifications()) {
                totalCalification += finalCalificationDto.getAverage();
                cell = row.createCell(i);
                cell.setCellValue(finalCalificationDto.getSkill().getName());
                cell.setCellStyle(style);
                sheet.autoSizeColumn(i);
                cell = pointsRow.createCell(i);
                cell.setCellValue(100);
                totalPoints += 100;
                //cell
                sheet.autoSizeColumn(0);
                cell = calificationRow.createCell(i);
                cell.setCellValue(finalCalificationDto.getAverage());
                i += 1;
            }
            style = createStyleHeader(workbook, HorizontalAlignment.CENTER, IndexedColors.ORANGE);
            createPointsHeaders(cell, row, sheet, style, i);//Create the headers: total, note, average
            //points here
            cell = pointsRow.createCell(i);//Total
            cell.setCellValue(totalPoints);
            cell = calificationRow.createCell(i);
            cell.setCellValue(totalCalification);
            i += 1;
            cell = pointsRow.createCell(i);
            
            cell.setCellValue(totalPoints * 100 / totalPoints);//Note
            cell = calificationRow.createCell(i);
            cell.setCellValue(totalCalification * 100 / totalPoints);
            i += 1;
            double cantSkills = evaluatedDto.getFinalCalifications().size();//Average
            cell = pointsRow.createCell(i);
            cell.setCellValue(totalPoints / cantSkills);
            cell = calificationRow.createCell(i);
            cell.setCellValue(totalCalification / cantSkills);
            
        }
        style = createStyleHeader(workbook, HorizontalAlignment.CENTER, IndexedColors.LIGHT_BLUE);
        //row = sheet.createRow(2);

        try (FileOutputStream outputStream = new FileOutputStream("User Report.xls")) {
            workbook.write(outputStream);
            //System.out.println(outputStream.toString());
            //Desktop
            Desktop.getDesktop().open(new File("User Report.xls"));
            //FileLoader.openPath("User Report.xls");
            
            System.out.println("Archivo Excel creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void createPointsHeaders(Cell cell, Row row, Sheet sheet, CellStyle style, int i) {
        cell = row.createCell(i);
        cell.setCellValue("Total");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(i);
        i += 1;
        cell = row.createCell(i);
        cell.setCellValue("Note");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(i);
        i += 1;
        cell = row.createCell(i);
        cell.setCellValue("Average");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(i);
    }
    
}
