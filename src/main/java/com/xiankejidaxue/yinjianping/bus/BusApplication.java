package com.xiankejidaxue.yinjianping.bus;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@Log4j2
public class BusApplication {

	public static void main(String[] args) {

//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//
//		System.out.println("opencv version is :"+Core.VERSION);
//		Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
//		System.out.println("OpenCV Mat: " + m);
//		Mat mr1 = m.row(1);
//		mr1.setTo(new Scalar(1));
//		Mat mc5 = m.col(5);
//		mc5.setTo(new Scalar(5));
//		System.out.println("OpenCV Mat data:\n" + m.dump());

//		ArrayList<Object> set1 = new ArrayList<Object>(Arrays.asList(new String[]{"red","yellow","green"}));
//		ArrayList<Object> set2 = new ArrayList<Object>(Arrays.asList(new String[]{"red","yellow","blue"}));


		SpringApplication.run(BusApplication.class, args);
	}
}
