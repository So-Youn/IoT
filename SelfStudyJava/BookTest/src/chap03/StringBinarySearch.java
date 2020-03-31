package chap03;
import java.util.*;
//문자열의 배열(Java의 키워드)에서 검색
public class StringBinarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Java에서 사용하는 키워드입니다.
		String[] x= {
				"abstract",   "assert",       "boolean",   "break",      "byte",
				"case",       "catch",        "char",      "class",      "const",
				"continue",   "default",      "do",        "double",     "else",
				"enum",       "extends",      "final",     "finally",    "float",
				"for",        "goto",         "if",        "implements", "import",
				"instanceof", "int",          "interface", "long",       "native",
				"new",        "package",      "private",   "protected",  "public",
				"return",     "short",        "static",    "strictfp",   "super",
				"switch",     "synchronized", "this",      "throw",      "throws",
				"transient",  "try",          "void",      "volatile",   "while"	
		};
		
		System.out.print("원하는 키워드 입력하세요 :"); //키 입력
		String key = sc.next();
		sc.close();
		int idx = Arrays.binarySearch(x, key);
		
		if(idx <0)
			System.out.println("해당 키워드가 없다");
		else
			System.out.println("해당 키워드는 x[" + idx + "]에 있습니다.");
			
		
	}
	
}
