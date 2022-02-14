package com.lmfrank.learnjava.fastfactory;

import com.lmfrank.learnjava.service.AbstractFactory;
import com.lmfrank.learnjava.service.HtmlDocument;
import com.lmfrank.learnjava.service.WordDocument;

public class FastFactory implements AbstractFactory {

    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument(md);
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument(md);
    }
}
