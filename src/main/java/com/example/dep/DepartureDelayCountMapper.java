package com.example.dep;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.example.parser.AirlinePerformanceParser;

public class DepartureDelayCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	// 맵 출력 값
	final IntWritable one = new IntWritable(1);
	// 맵 출력 키 
	Text outputkey = new Text();

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		AirlinePerformanceParser parser = new AirlinePerformanceParser(value);
		
		if (parser.isDepartureDelayAvailable()) {
			if (parser.getDepartureDelayTime() > 0) {
				//출력 키 설정 
				outputkey.set(parser.getYear() + "");
				//출력 데이터 생성 
				context.write(outputkey, one);
			}

		}
	}

}
