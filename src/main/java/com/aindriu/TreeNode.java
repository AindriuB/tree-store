package com.aindriu;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author andrewbannister
 */

public class TreeNode {

	private static final Logger LOGGER = LoggerFactory.getLogger(TreeNode.class);

	private Map<Character, TreeNode> treeStore;

	public TreeNode() {
		treeStore = new HashMap<Character, TreeNode>();
	}

	public boolean checkExists(String data) throws Exception {
		if (data.isEmpty() || data == null) {
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("Data Empty | returning false");
			}
			return false;
		} else {
			char key = data.charAt(0);
			TreeNode nextNode = treeStore.get(key);
			if (nextNode != null) {
				String remainder = data.substring(1);
				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("Traverse in to next node in tree | key : {} ", key);
				}
				return nextNode.checkExists(remainder);
			} else {
				if (data.length() == 1) {
					if (LOGGER.isTraceEnabled()) {
						LOGGER.trace("Foudnd  leaf node | key : {} | returning true", key);
					}
					return true;
				} else {
					if (LOGGER.isTraceEnabled()) {
						LOGGER.trace("Found leaf node, but data remaining | key : {} | returning false", key);
					}
					return false;
				}

			}
		}

	}

	public boolean insert(String data) throws Exception {
		if (data.isEmpty() || data == null) {
			throw new Exception("Data is empty");
		}
		char key = data.charAt(0);

		if (data.length() == 1) {
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("Adding leaf node to tree | key: {}", key);
			}
			treeStore.put(key, null);
		} else {
			if (treeStore.containsKey(key)) {
				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("Adding data to already existing branch | key: {}", key);
				}
				TreeNode nextNode = treeStore.get(key);
				nextNode.insert(data.substring(1));
			} else {
				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("Adding new branch to tree | key: {}", key);
				}
				TreeNode nextNode = new TreeNode();
				nextNode.insert(data.substring(1));
				treeStore.put(key, nextNode);
			}
		}
		return true;
	}
}
