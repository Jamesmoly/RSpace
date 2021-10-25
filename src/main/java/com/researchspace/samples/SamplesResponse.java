package com.researchspace.samples;

import java.util.List;

import com.researchspace.samples.model.LinkItemList;
import com.researchspace.samples.model.Sample;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SamplesResponse {

	private int totalHits;
	private int pageNumber;
	private List<Sample> samples;
	private LinkItemList _links;
}
