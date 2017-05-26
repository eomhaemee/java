package com.ktds.ehm.read;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriteHelper {

	private static final String LOG_FOLDER_PATH = "D:\\logs";
	private static final String LOG_FILE_PATH = LOG_FOLDER_PATH + "\\Calculator1.log";

	public static void log(String message) {

		// D:\\에 logs폴더 생성
		makeLogsFolder();

		// D:\\logs\\Calculator.log 파일을 생성한다.
		makeCalculatorLogFile();

		// D:\\logs\\Calculator.log 파일에 message를 기록한다.
		writeLog(message);

	}
	
	//private로 선언하여 외부에서 접근하지 못하게 함 사용자는 log만 호출함
	private static void makeLogsFolder() {
		File logsFolder = new File(LOG_FOLDER_PATH);

		final int a =1;
		
		if (!logsFolder.exists()) {
			logsFolder.mkdirs();
		}else if(!logsFolder.isDirectory()){
			logsFolder.mkdirs();
		}
	}
	private static void makeCalculatorLogFile() {
		File logFile = new File(LOG_FILE_PATH);

		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (!logFile.isFile()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private static void writeLog(String message) {

		try {
			PrintWriter fw = new PrintWriter(new BufferedWriter(new FileWriter(LOG_FILE_PATH, true)));
			fw.println(message);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
