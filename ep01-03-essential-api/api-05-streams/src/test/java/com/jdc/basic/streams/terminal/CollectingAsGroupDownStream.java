package com.jdc.basic.streams.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jdc.streams.domain.Sale;

public class CollectingAsGroupDownStream {

	@Test
	void test_group_and_collect_product() {
		
		try(var stream = Files.lines(Path.of("data","sales.txt"))) {
			
			System.out.println("""
					
					Group by category and collect product 
						""");
			
			var result = stream
					.map(line -> line.split("\t"))
					.map(Sale::from)
					.collect(Collectors.groupingBy(
							Sale::category,
							Collectors.mapping(Sale::product, Collectors.toCollection(() -> new TreeSet<>()))
							));
			
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_group_and_collect_sum() {
		
		try(var stream = Files.lines(Path.of("data","sales.txt"))) {
			
			System.out.println("""
					
					Group by category and collect sum
						""");
			
			var result = stream
					.map(line -> line.split("\t"))
					.map(Sale::from)
					.collect(Collectors.groupingBy(
							sale -> sale.saleAt().toLocalDate(),
							Collectors.mapping(Sale::getTotal,
									Collectors.reducing(0,(a,b)-> a+b))
							));
			
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
