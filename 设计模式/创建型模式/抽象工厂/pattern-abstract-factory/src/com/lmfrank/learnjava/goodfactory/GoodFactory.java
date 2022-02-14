package com.lmfrank.learnjava.goodfactory;

import com.lmfrank.learnjava.service.AbstractFactory;
import com.lmfrank.learnjava.service.HtmlDocument;
import com.lmfrank.learnjava.service.WordDocument;

public class GoodFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new GoodHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new GoodWordDocument(md);
	}
}
