package com.gaurav.karaf.model;

import java.util.Collection;

public interface KarafService {
	Karaf getKaraf(String id);
	void addKaraf(Karaf karaf);
	void updateKaraf(Karaf karaf);
	void deleteKaraf(String id);
	Collection<Karaf> getKarafs();
}
