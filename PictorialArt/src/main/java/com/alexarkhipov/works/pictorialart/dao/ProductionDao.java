/**
 * 
 */
package com.alexarkhipov.works.pictorialart.dao;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Production;

/**
 * @author arkhipov
 *
 */
public interface ProductionDao {
	List<Production> getProductions();
	public List<Production> getProductions(Integer qty);
	// Return 'productions' of particular 'author'
	List<Production> getProductions(String author);

	Production getProduction(Integer prodId);

	Production getProductionEx(Integer prodId);

	void saveProduction(Production p);
}
