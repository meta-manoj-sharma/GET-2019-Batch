package commandprompt;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class CommandTest {

	@Test
	public void mkdirTest() {
		Folder root = new Folder("test");
		assertTrue(root.mkdir("test"));
	}

	@Test
	public void findfolderTest() {
		Folder root = new Folder("test");
		assertTrue(root.mkdir("test"));
		assertTrue(root.mkdir("test2"));
		assertTrue(root.mkdir("test3"));
		String folder = root.find("test").getFolderName();
		assertEquals("test", folder);
	}

	@Test(expected = Exception.class)
	public void findfolderTestNegative() {
		Folder root = new Folder("test");
		assertTrue(root.mkdir("test"));
		assertTrue(root.mkdir("test2"));
		assertTrue(root.mkdir("test3"));
		String folder = root.find("hello").getFolderName();
	}
}
