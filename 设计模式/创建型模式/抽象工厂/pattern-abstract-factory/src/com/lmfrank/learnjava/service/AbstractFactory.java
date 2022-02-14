package com.lmfrank.learnjava.service;

public interface AbstractFactory {

    HtmlDocument createHtml(String md);

    WordDocument createWord(String md);
}
