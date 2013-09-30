package example.elasticsearch;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.indices.IndexAlreadyExistsException;

/**
 * This class is responsible for managing indexes.
 * 
 */
public class IndexManager {

	/**
	 * Initializes a index with settings and mappings from json files.
	 * 
	 * @param hostAddress
	 *            ip or host name where the elasticsearch server running
	 * @param port
	 * @param indexName
	 */
	public static void createIndex(String hostAddress, int port, String indexName, String settingsJson, String mappingsJson) {
		Settings settings = ImmutableSettings.settingsBuilder().put("client.transport.sniff", true).put("cluster.name", "elasticsearch").build();
		Client client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(hostAddress, port));

		try {
			Settings indexSettings = ImmutableSettings.settingsBuilder().loadFromSource(settingsJson).build();
			CreateIndexRequestBuilder createIndexRequestBuilder = client.admin().indices().prepareCreate(indexName);
			createIndexRequestBuilder.addMapping(indexName, mappingsJson);
			createIndexRequestBuilder.setSettings(indexSettings);
			createIndexRequestBuilder.execute().actionGet();
		} catch (IndexAlreadyExistsException e) {
			// IGNORE IF ALREADY EXISTS.
		}
	}
}
