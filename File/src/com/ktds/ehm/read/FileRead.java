package com.ktds.ehm.read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	private final String LOG_FOLDER_PATH = "D:\\logs";
	private final String LOG_FILE_PATH = LOG_FOLDER_PATH + "\\Calculator.log";

	public void start() {
		try {
			/*FileReader fr = new FileReader(LOG_FILE_PATH);
			BufferedReader br = new BufferedReader(fr);*/
			BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_PATH));
			
			try {

				String line = null;

				while (true) {
					// 한줄씩 읽어옴
					line = br.readLine();
					// 다읽으면 맨끝에 null이므로 null만나면 그만해라
					if (line == null) {
						break;
					}
					System.out.println(line);
					FileWriteHelper.log(line);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new FileRead().start();
	}
}
