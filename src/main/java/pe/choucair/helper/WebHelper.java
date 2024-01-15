package pe.choucair.helper;

public class WebHelper {
	public static void pausar() {
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
