package api.io;

import java.io.File;

public class FileTest01 {
	public static void main(String[] args) {
		//액세스하고 싶은 파일이나 폴더의 위치를 File객체 만들 때 매개변수 정의
		//1.c:\iot\iotest폴더- c:\\iot\\iotest로 표현
		File file1 = new File("c:/iot/iotest"); 	//절대경로 
		//2.프로젝트 폴더에 저장한 test.txt 파일
		//   => 경로를 정의하지 않는 경우 기본으로 인식하는 위치는 프로젝트 폴더(advancedjava)
		File file2 = new File("test.txt");
		//3.src/data폴더에 저장된 test.txt파일
		File file3 = new File("src/data/test.txt");	//상대경로 
		System.out.println(file1);
		System.out.println(file2);
		System.out.println(file3);
		
		System.out.println("file3.canRead()=>"+file3.canRead());
		System.out.println("file3.canWrite()=>"+file3.canWrite());
		//읽고 쓸 수 있는지
		System.out.println("file3.getName()=>"+file3.getName());
		System.out.println("file3.getAbsolutePath()=>"+file3.getAbsolutePath());
		//절대경로 리턴
		System.out.println("file3.getParent()=>"+file3.getParent());
		//파일 명을 뺀 폴더의 명 리턴
		System.out.println("file3.getPath()=>"+file3.getPath());
		
		System.out.println("file3.isDirectory()=>"+file3.isDirectory());
		System.out.println("file1.isDirectory()=>"+file1.isDirectory());
		System.out.println("file3.isFile()=>"+file3.isFile());
		System.out.println("file1.isFile()=>"+file1.isFile());
		System.out.println("file3.isHidden()=>"+file3.isHidden());
		System.out.println("file3.lastModified()=>"+file3.lastModified());
		System.out.println("file3.setReadOnly()=>"+file3.setReadOnly());
		
		
	}
}
