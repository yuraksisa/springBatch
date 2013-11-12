package com.batch.springbatch.jobs.writers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.batch.springbatch.jobs.model.CountryModel;

public class CountryItemWriter<T> implements ItemWriter<T> {

  private ItemWriter<T> delegateAM;
  private ItemWriter<T> delegateNZ;
    
  public void setDelegateAM(ItemWriter<T> delegateAM) {
	this.delegateAM = delegateAM;
  }
  
  public void setDelegateNZ(ItemWriter<T> delegateNZ) {
	this.delegateNZ = delegateNZ; 
  }

 
  public void write(List<? extends T> list) throws Exception {
	
	List<T> listAM = new ArrayList<T>();
	List<T> listNZ = new ArrayList<T>();
	
	for (int i=0; i<list.size(); i++) {
	  if (((CountryModel) list.get(i)).getCountry().startsWith("A") ) {
		listAM.add(list.get(i));  
	  }
	  else {
		listNZ.add(list.get(i));
	  }
	}
	
	if (listAM.size() > 0) {
	  delegateAM.write(listAM);
	}
	if (listNZ.size() > 0) {
  	  delegateNZ.write(listNZ);
	}
  }
  
	
}
