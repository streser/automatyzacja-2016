/*
package com.nokia.unittests;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class WyszukiwanieElementuPoIndeksie {

	//@Before
	//
	
	@Test
	public void wyszukZwracaEl0(){
	// given
	// nieprzypisana wartosc tab[0]
		//int arr[] = int[3];

	//when
		arr[0] = 0;
		int i = 0;
		
	//then
		Assert.assertThat(arr[0], IsEqual.equalTo(i));
		//System.out.println(arr[0]);
	}

	@Test
	public void wyszukZwracaEl1() {
		// given
		String arr[] = new String[3];

		arr[0] = "el1";

		// when
		String e = "el1";

		// then
		Assert.assertThat(arr[0], IsEqual.equalTo(e));
	}

}

// git add
// git commit (akceptacja zmian lokalnie)
// git pull (pobranie z serwera)
// git push origin master:rafalh
*/