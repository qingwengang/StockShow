package Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {

	public static String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	public static String getCurrentTime(String formatter) {
		SimpleDateFormat format = new SimpleDateFormat(formatter);
		return format.format(new Date());
	}

	public static String getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date());
	}

	public static String getCurrentDate(String formatter) {
		SimpleDateFormat format = new SimpleDateFormat(formatter);
		return format.format(new Date());
	}

	public static String formatDate(String formatter, Date dateObj) {
		SimpleDateFormat format = new SimpleDateFormat(formatter);
		return format.format(dateObj);
	}
}
