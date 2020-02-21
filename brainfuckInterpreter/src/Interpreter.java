import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Interpreter {
	public static byte[] array = new byte[150];
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static boolean print = true;
	public static void main(String[] args) throws IOException {
		if(args.length == 1) {
			print = new Boolean(args[0]);
		}
		StringBuilder codeBuilder = new StringBuilder();
		Files.readAllLines(Paths.get("..\\sourceCode.bfck")).forEach(e -> codeBuilder.append(e));
		String srcCode = codeBuilder.toString();
		new Interpreter().run(srcCode);
	}
	public void run(String code) throws IOException {
		int pointer = 0;
		for(int i = 0; i < code.length(); i++) {
			int loop = 0;
			char c = code.charAt(i);
			print = false;
			switch(c) {
				case '<':
					pointer--;
					break;
				case '>':
					pointer++;
					break;
				case '+':
					array[pointer]++;
					print = true;
					break;
				case '-':
					array[pointer]--;
					print = true;
					break;
				case ',':
					array[pointer] = (byte) reader.readLine().charAt(0);
					break;
				case '.':
					System.out.println(array[pointer]);
					break;
				case '[':
					  if(array[pointer] == 0) {
		                    i++;
		                    while(loop > 0 || code.charAt(i) != ']') {
		                        if(code.charAt(i) == '[') loop++;
		                        if(code.charAt(i) == ']') loop--;
		                        i++;
		                    }
		                }
					break;
				case ']':
					 if(array[pointer] != 0) {
		                    i--;
		                    while(loop > 0 || code.charAt(i) != '[') {
		                        if(code.charAt(i) == ']') loop++;
		                        if(code.charAt(i) == '[') loop--;
		                        i--;
		                    }
		                    i--;
		                }
					break;
			}
			if(print)
				System.out.println(Arrays.toString(array));
		}
		
	}
	
}
