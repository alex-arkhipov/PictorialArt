/**
 * 
 */
package com.alexarkhipov.works.pictorialart.dao;

import com.alexarkhipov.works.pictorialart.model.Description;

/**
 * @author arkhipov
 *
 */
public interface DescriptionDao {

	Description getDescription(Integer dId);

	Integer saveDescription(Description d);

	Description saveDescription(String desc);
}
