package test.json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONMakerExam {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		JSONObject myjson = new JSONObject();

		JSONArray subjectlist = new JSONArray();
		subjectlist.add("자바");
		subjectlist.add("스프링");
		subjectlist.add("하둡");

		JSONArray addrlist = new JSONArray();
		JSONObject addr = new JSONObject();
		addr.put("zip", "111-222");
		addr.put("addr1", "인천시");
		addrlist.add(addr);

		JSONArray historylist = new JSONArray();
		JSONObject history = new JSONObject();
		history.put("subject", "java");
		history.put("month", "11");

		JSONObject history2 = new JSONObject();
		history2.put("subject", "servlet");
		history2.put("month", "12");

		historylist.add(history);
		historylist.add(history2);
		
		myjson.put("name", "김서연");
		myjson.put("age", "25");
		myjson.put("subject", subjectlist);
		myjson.put("addr", addrlist);
		myjson.put("history", historylist);
		
		// json파일을 생성 - 파일 io
		FileWriter fw = new FileWriter("src/main/java/test/json/myjson2.json");
		fw.write(myjson.toJSONString());
		fw.flush();
		fw.close();
	}
}
