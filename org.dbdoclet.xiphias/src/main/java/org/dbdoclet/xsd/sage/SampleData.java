package org.dbdoclet.xsd.sage;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.dbdoclet.service.FileServices;

public class SampleData implements SampleDataParserVisitor {

	private int counter = 0;
	private int lastIndex;
	
	private String lastValue;

	private String optionName;
	private HashMap<String, String> options;
	private Random rand;
	private TreeMap<String, Integer> statisticMap;
	private ArrayList<String> values;
	
	public SampleData() {

		values = new ArrayList<String>();
		options = new HashMap<String, String>();
		statisticMap = new TreeMap<String, Integer>();
		rand = new Random();
	}

	public SampleData(File file) throws UnsupportedEncodingException,
			ParseException, IOException {
		this(FileServices.readToString(file));
	}

	public SampleData(String buffer) throws UnsupportedEncodingException,
			ParseException {

		this();

		NodeRoot root = SampleDataParser.parse(buffer);
		traverseNodes(root, this);
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public String getLastValue() {
		return lastValue;
	}

	public String getOption(String name) {
		return options.get(name);
	}
	
	public Map<String, Integer> getStatistics() {
		return statisticMap;
	}

	public String getValue(int index) {

		if (index < 0 || index >= values.size()) {
			return null;
		}
		
		String value = values.get(index);
		value = value.replace("${%03d}", String.format("%03d", counter));
		counter++;

		Integer usage = statisticMap.get(value);

		if (usage == null) {
			statisticMap.put(value, Integer.valueOf(1));
		} else {
			statisticMap.put(value, Integer.valueOf(usage.intValue() + 1));
		}

		lastValue = value;
		lastIndex = index;
		
		return value;
	}

	public String getValue() {

		int index = rand.nextInt(values.size());
		return getValue(index);
	}

	public ArrayList<String> getValues() {
		return values;
	}

	public boolean isFollowsEnabled() {
	
		if (options.get("follows") != null) {
			return true;
		}
		
		return false;
	}

	public void setValue(String value) {
		
		values.clear();
		values.add(value);
	}

	public void setValues(ArrayList<String> enumList) {
		
		values.clear();

		for (String e : enumList) {
			values.add(e);
		}
	}

	public Object visit(NodeOptionName node, Object data) {

		optionName = node.getValue();
		return null;
	}

	public Object visit(NodeOptionValue node, Object data) {

		options.put(optionName, node.getValue());
		return null;
	}

	public Object visit(NodeRoot node, Object data) {
		return null;
	}

	public Object visit(NodeValue node, Object data) {

		String value = node.getValue();

		if (value != null && value.trim().length() > 0) {
			values.add(node.getValue());
		}

		return null;
	}

	public Object visit(SimpleNode node, Object data) {
		return null;
	}

	private void traverseNodes(SimpleNode node, SampleDataParserVisitor visitor) {

		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			SimpleNode sn = (SimpleNode) node.jjtGetChild(i);
			sn.jjtAccept(visitor, null);
			traverseNodes(sn, visitor);
		}
	}
}
