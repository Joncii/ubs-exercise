package ubs.exercise.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PropertyReaderService {
	
	private static final Logger LOG = LoggerFactory.getLogger(PropertyReaderService.class);

	public Properties read(String path){
		Properties properties = new Properties();
		try(InputStream is = PropertyReaderService.class.getClassLoader().getResourceAsStream(path)){
			properties.load(is);
		} catch (IOException e) {
			LOG.error("Property file does not exist. Embedded exception message: " + e.getMessage());
		}
		return properties;
	}
	
}
