package com.aindriu;

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

}
