package br.com.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import br.com.mobel.Livro;
import br.com.util.Style;

public class LivroService {

	public void writeExcel(List<Livro> livros, String excelFilePath) throws IOException {
		Workbook workbook = new HSSFWorkbook();
	    Sheet sheet = workbook.createSheet();
	    
	    createHeaderRow(sheet);
	 
	    int rowCount = 0;
	 
	    for (Livro livro : livros) {
	        Row row = sheet.createRow(++rowCount);
	        writeBook(livro, row, workbook);
	    }
	 
	    try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	        workbook.write(outputStream);
	    }
	}
	
	private void createHeaderRow(Sheet sheet) {
		 
	    CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
	    Font font = sheet.getWorkbook().createFont();
	    font.setBold(true);
	    font.setFontHeightInPoints((short) 16);
	    cellStyle.setFont(font);
	 
	    Row row = sheet.createRow(0);
	    Cell cellTitle = row.createCell(1);
	 
	    cellTitle.setCellStyle(cellStyle);
	    cellTitle.setCellValue("Title");
	 
	    Cell cellAuthor = row.createCell(2);
	    cellAuthor.setCellStyle(cellStyle);
	    cellAuthor.setCellValue("Author");
	 
	    Cell cellPrice = row.createCell(3);
	    cellPrice.setCellStyle(cellStyle);
	    cellPrice.setCellValue("Price");
	}
	
	private void writeBook(Livro livro, Row row, Workbook workbook) {
		Style style = new Style(workbook);
		
	    Cell cell = row.createCell(1);
	    style.setValue(cell, livro.getTitulo());
	 
	    cell = row.createCell(2);
	    style.setValue(cell, livro.getAutor());
	 
	    cell = row.createCell(3);
	    style.setValue(cell, livro.getPreco());
	}
	
}
