package file;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTest {
	public static void main(String[] args) throws IOException {
		FileTest obj = new FileTest();
	}

	private String getFilePathFromClassPath() {
		String str = getClass().getClassLoader().getResource("test.json").getPath();
		System.out.println(str.substring(1, str.length()));
		return str.substring(1, str.length());
	}

	private void readUsingStream() throws IOException {
		Stream<String> lines = Files.lines(Paths.get(new FileTest().getFilePathFromClassPath()));
		String str = lines.map(String::trim).collect(Collectors.joining());
		lines.close();
		System.out.println(str);
	}

	private void readUsingNio() throws IOException {
		Path path = Paths.get(new FileTest().getFilePathFromClassPath());
		byte[] byteArr = Files.readAllBytes(path);
		String content = new String(byteArr);
		System.out.println("Content->" + content);
	}

	private void bufferedWritter() throws IOException {
		// Get the file reference
		Path path = Paths.get("c:/output.txt");

		// Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write("Hello World !!");
		}
	}

}
