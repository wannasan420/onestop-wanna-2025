package com.jdc.basic.streams.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jdc.streams.domain.Sale;

public class GroupAndJoin {

	@Test
	void test_join_product() {
	
			try(var stream = Files.lines(Path.of("data","sales.txt"))) {
				
				System.out.println("""
						
						Group and join
						""");
				var result = stream
						.map(line -> line.split("\t"))
						.map(Sale::from)
						.map(Sale::product)
						.distinct()
						.collect(Collectors.joining(","));
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	@Test
	void test_group_and_join() {
	
			try(var stream = Files.lines(Path.of("data","sales.txt"))) {
				
				System.out.println("""
						
						Group and join
						""");
				var result = stream
						.map(line -> line.split("\t"))
						.map(Sale::from)
						.collect(Collectors.groupingBy(
								Sale::category,
								Collectors.mapping(Sale::product, Collectors.joining(","))));
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
