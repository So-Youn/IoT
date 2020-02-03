package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONArray; import org.json.simple.JSONObject; import org.json.simple.parser.JSONParser;
public class apiTest {
	public static void main(String[] args) {
		try{ /*��û�����Է� * �Ʒ��� ���� �������� ����� ���̵带 Ȯ���Ͽ� ã���ֽø� �˴ϴ�. * ���� �浵�� �������� �ȿ� �ֽ��ϴ�. * */ 
			//�ڽ��� ��ȸ�� ���ϴ� ������ �浵�� ������ �Է����ּ��� 
			String nx = "92";//�浵 
			String ny = "131"; //���� String 
			String baseDate = "20200201";
			String baseTime = "0500";//�ڽ��� ��ȸ�ϰ���� �ð��븦 �Է����ּ��� 
			// ���� ����Ű�Դϴ�. �������������п��� �������� ����Ű�� �־��ֽø� �˴ϴ�. 
			String serviceKey = "bFLjSVwZpB%2BomeIbURaEI3jRNcEQ9j9jhqNnd2bDYYvybfq8qGRrA5zrU19E1b2w7TVtaw%2FZ%2BJhA5wZYDewN3g%3D%3D";
			// ������ ��Ƽ� URL������ �����˴ϴ�. �� ������ "&_type=json"�� ���� ��ȯ �������� ���°� �������ϴ�. 
			String urlStr = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?"+ "serviceKey=" + serviceKey + "&numOfRows=10&pageNo=1&base_date=" + baseDate + "&base_time=" + baseTime + "&nx="+ nx + "&ny=" + ny; 


			URL url = new URL(urlStr); // �� urlStr�� �̿��ؼ� URL ��ü�� ������ݴϴ�. 
			BufferedReader bf; String line = ""; String result=""; //���� ������ �޾ƿɴϴ�. 
			bf = new BufferedReader(new InputStreamReader(url.openStream())); 
			//���ۿ� �ִ� ������ �ϳ��� ���ڿ��� ��ȯ. 
			while((line=bf.readLine())!=null){ 
				result=result.concat(line); 
				System.out.println(result); // �޾ƿ� �����͸� Ȯ���غ��ϴ�. 
				} 
			// Json parser�� ����� ������� ���ڿ� �����͸� ��üȭ �մϴ�. 
			JSONParser parser = new JSONParser(); JSONObject obj = (JSONObject) parser.parse(result); 
			// Top���� �ܰ��� response Ű�� ������ �����͸� �Ľ��մϴ�. 
			JSONObject parse_response = (JSONObject) obj.get("response"); 
			// response �� ���� body ã�ƿɴϴ�. 
			JSONObject parse_body = (JSONObject) parse_response.get("body"); 
			// body �� ���� items �޾ƿɴϴ�. 
			JSONObject parse_items = (JSONObject) parse_body.get("items"); 
			// items�� ���� itemlist �� �޾ƿ��� itemlist : �ڿ� [ �� �����ϹǷ� jsonarray�̴� 
			JSONArray parse_item = (JSONArray) parse_items.get("item"); String category; JSONObject weather; 
			// parse_item�� �迭�����̱� ������ �ϳ��� �����͸� �ϳ��� �����ö� ����մϴ�. 
			// �ʿ��� �����͸� �����������մϴ�. 
			for(int i = 0 ; i < parse_item.size(); i++) { weather = (JSONObject) parse_item.get(i);
			//String base_Date = (String)weather.get("baseDate"); 
			//String fcst_Time = (String)weather.get("fcstDate"); 
			double fcst_Value = ((Long)weather.get("fcstValue")).doubleValue(); 
			//�Ǽ��ε� ���� �����ε� ���� �Ѵ� �־ �Ǽ��� �����߽��ϴ�. 
			//String nX = (String)weather.get("nx"); 
			//String nY = (String)weather.get("ny");
			category = (String)weather.get("category");
			//String base_Time = (String)weather.get("baseTime");
			//String fcscDate = (String)weather.get("fcscDate");
			// ����մϴ�. 
			System.out.print("�迭�� "+i+"��° ���"); System.out.print(" category : "+ category); 
			System.out.print(" fcst_Value : "+ fcst_Value); System.out.println(); } 
			// ������������ ������ �߻��Ͽ��µ� casting�����Դϴ�. // �̴� ��ȯ�Ǵ� ������Ÿ���� �޶��ε� �̹� �ۿ����� ����������ϰ� // �����ͺ��̽��� �Է��Ҷ��� �����ؼ� �ϰڽ��ϴ�. 
			bf.close(); }catch(Exception e){ System.out.println(e.getMessage()); } } 
			
			
		}
	

	

