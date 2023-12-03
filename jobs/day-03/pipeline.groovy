enum ColorCode {
	RESET(0),
	BOLD(1),
	BLACK(30),
	RED(31),
	GREEN(32),
	YELLOW(33),
	BLUE(34),
	MAGENTA(35),
	CYAN(36),
	WHITE(37)

	int code

	ColorCode(code) {
		this.code = code
	}

	String colored(String text) {
		String requestedStyle = "\u001B[${this.code}m"
		String resetStyle = "\u001B[${RESET.code}m"
		return requestedStyle + text + resetStyle
	}
}

class Point {
	int x, y

	@NonCPS
	boolean equals(o) {
		return o.x == this.x && o.y == this.y
	}

	@NonCPS
	int hashCode() {
		return x * 11 + y
	}
}

String input = params.INPUT.trim()

String viz = ""

List<List<Character>> engine = input.split("\n").collect { return it.toCharArray().toList() }

List<Integer> engineParts = []
Map<Point, List<Integer>> gears = [:]

engine.eachWithIndex { List<Character> row, int rowIndex ->
	String currentNum = ""
	boolean shouldAddPart = false
	Point gear = null
	row.eachWithIndex { char enginePoint, int columnIndex ->
		if (enginePoint.isDigit()) {
			currentNum += enginePoint
			(rowIndex - 1..rowIndex + 1).each { int tempRowIndex ->
				(columnIndex - 1..columnIndex + 1).each { int tempColumnIndex ->
					char checked
					if (tempRowIndex >= 0 && tempRowIndex < engine.size() && tempColumnIndex >= 0 && tempColumnIndex < row.size()) {
						checked = engine[tempRowIndex][tempColumnIndex]
						shouldAddPart |= checked != '.'.toCharacter() && !checked?.isDigit()
					}

					if (checked == '*'.toCharacter()) {
						gear = new Point(x: tempColumnIndex, y: tempRowIndex)
					}
				}
			}
		}

		if (!enginePoint.isDigit() || columnIndex == row.size() - 1) {
			if (shouldAddPart) {
				engineParts.add(currentNum.toInteger())
				viz += ColorCode.GREEN.colored(currentNum)

				if (gear) {
					List currentList = gears[gear] ?: []
					gears.put(gear, currentList + currentNum.toInteger())
				}
			} else {
				viz += currentNum
			}
			viz += enginePoint.isDigit() ? "" : enginePoint
			currentNum = ""
			shouldAddPart = false
			gear = null
		}
	}
	viz += "\n"
}

ansiColor("xterm") {
	println(viz)
}

println("Part 1: ${engineParts.sum()}")
println("Part 2: ${gears.findAll { it.value.size() >= 2 }.collect { it.value.inject(1) { int init, int value -> init * value } }.sum()}")
