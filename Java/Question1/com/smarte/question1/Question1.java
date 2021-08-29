package com.smarte.question1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question1 {

	public static void main(String[] args) {
		String filePath = "E:\\Interview Stuff\\SMARTe\\india_phoneno_not_null";

		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

			// Store file records into a list
			List<ContactInfo> contactInfList = stream.map(Question1::getContactInfo).collect(Collectors.toList());

			// Prepare a city-wise map
			Map<String, List<ContactInfo>> collect = contactInfList.stream()
					.collect(Collectors.groupingBy(ContactInfo::getCity));

			String outputRowFormat = "%-30s\t%-25s\t%-10s\t%s\t%s";
			System.out.println(String.format(outputRowFormat, "City", "State", "Country", "City Code", "#Records"));
			for (String key : collect.keySet()) {

				List<ContactInfo> list = collect.get(key);
				ContactInfo contactInfo = getCityCode(list);
				System.out.println(String.format(outputRowFormat, contactInfo.getCity(), contactInfo.getState(),
						contactInfo.getCountry(), contactInfo.getCityCode(), list.size()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ContactInfo getCityCode(List<ContactInfo> list) {
		int votes = 0;
		String cityCode = null;
		ContactInfo ans = null;

		for (ContactInfo contactInfo : list) {
			if (votes == 0) {
				cityCode = contactInfo.getCityCode();
				ans = contactInfo;
				votes = 1;
			} else {
				if (contactInfo.getCityCode().equals(cityCode)) {
					votes++;
				} else {
					votes--;
				}
			}
		}

		return ans;
	}

	private static ContactInfo getContactInfo(String string) {
		ContactInfo contactInfo = new ContactInfo();
		String[] inputArr = string.split("\\t");
		contactInfo.setPhoneNo(inputArr[0]);
		contactInfo.setCity(inputArr[1]);
		contactInfo.setState(inputArr[2]);
		contactInfo.setCountry(inputArr[3]);
		contactInfo.setCityCode("0" + inputArr[0].substring(0, 2));

		return contactInfo;
	}

}
