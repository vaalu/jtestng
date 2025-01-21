package com.icw.automation.mobile.generics.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icw.automation.mobile.generics.ITestStep;
import com.icw.automation.mobile.generics.impl.defaults.DefaultTestStep;

@Component
public class ExcelUtils {
private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);
	
	@Autowired
	PropertiesUtil props;
	
	private List<ITestStep> testSequence;
	
	public static int sheetIndex = 0;
	
	public List<ITestStep> readInputFile() {
		testSequence = new ArrayList<>();
		
		try {
			File f = new File(props.getInputExcel());
			LOGGER.debug("Reading from input file: {}", f.getAbsolutePath());
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			int totalSheets = wb.getNumberOfSheets();
			for (int sheetIndex = 0; sheetIndex < totalSheets; sheetIndex++) {
				XSSFSheet sheet = wb.getSheetAt(sheetIndex);
				Iterator<Row> rows = sheet.iterator();
				DefaultTestStep test = null;
				while(rows.hasNext()) {
					Row row = rows.next();
					Iterator<Cell> cells = row.cellIterator();
					test = new DefaultTestStep();
					while(cells.hasNext()) {
						Cell cell = cells.next();
						String cellValue = cell.toString();
						if (row.getRowNum() > 0) {
							switch(cell.getColumnIndex()) {
							case 0:
								test.setWorkflow(cellValue);
								break;
							case 1:
								test.setIdType(cellValue);
								break;
							case 2:
								test.setIdentifier(cellValue);
								break;
							case 3:
								test.setValue(cellValue);
								break;
							case 4:
								test.setAction(cellValue);
								break;
							case 5:
								test.setExpected(cellValue);
								break;
							case 6:
								test.setComments(cellValue);
								break;
							}
						}
					}
					if(row.getRowNum() > 0) {
						testSequence.add(test);
						LOGGER.debug("Test step: " + test);
					}
				}
			}
			wb.close();
			fis.close();
			
		} catch (IOException e) {
			LOGGER.error("Unable to read excel file.", e);
		}
		return testSequence;
	}
}
