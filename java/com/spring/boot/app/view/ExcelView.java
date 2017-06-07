package com.spring.boot.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.spring.boot.app.pojo.Employee;


public class ExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// change the file name
		response.setHeader("Content-Disposition",
				"attachment; filename=\"employees.xls\"");

		@SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>) model.get("employees");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("Employee Detail");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Id");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Name");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Dept");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Salary");
		header.getCell(3).setCellStyle(style);

		int rowCount = 1;

		for (Employee employee : employees) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellValue(employee.getId());
			userRow.createCell(1).setCellValue(employee.getName());
			userRow.createCell(2).setCellValue(employee.getDept());
			userRow.createCell(3).setCellValue(employee.getSalary());
		}

	}

}
