enum Digit {
	ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}

int getResult(String input, boolean countSpelledNumbers) {
	return input.split('\n')
		.collect { String value ->
			String numbers = ""
			value.toCharArray().eachWithIndex { char entry, int i ->
				if (Character.isDigit(entry)) {
					numbers += entry
				} else if (countSpelledNumbers) {
					Digit digit = Digit.values().find { value.substring(i).startsWith(it.name().toLowerCase()) }
					if (digit) {
						numbers += digit.ordinal().toString()
					}
				}
			}
			return numbers ? numbers.toCharArray()[0, -1].join("") as int : 0
		}.sum()
}

String input = params.INPUT.trim()

println("Part 1: ${getResult(input, false)}")
println("Part 2: ${getResult(input, true)}")
