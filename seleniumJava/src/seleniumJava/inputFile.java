package seleniumJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class inputFile {
	
	@SuppressWarnings("deprecation")
	public Map<String, ArrayList<String>> file(String filename,int index) throws IOException{

		File file = new File(filename);
		InputStream in = new FileInputStream(file);
		Workbook wb = new HSSFWorkbook(in);
		Map<String, ArrayList<String>> maprow = new HashMap<>();
		try {
			Sheet sheet = wb.getSheetAt(index);
			Row row = null;
			Cell cell = null;
			int rownum = sheet.getLastRowNum();
			ArrayList<String> rows = null;
			for (int i = 1; i < rownum+1; i++) {
				row = sheet.getRow(i);
				int cellnum = sheet.getRow(i).getLastCellNum();
				rows = new ArrayList<>();
				for (int j = 0; j < cellnum; j++) {
					cell = row.getCell(j);
					try {
						String cellval = cell.getStringCellValue();
						if (cellval.length()>=1) {
							rows.add(cellval);
						} else {
							cellval = "";
							rows.add(cellval);
						}
					} catch (Exception e) {
						continue;
					}
				}
				maprow.put(""+i+"", rows);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		wb.close();
		return maprow;
	
	}
}
