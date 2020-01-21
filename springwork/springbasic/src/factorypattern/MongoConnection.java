package factorypattern;
//추가 요구사항  발생 시
public class MongoConnection extends Connection {
	public MongoConnection(String url) {
		super(url);
	}

	public void connect() {
		System.out.println(url + "위치의 MongoDB 서버로 연결을 시도합니다.");
	}
}
