package com.gaurav.karaf.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.gaurav.karaf.model.Karaf;
import com.gaurav.karaf.model.KarafService;

public class KarafServiceImpl implements KarafService {
Map<String, Karaf> taskMap;
	
	public KarafServiceImpl() {
		taskMap = new HashMap<String, Karaf>();
		Karaf task = new Karaf();
		task.setId("1");
		task.setTitle("Buy some coffee");
		task.setDescription("Take the extra strong");
		addKaraf(task);
		task = new Karaf();
		task.setId("2");
		task.setTitle("Finish karaf tutorial");
		task.setDescription("Last check and wiki upload");
		addKaraf(task);
	}
	
	public Karaf getKaraf(String id) {
		return taskMap.get(id);
	}

	public void addKaraf(Karaf task) {
		taskMap.put(task.getId(), task);
	}

	
	public Collection<Karaf> getKarafs() {
		// taskMap.values is not serializable
		return new ArrayList<Karaf>(taskMap.values());
	}

    public void updateKaraf(Karaf task) {
        taskMap.put(task.getId(), task);        
    }

    public void deleteKaraf(String id) {
        taskMap.remove(id);
    }

}
