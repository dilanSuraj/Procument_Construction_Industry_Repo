package com.procument.construction.industry.app.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.procument.construction.industry.app.entity.Site;

public interface SiteRepository extends CrudRepository<Site, Long>{

	Site findBySiteid(Long siteid);
	
    @Transactional
    void deleteBySiteid(Long siteid);
}
