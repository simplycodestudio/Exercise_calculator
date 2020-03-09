package calculation_steps;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Step {
	@NonNull
	private String operator;
	@NonNull
	private int number;

}
