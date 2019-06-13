package com.zimo.utils.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * SpringFrameWork RESTfulHttp Api 调用接口 
 * 
 * @ClassName: 
 * @author: FizzyElf
 * @date: 2018年5月16日 下午8:22:45
 *
 */
public class RestApiUtil {
	private static final Logger log = LoggerFactory.getLogger(RestApiUtil.class);
	private static RestTemplate rest;
	private static final int readTimeout = 5000;
	private static final int connectionTimeout = 3000;
	private static SimpleClientHttpRequestFactory httpRequestFactory;
	
	static {
		httpRequestFactory = new SimpleClientHttpRequestFactory();
		httpRequestFactory.setReadTimeout(readTimeout);
		httpRequestFactory.setConnectTimeout(connectionTimeout);
		rest = new RestTemplate(httpRequestFactory);
	}
	
	/**
	 * 
	 * @param account
	 * @param password
	 * @param url
	 * @param params
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("all")
	public static Object postForObject(String url,String params,Class clazz) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		HttpEntity<String> requestEntity = new HttpEntity<String>(params, httpHeaders);
		Object result = null;
		
		try {
			result = rest.postForObject(url, requestEntity, clazz);
		} catch (Throwable throwable) {
			log.error("Post 请求异常", throwable);
		}
		
		return result;
	}
	
	@SuppressWarnings("all")
	public static ResponseEntity<?> postForEntity(String url, LinkedMultiValueMap<String, String> params, Class clazz) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<LinkedMultiValueMap<String, String>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, String>>(params, headers);
		//Object result = null;
		ResponseEntity<String> response = null;
		try {
			
//			result = rest.postForObject(url, request, responseType, uriVariables).postForObject(url, clazz, requestEntity);
			//result = rest.postForEntity(url, request, responseType)
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
			response = rest.postForEntity( url, request , String.class );
			
		} catch (Throwable throwable) {
			log.error("Post 请求异常", throwable);
		}
		
		return response;
	}
	
	
	@SuppressWarnings("all")
	public static ResponseEntity<?> getForEntity(String url, LinkedMultiValueMap<String, String> params, Class clazz) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<LinkedMultiValueMap<String, String>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, String>>(params, headers);
		//Object result = null;
		ResponseEntity<String> response = null;
		try {
			
//			result = rest.postForObject(url, request, responseType, uriVariables).postForObject(url, clazz, requestEntity);
			//result = rest.postForEntity(url, request, responseType)
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
			response = rest.getForEntity(url, String.class, request);
			
		} catch (Throwable throwable) {
			log.error("Get 请求异常", throwable);
		}
		
		return response;
	}
	

	@SuppressWarnings("all")
	public static Object getForObject(String url, LinkedMultiValueMap<String, String> params, Class clazz) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<LinkedMultiValueMap<String, String>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, String>>(params, httpHeaders);
		Object result = null;
		try {
			result = rest.getForObject(url, clazz, requestEntity);
		} catch (Throwable throwable) {
			log.error("Get 请求异常", throwable);
		}
		
		return result;
	}
}
