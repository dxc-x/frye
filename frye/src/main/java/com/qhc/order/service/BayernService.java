/**
 * 
 */
package com.qhc.order.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.qhc.config.ApplicationConfig;
import com.qhc.exception.ExternalServerInternalException;
import com.qhc.exception.URLNotFoundException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author wang@dxc.com
 * @param <T>
 *
 */
@Service
public class BayernService<T> {
	
	@Autowired
	ApplicationConfig config;
	
	@Value("${qhc.bayern.url}")
	String bayernUrl;

	private WebClient webClient;

	protected Builder getBuilder() {
		WebClient.Builder webClientBuilder = WebClient.builder()
				.defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json").defaultHeader("App-Locale", "chs")
				.defaultHeader(HttpHeaders.USER_AGENT,
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
		webClientBuilder.filter(logRequest());
		return webClientBuilder;
	}

	private ExchangeFilterFunction logRequest() {
		return (clientRequest, next) -> {
			System.out.println("Request: " + clientRequest.method() +" : "+ clientRequest.url());
			clientRequest.headers()
					.forEach((name, values) -> values.forEach(value -> System.out.println("{}={}" + name + value)));
			return next.exchange(clientRequest);
		};
	}
	
	/**
	 * 
	 * @param path
	 * @param value
	 */
	public void postJason(String path, Object value) {
		webClient = getBuilder().baseUrl(bayernUrl).build();
		Mono<String> response = webClient.post().uri(path).contentType(MediaType.APPLICATION_JSON).bodyValue(value)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new URLNotFoundException()))
				.onStatus(HttpStatus::is5xxServerError,
						clientResponse -> Mono.error(new ExternalServerInternalException()))
				.bodyToMono(String.class);
		response.block();
	}

	/**
	 * 
	 * @param path remote url path in bayern
	 * @param pars post data
	 * @param T returned object type
	 * @return returned object
	 */
	public T postForm(String path, Map<String,String> pars, Class T) {
		String url = config.getBayernURL() + path;
		
		@SuppressWarnings("unchecked")
		Mono<T> resp = WebClient.create().post().uri(url).contentType(MediaType.APPLICATION_JSON)
				.bodyValue(pars).retrieve()
				.onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new URLNotFoundException()))
				.onStatus(HttpStatus::is5xxServerError,
						clientResponse -> Mono.error(new ExternalServerInternalException()))
				.bodyToMono(T);
		return resp.block();
	}
	/**
	 * 
	 * @param path
	 * @param T
	 * @return
	 */
	public List<T> getListInfo(String path, Class<T> T) {
		String url = config.getBayernURL()+ path;
		WebClient webClient = WebClient.create(url);
		Flux<T> userFlux = webClient.get().uri(url).retrieve()
				.onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new URLNotFoundException()))
				.onStatus(HttpStatus::is5xxServerError,
						clientResponse -> Mono.error(new ExternalServerInternalException()))
				.bodyToFlux(T);
		List<T> list = userFlux.collectList().block();
		return list;
	}
	

}