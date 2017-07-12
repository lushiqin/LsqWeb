package seleniumJava;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ces {
	public static void main(String[] args) {
		time();
	}
	
	public static void time(){
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.HOUR_OF_DAY, 20);
		calendar1.set(Calendar.MINUTE, 55);
		calendar1.set(Calendar.SECOND, 0);
		Date time1 = calendar1.getTime();
		Timer timer1 = new Timer();
		timer1.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				inputFile exportfile = new inputFile();
				try {
					Map<String, ArrayList<String>> map = exportfile.file("C:/Users/陆石勤/Desktop/sltk.xlsx",0);
					ArrayList<String> list = new ArrayList<>();
					for (int i = 1; i < map.size()+1; i++) {
						list = map.get(""+i+"");
						System.out.println(i+"--"+list.size()+"--");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, time1, 1000*60*60*5);
	}
}
