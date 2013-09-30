package example.elasticsearch;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 */
public class Indexer {

	private final String hostName;
	private final int port;

	public Indexer(String hostName, int port) {
		this.hostName = hostName;
		this.port = port;
	}

	public void createIndex(String indexName, String settingsJson, String mappingsJson) {
		IndexManager.createIndex(hostName, port, indexName, settingsJson, mappingsJson);
	}

	public static void main(String[] args) {
		try {
			InputStream stream1 = Indexer.class.getResourceAsStream("/example/elasticsearch/resources/persons_settings.json");
			String settingsJson = Utils.fromStream(stream1);
			InputStream stream2 = Indexer.class.getResourceAsStream("/example/elasticsearch/resources/persons_mappings.json");
			String mappingsJson = Utils.fromStream(stream2);

			Indexer indexer = new Indexer("192.168.1.70", 9300);
			indexer.createIndex("persons", settingsJson, mappingsJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
