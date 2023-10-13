package com.kafka.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.cluster.coordination.Publication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElastichSearchConfig {

	@Bean(destroyMethod = "close" )
	public RestHighLevelClient createClient() {
		
		//---------------- si tiene credenciales se puede agregar de esta manera--------------------
		/*final CredentialsProvider credentialsProvider=new
				BasicCredentialsProvider();
				credentialsProvider.setCredentials(AuthScope.ANY,new
				UsernamePasswordCredentials("user","password"));*/
		
		/*//con callback
		RestHighLevelClient client=new RestHighLevelClient(
				RestClient.builder(new HttpHost("localhost", 9200,"http"))
				.setHttpClientConfigCallback(new HttpClientConfigCallback() {
					
					@Override
					public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
						// TODO Auto-generated method stub
						return null;
					}
				})
				);
		*/
		/*// con lambda
				
		RestHighLevelClient client=new RestHighLevelClient(
				RestClient.builder(new HttpHost("localhost", 9200,"http"))
				.setHttpClientConfigCallback((config)->config.setDefaultCredentialsProvider(credentialsProvider))
				);
		*///----------------------------------------------------------
		
		RestHighLevelClient client=new RestHighLevelClient(
				RestClient.builder(new HttpHost("localhost", 9200,"http")));
		return client;
	}
}
