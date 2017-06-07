package com.spring.boot.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.spring.boot.app.pojo.Employee;

public class CsvView extends AbstractCsvView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildCsvDocument(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setHeader("Content-Disposition",
				"attachment; filename=\"employees.csv\"");

		List<Employee> employees = (List<Employee>) model.get("employees");
		String[] header = { "Id", "Name", "Dept", "Salary" };
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);

		csvWriter.writeHeader(header);

		for (Employee employee : employees) {
			csvWriter.write(employee, header);
		}
		csvWriter.close();

	}
}
