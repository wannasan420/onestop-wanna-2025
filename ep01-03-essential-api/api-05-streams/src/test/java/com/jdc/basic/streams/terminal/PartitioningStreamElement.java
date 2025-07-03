package com.jdc.basic.streams.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jdc.streams.domain.Sale;

public class PartitioningStreamElement {

	@Test
	void test_partitioning() {
		try(var stream = Files.lines(Path.of("data","sales.txt"))) {
			
			System.out.println("""
					
					Partitioning
					""");
			var result = stream
					.map(line -> line.split("\t"))
					.map(Sale::from)
					.collect(Collectors.partitioningBy(sale -> sale.getTotal() <10000 ));
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test_partitioning_downstream() {
		try(var stream = Files.lines(Path.of("data","sales.txt"))) {
			
			System.out.println("""
					
					Partitioning downstream
					""");
			var result = stream
					.map(line -> line.split("\t"))
					.map(Sale::from)
					.collect(Collectors.partitioningBy(
							sale -> sale.getTotal() <10000,
							Collectors.groupingBy(Sale::product,
									Collectors.reducing(0,Sale::getTotal,(a,b) -> a+b))));
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
