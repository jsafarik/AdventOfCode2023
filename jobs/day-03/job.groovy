import parameters.Parameter
import parameters.ParameterType

pipelineJob('day-03') {
	parameters ParameterType.getParametersClosure(Parameter.INPUT)
	definition {
		cps {
			script(readFileFromWorkspace("jobs/day-03/pipeline.groovy"))
			sandbox(true)
		}
	}
}
