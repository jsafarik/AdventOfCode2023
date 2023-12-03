package parameters

enum ParameterType {
	STRING, TEXT, BOOLEAN, CHOICE

	static Closure getParametersClosure(Parameter... parameters) {
		return parameters.reverse().collect {param ->
			switch (param.type) {
				case STRING:
					return { stringParam(param.name(), param.defaultValue, param.description) }
				case TEXT:
					return { textParam(param.name(), param.defaultValue, param.description) }
				case BOOLEAN:
					return { booleanParam(param.name(), param.defaultValue, param.description) }
				case CHOICE:
					return { choiceParam(param.name(), param.defaultValue, param.description) }
			}
		}.inject({}) { Closure init, Closure param -> init << param }
	}
}
