package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	
	public static String getCurrentTimestamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss");
		return sdf.format(new Date());
	}

}
