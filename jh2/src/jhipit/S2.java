package jhipit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("New world");
		S2 foo = new S2();
		foo.parse();
	}

	private void parse() {
		System.out.println("In");
		String str = "{\"album_id\":\"7596\",\"album_title\":\"Tjoho\"}";
        Gson gson = new GsonBuilder().create();
        Albums a = gson.fromJson(str, Albums.class);
        System.out.println(a);
	}
}
