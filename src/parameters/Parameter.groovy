package parameters

enum Parameter {
	INPUT("", "Puzzle input", ParameterType.TEXT)

	def defaultValue
	String description
	ParameterType type

	Parameter(def defaultValue, String description = "", ParameterType type) {
		this.defaultValue = defaultValue
		this.description = description
		this.type = type
	}
}
