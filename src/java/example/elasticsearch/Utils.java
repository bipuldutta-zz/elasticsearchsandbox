package example.elasticsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
	/**
	 * Simply converts an {@link InputStream} to String. There are other library like IOUtils from Apache to do a better job but this is for keeping it a bit simpler.
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static String fromStream(InputStream in) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder out = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			out.append(line);
		}
		return out.toString();
	}

}
