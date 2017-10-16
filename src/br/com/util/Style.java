package br.com.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.DateFormatConverter;

public class Style {

	protected String dateFormatPattern = "dd/MM/yyyy HH:mm:ss";
	Map<String, CellStyle> styles;
	private Workbook workbook;

	public Style(Workbook workbook) {
		this.workbook = workbook;
		createStyles();
	}

	public Map<String, CellStyle> createStyles() {
		styles = new HashMap<String, CellStyle>();
		CellStyle style;

		Font titleFont = workbook.createFont();
		titleFont.setFontHeightInPoints((short) 12);
		titleFont.setBold(true);
		style = workbook.createCellStyle();
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor((short) 10);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(titleFont);
		style.setWrapText(false);
		style.setBorderBottom(BorderStyle.THIN);
		styles.put("header", style);

		Font cellFont = workbook.createFont();
		cellFont.setFontHeightInPoints((short) 10);

		style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		style.setVerticalAlignment(VerticalAlignment.BOTTOM);
		style.setFont(cellFont);
		style.setWrapText(false);
		style.setDataFormat(workbook.createDataFormat().getFormat(BuiltinFormats.getBuiltinFormat(3)));
		styles.put("integer_number_cell", style);

		style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		style.setVerticalAlignment(VerticalAlignment.BOTTOM);
		style.setFont(cellFont);
		style.setWrapText(false);
		style.setDataFormat(workbook.createDataFormat().getFormat(BuiltinFormats.getBuiltinFormat(4)));
		styles.put("decimal_number_cell", style);

		style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.BOTTOM);
		style.setFont(cellFont);
		style.setWrapText(false);
		style.setDataFormat((short) BuiltinFormats.getBuiltinFormat("text"));
		styles.put("text_cell", style);

		style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.BOTTOM);
		style.setFont(cellFont);
		style.setWrapText(false);
		style.setDataFormat(workbook.createDataFormat().getFormat(DateFormatConverter.convert(Locale.getDefault(), dateFormatPattern)));
		styles.put("date_cell", style);
		return styles;
	}
	
	public void setValue(Cell cell, Object value) {
		 if (value instanceof Short || value instanceof Long || value instanceof Integer || value instanceof BigInteger ) { 
             cell.setCellType(CellType.NUMERIC); 
             cell.setCellStyle(styles.get("integer_number_cell")); 
             cell.setCellValue(((Number) value).doubleValue()); 
         } else if (value instanceof Float || value instanceof Double || value instanceof BigDecimal ) { 
             cell.setCellType(CellType.NUMERIC); 
             cell.setCellStyle(styles.get("decimal_number_cell")); 
             cell.setCellValue(((Number) value).doubleValue()); 
         } else if (value instanceof Date) { 
             cell.setCellType(CellType.STRING); 
             cell.setCellStyle(styles.get("date_cell")); 
             cell.setCellValue((Date) value); 
         }  else { 
             cell.setCellType(CellType.STRING); 
             cell.setCellStyle(styles.get("text_cell")); 
             cell.setCellValue(value.toString()); 
         }
	}

}
