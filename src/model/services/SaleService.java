package model.services;
import java.util.List;

import entities.Sale;
public class SaleService {
	public double filteredSum(List<Sale> list) {
		double sum = 0.0;
		for(Sale s : list) {
			if(s.getSeller().charAt(0) == 'T') {
				sum += s.getPrice();
			}
		}
		return sum;
	}
}
