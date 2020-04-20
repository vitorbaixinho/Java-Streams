package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

	@Test
	public void joiningStrings() throws Exception {
		List<String> names = ImmutableList.of("anna", "john", "marcos",
				"helena", "yasmin");

		String result = "";
		for (int i = 0; i < names.size(); i++) {
			result = result + names.get(i);
			if (i < names.size() - 1) {
				result = result + ",";
			}
		}
		System.out.println(result);
	}

	@Test
	public void joiningStringsWithStream() throws Exception {
		List<String> names = ImmutableList.of("anna", "john", "marcos",
				"helena", "yasmin");
		
		String join = names.stream().collect(Collectors.joining(", "));
		
		System.out.println(join);

	}
}
