package com.huashan.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
	/**
	 * 创建一个excel文档 标题和内容,暂未实现,不要使用
	 * 
	 * @param titles
	 *            标题
	 *
	 *            字段(需要和标题对应)
	 * @param objs
	 *            内容
	 * @return
	 */
	public static Workbook buildWorkbook(String[] titles, String[] filedName,
			List<?> objs) {
		// TODO
		return null;
	}

	/**
	 * 创建一个只有一行的excel文档
	 * 
	 *  title
	 * @return
	 */
	public static Workbook buildWorkbook(String[] titles) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		if (StringUtils.areNotEmpty(titles)) {
			Row row = sheet.createRow(0);
			int i = 0;
			for (String title : titles) {
				Cell cell = row.createCell(i);
				cell.setCellValue(title);
				i++;
			}
		}

		return workbook;
	}

	/**
	 * 读取excel数据
	 * 
	 *  filePath
	 *            绝对路径
	 *  colsCountIndex
	 *            列的总数
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static List<String[]> readExcel(Workbook book,
										   int colsCount) throws InvalidFormatException, IOException {
		// 读取excel数据
//		Workbook book = WorkbookFactory.create(inputStream);
		if (book == null)
			return null;
		int rows = book.getSheetAt(0).getLastRowNum();
		int clos = colsCount;
		List<String[]> list = new ArrayList<String[]>();
			Sheet sheet = book.getSheetAt(0);
			for (int _row = 0; _row <= rows; _row++) {
				String[] sheetObj = new String[clos];
				Row row = sheet.getRow(_row);
				for (int clo = 0; clo < clos; clo++) {
					Cell cell = row.getCell(clo); // 取第几列数据
					if (cell == null) {
						sheetObj[clo] = "";
						continue;
					}
					int type = cell.getCellType();
					String value = null;//TODO 添加了判断数据类型     公式  布尔类型  错误 还有待完善  目前都是按空数据处理的
					if (type == 0) {  //数字
						value = cell.getNumericCellValue()+"";
						
					}else if(type==1){ //字符串
						value = cell.getStringCellValue();
					}else if(type==2){ //公式
						value="";
					}else if(type==3){ //空白
						value="";
					}else if(type==4){ //布尔
						value=""; //cell.getBooleanCellValue();
					}else if(type==5){ //错误
						value="";
					} else {//  防止判断不全
						value = cell.getStringCellValue();
					}
					if (null != value && !"".equals(value.trim())) {
						sheetObj[clo] = value.trim();
						// System.out.print(value + "\t");
					} else {
						sheetObj[clo] = "";
						// System.out.print(value + "\t");
					}
				}
				// System.out.println("\n");
				list.add(sheetObj);
			}
		return list;
	}
	
	public static List<String[]> readExcel(InputStream inputStream,
			int colsCount) throws InvalidFormatException, IOException {
		// 读取excel数据
		Workbook book = WorkbookFactory.create(inputStream);

		if (book == null)
			return null;
		int rows = book.getSheetAt(0).getLastRowNum();
		int clos = colsCount;
		List<String[]> list = new ArrayList<String[]>();
			Sheet sheet = book.getSheetAt(0);
			for (int _row = 0; _row <= rows; _row++) {
				String[] sheetObj = new String[clos];
				Row row = sheet.getRow(_row);
				for (int clo = 0; clo < clos; clo++) {
					Cell cell = row.getCell(clo); // 取第几列数据
					if (cell == null) {
						sheetObj[clo] = "";
						continue;
					}
					int type = cell.getCellType();
					String value = null;
					if (type == 0) {
						value = cell.getNumericCellValue() + "";
					} else {
						value = cell.getStringCellValue();
					}
					if (null != value && !"".equals(value.trim())) {
						sheetObj[clo] = value.trim();
						// System.out.print(value + "\t");
					} else {
						sheetObj[clo] = "";
						// System.out.print(value + "\t");
					}
				}
				// System.out.println("\n");
				list.add(sheetObj);
			}
		return list;
	}

	/**
	 * 读取excel数据
	 * 
	 * @param
	 *            绝对路径
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static List<String[]> readExcel(InputStream inputStream)
			throws InvalidFormatException, IOException {
		Workbook book = WorkbookFactory.create(inputStream);

		if (book == null)
			return null;
		int clos = book.getSheetAt(0).getRow(0).getLastCellNum();
		
		return readExcel(book, clos);
	}

	public static void main(String[] args) throws Exception {
		List<String[]> s = ExcelUtil.readExcel(new FileInputStream(
				"e:\\data\\tttt.xls"));
		for (String[] data : s) {
			for (String d : data) {
				System.err.print(d);
				System.err.print("\t");
			}
			System.err.println();
		}
	}
}
