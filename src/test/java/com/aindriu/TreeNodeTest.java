package com.aindriu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author andrewbannister
 *
 */

public class TreeNodeTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TreeNodeTest.class);

	/**
	 * Test method for {@link com.aindriu.TreeNode#checkExists(java.lang.String)}.
	 * @throws Exception 
	 */

	@Before
	public void setUp() {
		System.setProperty("logback.configurationFile", "logback.xml");
	}

	@Test
	public void testCheckExists() throws Exception {
		TreeNode rootNode = new TreeNode();
		String uuid = UUID.randomUUID().toString();
		LOGGER.debug("Checking for uuid:{}", uuid);
		assertFalse(rootNode.checkExists(uuid));
	}

	/**
	 * Test method for {@link com.aindriu.TreeNode#insert(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testInsertFork() throws Exception {
		TreeNode rootNode = new TreeNode();
		String uuid = "123456789";
		String uuidFork = "1234512345";
		LOGGER.debug("Inserting uuid:{}", uuid);
		assertTrue(rootNode.insert(uuid));

		LOGGER.debug("Inserting forked uuid:{}", uuidFork);
		assertTrue(rootNode.insert(uuidFork));
	}

	/**
	 * Test method for {@link com.aindriu.TreeNode#insert(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testInsert() throws Exception {
		TreeNode rootNode = new TreeNode();
		String uuid = UUID.randomUUID().toString();
		LOGGER.debug("Inserting uuid:{}", uuid);
		assertTrue(rootNode.insert(uuid));
	}

	/**
	 * Test method for {@link com.aindriu.TreeNode#insert(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testInsertAndCheck() throws Exception {
		TreeNode rootNode = new TreeNode();
		String uuid = UUID.randomUUID().toString();
		LOGGER.debug("Inserting uuid:{}", uuid);
		assertTrue(rootNode.insert(uuid));
		LOGGER.debug("Searching uuid:{}", uuid);
		assertTrue(rootNode.checkExists(uuid));
	}

	/**
	 * Test method for {@link com.aindriu.TreeNode#insert(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testInsertAndCheckSmaller() throws Exception {
		TreeNode rootNode = new TreeNode();
		String uuid = UUID.randomUUID().toString();
		LOGGER.debug("Inserting uuid:{}", uuid);
		assertTrue(rootNode.insert(uuid));
		LOGGER.debug("Searching uuid:{}", uuid.subSequence(0, uuid.length() - 1));
		assertFalse(rootNode.checkExists(uuid.subSequence(0, uuid.length() - 1).toString()));
		LOGGER.debug("Searching uuid:{}", uuid);
		assertTrue(rootNode.checkExists(uuid));
	}

	@Test
	public void testEmptyDataExists() {
		TreeNode rootNode = new TreeNode();
		assertFalse(rootNode.checkExists(""));
	}

	@Test
	public void testNullExists() throws Exception {
		TreeNode rootNode = new TreeNode();
		assertFalse(rootNode.checkExists(null));

	}

	@Test
	public void testEmptyDataInsert() {
		TreeNode rootNode = new TreeNode();
		try {
			rootNode.insert("");
		} catch (Exception e) {
			assertEquals("Data is empty", e.getMessage());
		}
	}

	@Test
	public void testNullInsert() {
		TreeNode rootNode = new TreeNode();
		try {
			rootNode.insert(null);
		} catch (Exception e) {
			assertEquals("Data is empty", e.getMessage());
		}
	}

}
