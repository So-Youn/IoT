package api.io;

import java.io.File;
import java.text.SimpleDateFormat;

//폴더의 내부를 탐색
public class FileTest02 {
	public static void main(String[] args) {
		//c:\iot\iotest폴더의 하위 폴더 및 파일을 출력
		//[출력형태]
		//a---[폴더]
		//b---[폴더]
		//ArrayTest01.java ------[파일]파일 사이즈 출력]
		//
		
		//마지막 접속한 날짜를 년 월 일의 형식으로 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		File file= new File("c:/iot/iotest");
		File[] list = file.listFiles();
		
		/*if(file.isDirectory()==true) {
			for (File file2 : list) {
				if(file2.isFile()!=true) {
					System.out.println(file2.getName()+"-----[폴더]");
				}else {
					System.out.println(file2.getName()+"-----[파일:("+file2.length()+")]");
				}
				
			}*/
				
	
		for(int i=0;i<list.length;i++) {
			if(list[i].isDirectory()) {
				System.out.println(list[i].getName()+"-----[폴더]");
			}else {
				System.out.println(list[i].getName()+"-----[파일:("+list[i].length()+")]"+
						sdf.format(list[i].lastModified()));
			}
		}
		
	}
}
