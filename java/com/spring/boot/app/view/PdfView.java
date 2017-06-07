package com.spring.boot.app.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.boot.app.pojo.Employee;

public class PdfView extends AbstractPdfView {
	@SuppressWarnings({ "unchecked" })
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition",
				"attachment; filename=\"employees.pdf\"");
		List<Employee> employees = (List<Employee>) model.get("employees");
		document.add(new Paragraph("Generated Reports " + LocalDate.now()));

		PdfPTable table = new PdfPTable(employees.size());
		table.setWidthPercentage(100.0f);
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.TIMES);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.DARK_GRAY);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("Id", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Dept", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Salary", font));
		table.addCell(cell);

		for (Employee employee : employees) {
			table.addCell(String.valueOf(employee.getId()));
			table.addCell(employee.getName());
			table.addCell(employee.getDept());
			table.addCell(String.valueOf(employee.getSalary()));
		}

		document.add(table);
	}
}
