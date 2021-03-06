// Copyright (C) 2015 Marcio Alexandre Pereira da Silva
// All Rights Reserved.

// This file is part of jeasyXBRL-0.3.

// jeasyXBRL-0.3 is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.jeasyXBRL-0.3 is distributed in the 
// hope that it will be useful,but WITHOUT ANY WARRANTY; without even the 
// implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
// See the GNU General Public License for more details. You should check 
// the GNU General Public License in the link <http://www.gnu.org/licenses/>.

//  @author Marcio Alexandre
//  @email marcio.alexandre83@gmail.com
//  @site xbrlframework.com | marcioalexandre.wordpress.com
//  @since 2015-09-22

package com.jeasyxbrl.conn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class Connection {
	
	/*
	 * 
	 * @param filename "just the path and name of XML file"
	 */
	
	public BufferedReader getConnection(String filename){
		try {
			return new BufferedReader (new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.print("Error [jeasyxbrl].[conn].[Connection.java] "+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public String getConnectionGuava(String filename){ //google guava cache idea
		String contents = null;
		try {
			contents = Files.toString(new File(filename), Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contents;
	}	
	/*
	 * Actually I'm not using this method, but it's still here for future coding, though
	 * unfortuntely, this method sets my library in CC (cyclomatic complexity) number 4.
	 * before it, the CC was 2.
	 * 
	 * @param filename "just the path and name of XML file"
	 */
	public Document getConnectionXML(String filename){
		Document doc = null;
		try {
			File inputFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = null;
			dBuilder = dbFactory.newDocumentBuilder();
			try {
				doc = dBuilder.parse(inputFile);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return doc;
	}
}
