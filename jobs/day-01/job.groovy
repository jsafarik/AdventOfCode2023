import parameters.Parameter
import parameters.ParameterType

pipelineJob('day-01') {
	parameters ParameterType.getParametersClosure(Parameter.INPUT)
	definition {
		cps {
			script(readFileFromWorkspace("jobs/day-01/pipeline.groovy"))
			sandbox(true)
		}
	}
}
