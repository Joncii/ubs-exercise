package ubs.exercise.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class PropertyReaderService {

	public Properties read(String path){
		Properties properties = new Properties();
		try(InputStream is = PropertyReaderService.class.getClassLoader().getResourceAsStream(path)){
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
}
